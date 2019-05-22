package org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Factory.VehicleBuilders.CitylinerBuilder;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.CityLinerRepositoryImpl;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CityLinerRepositoryImplTest {

    private CityLinerRepositoryImpl cityLinerRepositoryImpl;
    private CitylinerBuilder citylinerBuilder = new CitylinerBuilder();

    String busTypeCode = "L7676";
    String busTypeName = "Cityliner";

    String updatedBusTypeName = "City-Liner";

    String busTypeCode2 = "HF8798";
    String busTypeName2 = "Cityliner";

    Cityliner firstCityliner = citylinerBuilder.getCityliner(busTypeCode,busTypeName);
    Cityliner updatedFirstCityliner = citylinerBuilder.getCityliner(busTypeCode,updatedBusTypeName);
    Cityliner secondCityliner = citylinerBuilder.getCityliner(busTypeCode2,busTypeName2);


    @Before
    public void setUp() throws Exception {
        this.cityLinerRepositoryImpl = CityLinerRepositoryImpl.getCityLinerRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstCityliner.hashCode(), this.cityLinerRepositoryImpl.create(firstCityliner).hashCode());
        this.cityLinerRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.cityLinerRepositoryImpl.create(firstCityliner);
        this.cityLinerRepositoryImpl.update(updatedFirstCityliner);
        assertEquals("City-Liner", this.cityLinerRepositoryImpl.read(updatedFirstCityliner.getBusTypeCode()).getBusTypeName());
        this.cityLinerRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.cityLinerRepositoryImpl.create(firstCityliner);
        this.cityLinerRepositoryImpl.create(secondCityliner);
        this.cityLinerRepositoryImpl.delete(firstCityliner.getBusTypeCode());

        Assert.assertEquals(null, this.cityLinerRepositoryImpl.read(firstCityliner.getBusTypeCode()));
        this.cityLinerRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.cityLinerRepositoryImpl.create(firstCityliner);
        assertEquals(true, this.cityLinerRepositoryImpl.read(firstCityliner.getBusTypeCode()) instanceof Cityliner);
        System.out.println(this.cityLinerRepositoryImpl.read(firstCityliner.getBusTypeCode()));
        this.cityLinerRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.cityLinerRepositoryImpl.create(firstCityliner);
        ArrayList<Cityliner> cityliners = this.cityLinerRepositoryImpl.getAll();
        Assert.assertEquals(1, cityliners.size());
        this.cityLinerRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.cityLinerRepositoryImpl.create(firstCityliner);
        ArrayList<Cityliner> cityliners = this.cityLinerRepositoryImpl.getAll();
        this.cityLinerRepositoryImpl.removeAll();
        Assert.assertEquals( 0,cityliners.size());
    }
}