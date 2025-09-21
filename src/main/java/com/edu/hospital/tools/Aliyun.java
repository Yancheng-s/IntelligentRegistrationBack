package com.edu.hospital.tools;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Aliyun {

    private static final String API_KEY = "YOU-API_KEY";
    private static final String MODEL_NAME = "qwen-turbo";

    private static final ThreadLocal<List<Message>> threadLocalMessages = ThreadLocal.withInitial(ArrayList::new);

    // 定义提示词文件路径常量
    private static final String CHARACTER_DESIGN_PATH = "/prompt/CharacterDesign";
    private static final String DEPARTMENT_INFO_PATH = "/prompt/DepartmentInformation";
    private static final String INTERACTION_RULES_PATH = "/prompt/InteractionRules";
    private static final String SPECIAL_HANDLING_PATH = "/prompt/SpecialHandling";
    private static final String EXAMPLE_DIALOGUES_PATH = "/prompt/ExampleDialogues";
    private static final String KNOWLEDGE_BOUNDARY_PATH = "/prompt/KnowledgeBoundary";

    static {
        System.out.println("Initializing Aliyun component...");

        // 读取各个提示词文件内容
        String characterDesign = readPromptFile(CHARACTER_DESIGN_PATH);
        String departmentInfo = readPromptFile(DEPARTMENT_INFO_PATH);
        String interactionRules = readPromptFile(INTERACTION_RULES_PATH);
        String specialHandling = readPromptFile(SPECIAL_HANDLING_PATH);
        String exampleDialogues = readPromptFile(EXAMPLE_DIALOGUES_PATH);
        String knowledgeBoundary = readPromptFile(KNOWLEDGE_BOUNDARY_PATH);

        // 使用占位符方式构建系统提示词
        String systemPrompt = String.format("%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s",
                characterDesign, departmentInfo, interactionRules,
                specialHandling, exampleDialogues, knowledgeBoundary);

        // 初始化角色扮演
        List<Message> messages = threadLocalMessages.get();
        messages.add(createMessage(Role.SYSTEM, systemPrompt));

        System.out.println("Aliyun component initialized.");
    }

    public static String chat(List<String> chatHistory) {
        if (chatHistory == null || chatHistory.isEmpty()) {
            return "Error: Chat history is empty or invalid.";
        }

        try {
            // 获取当前线程的 messages
            List<Message> messages = threadLocalMessages.get();

            // 添加聊天历史到消息列表
            for (int i = 0; i < chatHistory.size(); i++) {
                if (i % 2 == 0) {
                    // 用户消息
                    messages.add(createMessage(Role.USER, chatHistory.get(i)));
                } else {
                    // AI消息
                    messages.add(createMessage(Role.ASSISTANT, chatHistory.get(i)));
                }
            }

            // 创建生成参数
            GenerationParam param = createGenerationParam(messages);
            // 调用生成方法
            GenerationResult result = callGenerationWithMessages(param);
            String response = result.getOutput().getChoices().get(0).getMessage().getContent();

            // 添加模型回复到聊天历史
            messages.add(createMessage(Role.ASSISTANT, response));

            return response;

        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        } finally {
            // 清理 ThreadLocal，避免内存泄漏
            threadLocalMessages.remove();
        }
    }

    private static GenerationParam createGenerationParam(List<Message> messages) {
        return GenerationParam.builder()
                .apiKey(API_KEY)
                .model(MODEL_NAME)
                .messages(messages)
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .topP(0.7)
                .build();
    }

    private static GenerationResult callGenerationWithMessages(GenerationParam param) throws ApiException, NoApiKeyException, InputRequiredException {
        Generation gen = new Generation();
        return gen.call(param);
    }

    private static Message createMessage(Role role, String content) {
        return Message.builder().role(role.getValue()).content(content).build();
    }

    /**
     * 读取提示词文件内容的工具方法
     * @param filePath 文件路径
     * @return 文件内容字符串
     */
    private static String readPromptFile(String filePath) {
        try (InputStream inputStream = Aliyun.class.getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            System.out.println("✅ Found: " + filePath);
            return content.toString().trim();

        } catch (IOException | NullPointerException e) {
            System.err.println("❌ Not found: " + filePath);
            e.printStackTrace();
            return "";
        }
    }
}
