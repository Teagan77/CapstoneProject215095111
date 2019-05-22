package org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl;

import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.MembershipRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.MemberServiceInterface.MemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberServiceInterface {

    @Autowired
    @Qualifier("MembershipRepository")
    private MembershipRepositoryImpl membershipRepositoryImpl;

    @Override
    public Membership create(Membership membership) {
        return membershipRepositoryImpl.create(membership);
    }

    @Override
    public Membership update(Membership membership) {
        return membershipRepositoryImpl.update(membership);
    }

    @Override
    public void delete(String memCode) {
        membershipRepositoryImpl.delete(memCode);
    }

    @Override
    public Membership read(String memCode) {
        return membershipRepositoryImpl.read(memCode);
    }

    @Override
    public ArrayList<Membership> getAll() {
        return membershipRepositoryImpl.getAll();
    }
}
