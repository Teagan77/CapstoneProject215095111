package org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl;

import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface.MemberTypeRepository;

import java.util.LinkedList;

public class MemberTypeRepositoryImpl implements MemberTypeRepository {

    LinkedList<MemberType> membershipTypes;

    private static MemberTypeRepositoryImpl memberTypeRepositoryImpl = null;

    private MemberTypeRepositoryImpl(){
        this.membershipTypes = new LinkedList<>();
    }

    public static MemberTypeRepositoryImpl getMemberTypeRepositoryImpl(){
        if(memberTypeRepositoryImpl == null){
            memberTypeRepositoryImpl = new MemberTypeRepositoryImpl();
        }
        return memberTypeRepositoryImpl;
    }

    @Override
    public MemberType create(MemberType memberType) {
        this.membershipTypes.add(memberType);
        return memberType;
    }

    @Override
    public MemberType update(MemberType memberType) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < membershipTypes.size();i++) {

            if (membershipTypes.get(i).getMemCode() == memberType.getMemCode()) {
                exists = true;
                index = i;
                membershipTypes.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent membershipType");
        }

        membershipTypes.add(index, memberType);
        return memberType;
    }

    @Override
    public void delete(String code) {

        for(int i = 0;i < membershipTypes.size();i++) {

            if (membershipTypes.get(i).getMemCode() == code) {
                membershipTypes.remove(i);
            }
        }
    }

    @Override
    public MemberType read(String code) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < membershipTypes.size();i++) {

            if (membershipTypes.get(i).getMemCode() == code) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }
        return membershipTypes.get(index);
    }

    @Override
    public LinkedList<MemberType> getAll() {
        return membershipTypes;
    }

    @Override
    public void removeAll() {
        membershipTypes.removeAll(membershipTypes);
    }
}
