// TreatmentGroupsController.java
package com.edu.hospital.controller.registration;

import com.edu.hospital.pojo.TreatmentGroups;
import com.edu.hospital.service.treatmentGroup.TreatmentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatment-groups")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class TreatmentGroupsController {

    @Autowired
    private TreatmentGroupService treatmentGroupService;

    @PostMapping("/add")
    public boolean addTreatmentGroup(@RequestBody TreatmentGroups treatmentGroups) {
        return treatmentGroupService.addTreatmentGroup(treatmentGroups);
    }

    @GetMapping("/{id}")
    public TreatmentGroups getTreatmentGroupById(@PathVariable Integer id) {
        return treatmentGroupService.getTreatmentGroupById(id);
    }

    @GetMapping("/by-name/{realName}")
    public List<TreatmentGroups> getTreatmentGroupsByRealName(@PathVariable String realName) {
        return treatmentGroupService.getTreatmentGroupsByRealName(realName);
    }

    @DeleteMapping("/delete-by-name/{treatmentName}")
    public boolean deleteTreatmentGroupByRealName(@PathVariable String treatmentName) {
        return treatmentGroupService.deleteByRealName(treatmentName);
    }
}
