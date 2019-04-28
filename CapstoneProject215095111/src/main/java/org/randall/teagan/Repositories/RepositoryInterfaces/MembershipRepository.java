package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Membership.Membership;

import java.util.ArrayList;

public interface MembershipRepository extends Repository<Membership, String> {

    void removeAll();
    ArrayList<Membership> getAll();
}
