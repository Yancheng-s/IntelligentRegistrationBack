// TreatmentGroupService.java
package com.edu.hospital.service.treatmentGroup;

import com.edu.hospital.pojo.TreatmentGroups;
import java.util.List;

public interface TreatmentGroupService {

    boolean addTreatmentGroup(TreatmentGroups treatmentGroup);
    TreatmentGroups getTreatmentGroupById(Integer id);
    List<TreatmentGroups> getTreatmentGroupsByRealName(String realName); // 新增方法
    boolean deleteByRealName(String treatmentName);
}
