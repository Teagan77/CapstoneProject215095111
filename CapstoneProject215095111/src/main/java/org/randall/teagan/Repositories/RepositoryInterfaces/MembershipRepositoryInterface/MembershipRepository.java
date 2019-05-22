package org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface;

import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface MembershipRepository extends Repository<Membership, String> {

    void removeAll();
    ArrayList<Membership> getAll();
}
