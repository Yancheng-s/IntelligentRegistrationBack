// TreatmentGroupServiceImpl.java
package com.edu.hospital.service.treatmentGroup.impl;

import com.edu.hospital.mapper.TreatmentGroupMapper;
import com.edu.hospital.pojo.TreatmentGroups;
import com.edu.hospital.service.treatmentGroup.TreatmentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentGroupServiceImpl implements TreatmentGroupService {

    @Autowired
    private TreatmentGroupMapper treatmentGroupMapper;

    @Override
    public boolean addTreatmentGroup(TreatmentGroups treatmentGroup) {
        try {
            treatmentGroupMapper.insertTreatmentGroup(treatmentGroup);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TreatmentGroups getTreatmentGroupById(Integer id) {
        return treatmentGroupMapper.selectById(id);
    }

    @Override
    public List<TreatmentGroups> getTreatmentGroupsByRealName(String realName) {
        return treatmentGroupMapper.selectByRealName(realName);
    }

    @Override
    public boolean deleteByRealName(String treatmentName) {
        try {
            treatmentGroupMapper.deleteByRealName(treatmentName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
