package org.randall.teagan.Services.ServicesInterfaces.MemberServiceInterface;

import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface MemberServiceInterface extends GenericService<Membership, String> {
    ArrayList<Membership> getAll();
}
