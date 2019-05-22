package org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl;

import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface.MembershipRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("MembershipRepository")
public class MembershipRepositoryImpl implements MembershipRepository {

    private ArrayList<Membership> memberships;

    private static MembershipRepositoryImpl memRepositoryImpl = null;

    private MembershipRepositoryImpl(){
        memberships = new ArrayList<>();
    }

    public static MembershipRepositoryImpl getMemRepositoryImpl(){
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

        Membership toDelete = findMember(membership.getMembershipID());
        if(toDelete != null) {
            this.memberships.remove(toDelete);
            return create(membership);
        }
        return null;
    }

    private Membership findMember(String membershipID) {
        return this.memberships.stream()
                .filter(membership -> membership.getMembershipID().trim().equals(membershipID))
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < memberships.size();i++) {

            if (memberships.get(i).getMembershipID().equals(id)) {
                memberships.remove(i);
            }
        }
    }

    @Override
    public Membership read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < memberships.size();i++) {

            if (memberships.get(i).getMembershipID().equals(id)) {
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
