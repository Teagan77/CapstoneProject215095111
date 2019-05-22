package org.randall.teagan.Services.ServicesInterfaces.MemberServiceInterface;

import org.randall.teagan.Domain.Membership.InternationalMember;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface IntMemServiceInterface extends GenericService<InternationalMember, String> {

    ArrayList<InternationalMember> getAll();
}
