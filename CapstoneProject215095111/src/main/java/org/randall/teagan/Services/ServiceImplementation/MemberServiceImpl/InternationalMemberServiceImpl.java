package org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl;

import org.randall.teagan.Domain.Membership.InternationalMember;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.InternationalMemRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.MemberServiceInterface.IntMemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("InternationalMemberServiceImpl")
public class InternationalMemberServiceImpl implements IntMemServiceInterface {

    @Autowired
    @Qualifier("InternationalMemberRepository")
    private InternationalMemRepositoryImpl internationalMemRepositoryImpl;

    @Override
    public InternationalMember create(InternationalMember internationalMember) {
        return internationalMemRepositoryImpl.create(internationalMember);
    }

    @Override
    public InternationalMember update(InternationalMember internationalMember) {
        return internationalMemRepositoryImpl.update(internationalMember);
    }

    @Override
    public void delete(String memCode) {
        internationalMemRepositoryImpl.delete(memCode);
    }

    @Override
    public InternationalMember read(String memCode) {
        return internationalMemRepositoryImpl.read(memCode);
    }

    @Override
    public ArrayList<InternationalMember> getAll() {
        return internationalMemRepositoryImpl.getAll();
    }
}
