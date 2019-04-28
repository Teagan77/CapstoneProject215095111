package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Membership.StudentMember;

import java.util.ArrayList;

public interface StudentMembershipRepository extends Repository<StudentMember, String> {
    void removeAll();
    ArrayList<StudentMember> getAll();
}
