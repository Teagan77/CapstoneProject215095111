package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Factory.VehicleBuilders.MinibusBuilder;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MinibusRepositoryImplTest {

    private MinibusRepositoryImpl minibusRepositoryImpl;
    private MinibusBuilder minibusBuilder = new MinibusBuilder();

    String busTypeCode = "L7676";
    String busTypeName = "Minibus";

    String updatedBusTypeName = "Mini-Bus";

    String busTypeCode2 = "HF8798";
    String busTypeName2 = "Minibus";

    Minibus firstMinibus = MinibusBuilder.getMinibus(busTypeCode,busTypeName);
    Minibus updatedFirstMinibus = MinibusBuilder.getMinibus(busTypeCode,updatedBusTypeName);
    Minibus secondMinibus = MinibusBuilder.getMinibus(busTypeCode2,busTypeName2);


    @Before
    public void setUp() throws Exception {
        this.minibusRepositoryImpl = MinibusRepositoryImpl.getMinibusRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstMinibus.hashCode(), this.minibusRepositoryImpl.create(firstMinibus).hashCode());
        this.minibusRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.minibusRepositoryImpl.create(firstMinibus);
        this.minibusRepositoryImpl.update(updatedFirstMinibus);
        Assert.assertEquals("Mini-Bus", this.minibusRepositoryImpl.read(updatedFirstMinibus.getBusTypeCode()).getBusTypeName());
        this.minibusRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.minibusRepositoryImpl.create(firstMinibus);
        this.minibusRepositoryImpl.create(secondMinibus);
        this.minibusRepositoryImpl.delete(firstMinibus.getBusTypeCode());

        Assert.assertEquals(null, this.minibusRepositoryImpl.read(firstMinibus.getBusTypeCode()));
        this.minibusRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.minibusRepositoryImpl.create(firstMinibus);
        assertEquals(true, this.minibusRepositoryImpl.read(firstMinibus.getBusTypeCode()) instanceof Minibus);
        System.out.println(this.minibusRepositoryImpl.read(firstMinibus.getBusTypeCode()));
        this.minibusRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.minibusRepositoryImpl.create(firstMinibus);
        ArrayList<Minibus> minibuses = this.minibusRepositoryImpl.getAll();
        Assert.assertEquals(1, minibuses.size());
        this.minibusRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.minibusRepositoryImpl.create(firstMinibus);
        ArrayList<Minibus> minibuses = this.minibusRepositoryImpl.getAll();
        this.minibusRepositoryImpl.removeAll();
        Assert.assertEquals( 0,minibuses.size());
    }
}