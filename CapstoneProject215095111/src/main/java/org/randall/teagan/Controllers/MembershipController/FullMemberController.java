package org.randall.teagan.Controllers.MembershipController;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Services.ServiceImplementation.CustServiceImpl.CustomerServiceImpl;
import org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl.FullTimeMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/fullmember")
public class FullMemberController {

    @Autowired
    @Qualifier("FullTimeMemberServiceImpl")
    FullTimeMemberServiceImpl fullTimeMemberServiceImpl;


    @PostMapping(value = "/create")
    @ResponseBody
    public FullTimeMember create(@RequestBody FullTimeMember ftmem) {
        return fullTimeMemberServiceImpl.create(ftmem);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public FullTimeMember update(@RequestBody FullTimeMember ftmem) {
        return fullTimeMemberServiceImpl.update(ftmem);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        fullTimeMemberServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public FullTimeMember read(@PathVariable String id) {
        return fullTimeMemberServiceImpl.read(id);
    }

    @GetMapping(value = "/readFT/all")
    @ResponseBody
    public ArrayList<FullTimeMember> getAll() {
        return fullTimeMemberServiceImpl.getAll();
    }
}

