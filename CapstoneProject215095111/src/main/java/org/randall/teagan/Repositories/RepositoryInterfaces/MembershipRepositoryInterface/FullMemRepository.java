package org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface;

import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface FullMemRepository extends Repository<FullTimeMember, String> {
    void removeAll();
    ArrayList<FullTimeMember> getAll();
}
