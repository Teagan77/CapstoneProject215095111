package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Membership.MemberType;

import java.util.LinkedList;

public interface MemberTypeRepository extends Repository<MemberType, String> {

    LinkedList<MemberType> getAll();
    void removeAll();
}
