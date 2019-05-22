package org.randall.teagan.Services.ServicesInterfaces.MemberServiceInterface;

import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface StudentMemberServiceInterface extends GenericService<StudentMember, String> {
    ArrayList<StudentMember>getAll();
}
