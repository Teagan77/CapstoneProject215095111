package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Factory.VehicleBuilders.MidibusBuilder;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MidibusRepositoryImplTest {

    private MidibusRepositoryImpl midibusRepositoryImpl;
    private MidibusBuilder midibusBuilder = new MidibusBuilder();

    String busTypeCode = "L7676";
    String busTypeName = "Midibus";

    String updatedBusTypeName = "Midi-Bus";

    String busTypeCode2 = "HF8798";
    String busTypeName2 = "Midibus";

    Midibus firstMidibus = midibusBuilder.getMidibus(busTypeCode,busTypeName);
    Midibus updatedFirstMidibus = midibusBuilder.getMidibus(busTypeCode,updatedBusTypeName);
    Midibus secondMidibus = midibusBuilder.getMidibus(busTypeCode2,busTypeName2);


    @Before
    public void setUp() throws Exception {
        this.midibusRepositoryImpl = MidibusRepositoryImpl.getMidibusRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstMidibus.hashCode(), this.midibusRepositoryImpl.create(firstMidibus).hashCode());
        this.midibusRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.midibusRepositoryImpl.create(firstMidibus);
        this.midibusRepositoryImpl.update(updatedFirstMidibus);
        Assert.assertEquals("Midi-Bus", this.midibusRepositoryImpl.read(updatedFirstMidibus.getBusTypeCode()).getBusTypeName());
        this.midibusRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.midibusRepositoryImpl.create(firstMidibus);
        this.midibusRepositoryImpl.create(secondMidibus);
        this.midibusRepositoryImpl.delete(firstMidibus.getBusTypeCode());

        Assert.assertEquals(null, this.midibusRepositoryImpl.read(firstMidibus.getBusTypeCode()));
        this.midibusRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.midibusRepositoryImpl.create(firstMidibus);
        assertEquals(true, this.midibusRepositoryImpl.read(firstMidibus.getBusTypeCode()) instanceof Midibus);
        System.out.println(this.midibusRepositoryImpl.read(firstMidibus.getBusTypeCode()));
        this.midibusRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.midibusRepositoryImpl.create(firstMidibus);
        ArrayList<Midibus> midibuses = this.midibusRepositoryImpl.getAll();
        assertEquals(1, midibuses.size());
        this.midibusRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.midibusRepositoryImpl.create(firstMidibus);
        ArrayList<Midibus> midibuses = this.midibusRepositoryImpl.getAll();
        this.midibusRepositoryImpl.removeAll();
        assertEquals( 0,midibuses.size());
    }
}