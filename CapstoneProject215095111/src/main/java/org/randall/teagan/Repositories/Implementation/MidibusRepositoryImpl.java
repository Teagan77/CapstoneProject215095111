package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Repositories.RepositoryInterfaces.MidiBusRepository;

import java.util.ArrayList;

public class MidibusRepositoryImpl implements MidiBusRepository {

    private ArrayList<Midibus> midibuses;

    private static MidibusRepositoryImpl midibusRepositoryImpl = null;

    private MidibusRepositoryImpl(){
        this.midibuses = new ArrayList<>();
    }

    protected static MidibusRepositoryImpl getMidibusRepositoryImpl(){
        if(midibusRepositoryImpl == null){
            midibusRepositoryImpl = new MidibusRepositoryImpl();
        }
        return midibusRepositoryImpl;
    }

    @Override
    public Midibus create(Midibus midibuse) {
        this.midibuses.add(midibuse);
        return midibuse;
    }

    @Override
    public Midibus update(Midibus midibus) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < midibuses.size();i++) {

            if (midibuses.get(i).getBusTypeCode() == midibus.getBusTypeCode()) {
                exists = true;
                index = i;
                midibuses.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent midibuse.");
        }

        midibuses.add(index, midibus);
        return midibus;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < midibuses.size();i++) {

            if (midibuses.get(i).getBusTypeCode() == id) {
                midibuses.remove(i);
            }
        }

    }

    @Override
    public Midibus read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < midibuses.size();i++) {

            if (midibuses.get(i).getBusTypeCode() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return midibuses.get(index);
    }

    @Override
    public ArrayList<Midibus> getAll() {
        return midibuses;
    }
    @Override
    public void removeAll() {
        midibuses.removeAll(midibuses);
    }
}
