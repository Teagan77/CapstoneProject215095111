package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Repositories.RepositoryInterfaces.FullMemRepository;

import java.util.ArrayList;

public class FullMemRepositoryImpl implements FullMemRepository {

    private ArrayList<FullTimeMember> fullTimeMembers;

    private static FullMemRepositoryImpl fullMemRepositoryImpl = null;

    private FullMemRepositoryImpl(){
        this.fullTimeMembers = new ArrayList<>();
    }

    protected static FullMemRepositoryImpl getFullMemRepositoryImpl(){
        if(fullMemRepositoryImpl == null){
            fullMemRepositoryImpl = new FullMemRepositoryImpl();
        }
        return fullMemRepositoryImpl;
    }

    @Override
    public FullTimeMember create(FullTimeMember fullTimeMember) {
        this.fullTimeMembers.add(fullTimeMember);
        return fullTimeMember;
    }

    @Override
    public FullTimeMember update(FullTimeMember fullTimeMember) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < fullTimeMembers.size();i++) {

            if (fullTimeMembers.get(i).getMemCode() == fullTimeMember.getMemCode()) {
                exists = true;
                index = i;
                fullTimeMembers.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent fullTimeMember.");
        }

        fullTimeMembers.add(index, fullTimeMember);
        return fullTimeMember;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < fullTimeMembers.size();i++) {

            if (fullTimeMembers.get(i).getMemCode() == id) {
                fullTimeMembers.remove(i);
            }
        }

    }

    @Override
    public FullTimeMember read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < fullTimeMembers.size();i++) {

            if (fullTimeMembers.get(i).getMemCode() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return fullTimeMembers.get(index);
    }

    @Override
    public ArrayList<FullTimeMember> getAll() {
        return fullTimeMembers;
    }

    @Override
    public void removeAll() {
        fullTimeMembers.removeAll(fullTimeMembers);
    }


}
