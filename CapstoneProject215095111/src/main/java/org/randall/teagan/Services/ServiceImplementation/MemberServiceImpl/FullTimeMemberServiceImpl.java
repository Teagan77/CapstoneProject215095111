package org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl;

import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.FullMemRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.MemberServiceInterface.FullTimeMemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("FullTimeMemberServiceImpl")
public class FullTimeMemberServiceImpl implements FullTimeMemberServiceInterface {

    @Autowired
    @Qualifier("FullTimeMemberRepository")
    private FullMemRepositoryImpl fullMemRepositoryImpl;

    @Override
    public FullTimeMember create(FullTimeMember fullTimeMember) {
        return fullMemRepositoryImpl.create(fullTimeMember);
    }

    @Override
    public FullTimeMember update(FullTimeMember fullTimeMember) {
        return fullMemRepositoryImpl.update(fullTimeMember);
    }

    @Override
    public void delete(String memId) {
        fullMemRepositoryImpl.delete(memId);
    }

    @Override
    public FullTimeMember read(String memId) {
        return fullMemRepositoryImpl.read(memId);
    }

    @Override
    public ArrayList<FullTimeMember> getAll() {
        return fullMemRepositoryImpl.getAll();
    }
}
