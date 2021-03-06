package org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl;

import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Repositories.RepositoryInterfaces.MembershipRepositoryInterface.StudentMembershipRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("StudentMembershipRepository")
public class StudentMembershipRepositoryImpl implements StudentMembershipRepository {

    private ArrayList<StudentMember> studentMembers;

    private static StudentMembershipRepositoryImpl studentMembershipRepositoryImpl = null;

    private StudentMembershipRepositoryImpl(){
        this.studentMembers = new ArrayList<>();
    }

    public static StudentMembershipRepositoryImpl getStudentMembershipRepositoryImpl(){
        if(studentMembershipRepositoryImpl == null){
            studentMembershipRepositoryImpl = new StudentMembershipRepositoryImpl();
        }
        return studentMembershipRepositoryImpl;
    }

    @Override
    public StudentMember create(StudentMember studentMember) {
        this.studentMembers.add(studentMember);
        return studentMember;
    }

    @Override
    public StudentMember update(StudentMember studentMember) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < studentMembers.size();i++) {

            if (studentMembers.get(i).getStudNo().equals(studentMember.getStudNo())) {
                exists = true;
                index = i;
                studentMembers.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent customer.");
        }

        studentMembers.add(index, studentMember);
        return studentMember;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < studentMembers.size();i++) {

            if (studentMembers.get(i).getStudNo().equals(id)) {
                studentMembers.remove(i);
            }
        }

    }

    @Override
    public StudentMember read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < studentMembers.size();i++) {

            if (studentMembers.get(i).getStudNo().equals(id)) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return studentMembers.get(index);
    }
    @Override
    public ArrayList<StudentMember> getAll() {
        return studentMembers;
    }

    @Override
    public void removeAll() {
        studentMembers.removeAll(studentMembers);
    }
}
