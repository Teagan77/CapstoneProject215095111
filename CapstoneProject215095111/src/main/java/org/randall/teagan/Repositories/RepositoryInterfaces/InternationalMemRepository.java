package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Membership.InternationalMember;

import java.util.ArrayList;

public interface InternationalMemRepository extends Repository<InternationalMember, String> {

    void removeAll();
    ArrayList<InternationalMember> getAll();
}
