package com.edu.hospital.service.hospitalGuide.impl;

import com.edu.hospital.service.hospitalGuide.HospitalGuideService;
import com.edu.hospital.tools.Aliyun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class HospitalGuideServiceImpl implements HospitalGuideService {

    @Autowired
    private Aliyun aliyun;

    // 使用ConcurrentHashMap存储每个用户的聊天历史
    private final Map<String, List<String>> userChatHistory = new ConcurrentHashMap<>();

    @Override
    public String chatWithAI(String sessionId, String userMessage) throws Exception {
        try {
            // 获取当前用户的聊天历史
            List<String> chatHistory = userChatHistory.getOrDefault(sessionId, new ArrayList<>());

            // 将用户消息添加到聊天历史中
            chatHistory.add(userMessage);

            // 调用AI进行对话，传入聊天历史和用户消息
            String aiResponse = aliyun.chat(chatHistory);

            // 将AI的回复也添加到聊天历史中
            chatHistory.add(aiResponse);

            // 更新用户的聊天历史
            userChatHistory.put(sessionId, chatHistory);

            return aiResponse;
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常堆栈信息
            throw e; // 重新抛出异常
        }
    }
}
