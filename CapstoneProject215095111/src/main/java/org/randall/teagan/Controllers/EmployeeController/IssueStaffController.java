package org.randall.teagan.Controllers.EmployeeController;

import org.randall.teagan.Domain.Employee.IssueStaff;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.IssueStaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/issueStaff")
public class IssueStaffController {

    @Autowired
    @Qualifier("IssueStaffServiceImpl")
    IssueStaffServiceImpl issueStaffServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public IssueStaff create(@RequestBody IssueStaff issueStaff) {
        return issueStaffServiceImpl.create(issueStaff);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public IssueStaff update(@RequestBody IssueStaff issueStaff) {
        return issueStaffServiceImpl.update(issueStaff);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        issueStaffServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public IssueStaff read(@PathVariable String id) {
        return issueStaffServiceImpl.read(id);
    }

    @GetMapping(value = "/readIssueStaff/all")
    @ResponseBody
    public ArrayList<IssueStaff> getAll() {
        return issueStaffServiceImpl.getAll();
    }
}
