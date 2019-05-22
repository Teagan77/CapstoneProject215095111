package org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl;

import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface.MidiBusRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("MidibusRepository")
public class MidibusRepositoryImpl implements MidiBusRepository {

    private ArrayList<Midibus> midibuses;

    private static MidibusRepositoryImpl midibusRepositoryImpl = null;

    private MidibusRepositoryImpl(){
        this.midibuses = new ArrayList<>();
    }

    public static MidibusRepositoryImpl getMidibusRepositoryImpl(){
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

        Midibus toDelete = findCourse(midibus.getBusTypeCode());
        if(toDelete != null) {
            this.midibuses.remove(toDelete);
            return create(midibus);
        }
        return null;
    }

    private Midibus findCourse(String busTypeCode) {
        return this.midibuses.stream()
                .filter(midibus -> midibus.getBusTypeCode().trim().equals(busTypeCode))
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < midibuses.size();i++) {

            if (midibuses.get(i).getBusTypeCode().equals(id)) {
                midibuses.remove(i);
            }
        }

    }

    @Override
    public Midibus read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < midibuses.size();i++) {

            if (midibuses.get(i).getBusTypeCode().equals(id)) {
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
