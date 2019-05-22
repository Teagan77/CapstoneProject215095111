package org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface;

import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface StudentMembershipRepository extends Repository<StudentMember, String> {
    void removeAll();
    ArrayList<StudentMember> getAll();
}
