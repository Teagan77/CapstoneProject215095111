package org.randall.teagan.Controllers.MembershipController;

import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl.StudentMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentMemController {

    @Autowired
    @Qualifier("StudentMemberServiceImpl")
    StudentMemberServiceImpl studentMemberServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public StudentMember create(@RequestBody StudentMember studentMember) {
        return studentMemberServiceImpl.create(studentMember);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public StudentMember update(@RequestBody StudentMember studentMember) {
        return studentMemberServiceImpl.update(studentMember);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        studentMemberServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public StudentMember read(@PathVariable String id) {
        return studentMemberServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<StudentMember> getAll() {
        return studentMemberServiceImpl.getAll();
    }
}
