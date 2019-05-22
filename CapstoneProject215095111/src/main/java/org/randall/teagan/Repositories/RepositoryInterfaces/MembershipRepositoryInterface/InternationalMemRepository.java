package org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface;

import org.randall.teagan.Domain.Membership.InternationalMember;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface InternationalMemRepository extends Repository<InternationalMember, String> {

    void removeAll();
    ArrayList<InternationalMember> getAll();
}
