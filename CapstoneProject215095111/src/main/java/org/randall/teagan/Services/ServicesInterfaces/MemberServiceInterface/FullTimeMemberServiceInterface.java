package org.randall.teagan.Services.ServicesInterfaces.MemberServiceInterface;

import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface FullTimeMemberServiceInterface extends GenericService<FullTimeMember, String> {

    ArrayList<FullTimeMember> getAll();
}
