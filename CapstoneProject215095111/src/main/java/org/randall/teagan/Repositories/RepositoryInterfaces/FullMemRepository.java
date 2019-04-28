package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Membership.FullTimeMember;

import java.util.ArrayList;

public interface FullMemRepository extends Repository<FullTimeMember, String> {
    void removeAll();
    ArrayList<FullTimeMember> getAll();
}
