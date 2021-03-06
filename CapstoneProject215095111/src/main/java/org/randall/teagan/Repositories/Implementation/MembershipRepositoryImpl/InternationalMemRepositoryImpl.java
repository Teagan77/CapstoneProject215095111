package org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl;

import org.randall.teagan.Domain.Membership.InternationalMember;
import org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface.InternationalMemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("InternationalMemberRepository")
public class InternationalMemRepositoryImpl implements InternationalMemRepository {

    private ArrayList<InternationalMember> internationalMembers;

    private static InternationalMemRepositoryImpl internationalMemRepositoryImpl = null;

    private InternationalMemRepositoryImpl(){
        this.internationalMembers = new ArrayList<>();
    }

    public static InternationalMemRepositoryImpl getInternationalMemRepositoryImpl(){
        if(internationalMemRepositoryImpl == null){
            internationalMemRepositoryImpl = new InternationalMemRepositoryImpl();
        }
        return internationalMemRepositoryImpl;
    }
    @Override
    public InternationalMember create(InternationalMember internationalMember) {
        this.internationalMembers.add(internationalMember);
        return internationalMember;
    }

    @Override
    public InternationalMember update(InternationalMember internationalMember) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < internationalMembers.size();i++) {

            if (internationalMembers.get(i).getInternationalMemID().equals(internationalMember.getInternationalMemID())) {
                exists = true;
                index = i;
                internationalMembers.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent international member.");
        }

        internationalMembers.add(index, internationalMember);
        return internationalMember;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < internationalMembers.size();i++) {

            if (internationalMembers.get(i).getInternationalMemID().equals(id)) {
                internationalMembers.remove(i);
            }
        }
    }

    @Override
    public InternationalMember read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < internationalMembers.size();i++) {

            if (internationalMembers.get(i).getInternationalMemID().equals(id)) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }
        return internationalMembers.get(index);
    }

    @Override
    public ArrayList<InternationalMember> getAll() {
        return internationalMembers;
    }

    @Override
    public void removeAll() {
        internationalMembers.removeAll(internationalMembers);
    }

}
