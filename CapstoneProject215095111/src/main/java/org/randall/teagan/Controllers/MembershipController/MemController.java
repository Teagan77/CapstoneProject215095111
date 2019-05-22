package org.randall.teagan.Controllers.MembershipController;

import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/member")
public class MemController {

    @Autowired
    @Qualifier("MemberServiceImpl")
    MemberServiceImpl memberServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Membership create(@RequestBody Membership membership) {
        return memberServiceImpl.create(membership);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Membership update(@RequestBody Membership membership) {
        return memberServiceImpl.update(membership);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        memberServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Membership read(@PathVariable String id) {
        return memberServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Membership> getAll() {
        return memberServiceImpl.getAll();
    }
}
