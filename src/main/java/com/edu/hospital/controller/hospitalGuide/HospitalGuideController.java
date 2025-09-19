package com.edu.hospital.controller.hospitalGuide;

import com.edu.hospital.service.hospitalGuide.HospitalGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api") // 统一添加API前缀
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class HospitalGuideController {

    @Autowired
    private HospitalGuideService hospitalGuideService;

    @PostMapping("/hospitalGuide/chat")
    public ResponseEntity<Map<String, String>> chatWithAI(@RequestBody Map<String, String> request) {
        try {
            String sessionId = request.get("sessionId");
            String userMessage = request.get("message");

            if (sessionId == null || sessionId.trim().isEmpty()) {
                // 如果sessionId为空，返回提示信息
                Map<String, String> response = new HashMap<>();
                response.put("data", "请先登录后再使用服务");
                return ResponseEntity.ok(response);
            }

            if (userMessage == null || userMessage.trim().isEmpty()) {
                throw new IllegalArgumentException("User message is required");
            }

            // 调用服务层方法，传入sessionId和用户消息
            String aiResponse = hospitalGuideService.chatWithAI(sessionId, userMessage);

            // 返回统一JSON格式
            Map<String, String> response = new HashMap<>();
            response.put("data", aiResponse);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("data", "AI服务暂时不可用");
            return ResponseEntity.ok(error);
        }
    }
}
