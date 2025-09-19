package com.edu.hospital.service.hospitalGuide;

public interface HospitalGuideService {
    /**
     * 与AI进行对话
     * @param sessionId 用户会话标识
     * @param userMessage 用户输入的消息
     * @return AI回复的内容
     */
    String chatWithAI(String sessionId, String userMessage) throws Exception;
}
