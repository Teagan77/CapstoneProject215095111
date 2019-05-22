package org.randall.teagan.Controllers.MembershipController;

import org.randall.teagan.Domain.Membership.InternationalMember;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.InternationalMemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/internationalMember")
public class InternationalMemberController {

    @Autowired
    @Qualifier("InternationalMemberRepository")
    InternationalMemRepositoryImpl internationalMemRepositoryImpl;


    @PostMapping(value = "/create")
    @ResponseBody
    public InternationalMember create(@RequestBody InternationalMember internationalMember) {
        return internationalMemRepositoryImpl.create(internationalMember);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public InternationalMember update(@RequestBody InternationalMember internationalMember) {
        return internationalMemRepositoryImpl.update(internationalMember);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        internationalMemRepositoryImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public InternationalMember read(@PathVariable String id) {
        return internationalMemRepositoryImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<InternationalMember> getAll() {
        return internationalMemRepositoryImpl.getAll();
    }
}
