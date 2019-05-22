package org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface;

import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.LinkedList;

public interface MemberTypeRepository extends Repository<MemberType, String> {

    LinkedList<MemberType> getAll();
    void removeAll();
}
