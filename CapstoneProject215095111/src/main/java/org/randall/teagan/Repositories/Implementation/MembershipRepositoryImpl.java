package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepository;
import java.util.ArrayList;

public class MembershipRepositoryImpl implements MembershipRepository {

    private ArrayList<Membership> memberships;

    private static MembershipRepositoryImpl memRepositoryImpl = null;

    private MembershipRepositoryImpl(){
        memberships = new ArrayList<>();
    }

    protected static MembershipRepositoryImpl getMemRepositoryImpl(){
        if(memRepositoryImpl == null){
            memRepositoryImpl = new MembershipRepositoryImpl();
        }
        return memRepositoryImpl;
    }

    @Override
    public Membership create(Membership membership) {
        memberships.add(membership);
        return membership;
    }

    @Override
    public Membership update(Membership membership) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < memberships.size();i++) {

            if (memberships.get(i).getMembershipID() == membership.getMembershipID()) {
                exists = true;
                index = i;
                memberships.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent membership.");
        }

        memberships.add(index, membership);
        return membership;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < memberships.size();i++) {

            if (memberships.get(i).getMembershipID() == id) {
                memberships.remove(i);
            }
        }
    }

    @Override
    public Membership read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < memberships.size();i++) {

            if (memberships.get(i).getMembershipID() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return memberships.get(index);
    }

    @Override
    public void removeAll() {
        memberships.removeAll(memberships);
    }

    @Override
    public ArrayList<Membership> getAll() {
        return memberships;
    }
}
