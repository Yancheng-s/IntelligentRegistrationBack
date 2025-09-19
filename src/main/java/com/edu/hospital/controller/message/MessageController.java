// MessageController.java
package com.edu.hospital.controller.message;

import com.edu.hospital.pojo.TreatmentGroups;
import com.edu.hospital.service.registration.RegisterService;
import com.edu.hospital.service.treatmentGroup.TreatmentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search_register-groups_by_treatment-groups")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private TreatmentGroupService treatmentGroupService;

    @Autowired
    private RegisterService registerService;

    /**
     * 根据 real_name 获取挂号信息列表
     */
    @GetMapping("/{realName}")
    public List<Map<String, Object>> getRegisterGroupsByRealName(@PathVariable String realName) {
//        System.out.println("realName: " + realName);
        // 1. 调用 treatmentGroupService 获取 treatment_name 列表
        List<String> treatmentNames = treatmentGroupService.getTreatmentGroupsByRealName(realName)
                .stream()
                .map(TreatmentGroups::getTreatmentName)
                .filter(name -> name != null && !name.isEmpty()) // 过滤空值
                .collect(Collectors.toList());

        // 2. 如果没有 treatment_name，返回空列表
        if (treatmentNames.isEmpty()) {
            return new ArrayList<>();
        }

        // 3. 循环调用 registerService 的 getAlreadyRegisterPatients 方法（单个 treatment_name）
        List<Map<String, Object>> result = new ArrayList<>();
        for (String treatmentName : treatmentNames) {
            List<Map<String, Object>> patients = registerService.getAlreadyRegisterPatients(treatmentName);
            result.addAll(patients); // 合并结果
        }

        // 4. 返回合并后的挂号信息列表
        return result;
    }
}
