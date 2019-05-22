package org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl;

import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface.FullMemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("FullTimeMemberRepository")
public class FullMemRepositoryImpl implements FullMemRepository {

    private ArrayList<FullTimeMember> fullTimeMembers;

    private static FullMemRepositoryImpl fullMemRepositoryImpl = null;

    private FullMemRepositoryImpl(){
        this.fullTimeMembers = new ArrayList<>();
    }

    public static FullMemRepositoryImpl getFullMemRepositoryImpl(){
        if(fullMemRepositoryImpl == null){
            fullMemRepositoryImpl = new FullMemRepositoryImpl();
        }
        return fullMemRepositoryImpl;
    }

    @Override
    public FullTimeMember create(FullTimeMember fullTimeMember) {
        this.fullTimeMembers.add(fullTimeMember);
        return fullTimeMember;
    }

    @Override
    public FullTimeMember update(FullTimeMember fullTimeMember) {

        FullTimeMember toDelete = findMember(fullTimeMember.getFullTimeMemCode());
        if(toDelete != null) {
            this.fullTimeMembers.remove(toDelete);
            return create(fullTimeMember);
        }
        return null;
    }

    @Override
    public void delete(String id) {

        for(int i = 0;i < fullTimeMembers.size();i++) {

            if (fullTimeMembers.get(i).getMemCode().equals(id)) {
                fullTimeMembers.remove(i);
            }
        }

    }

    @Override
    public FullTimeMember read(String id) {
        for (FullTimeMember fullTimeMember : fullTimeMembers) {
            if (fullTimeMember.getFullTimeMemCode().equals(id)) {
                return fullTimeMember;
            }
        }
        return null;
    }

    private FullTimeMember findMember(String id) {
        return this.fullTimeMembers.stream()
                .filter(fullTimeMember -> fullTimeMember.getFullTimeMemCode().trim().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public ArrayList<FullTimeMember> getAll() {
        return fullTimeMembers;
    }

    @Override
    public void removeAll() {
        fullTimeMembers.removeAll(fullTimeMembers);
    }

}
