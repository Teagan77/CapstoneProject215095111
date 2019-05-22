package org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Factory.VehicleBuilders.CitylinerBuilder;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.CityLinerRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CitylinerServiceImplTest {

    private CityLinerRepositoryImpl cityLinerRepositoryImpl;
    private Cityliner cityliner;

    private Cityliner getSaved(){
        ListIterator<Cityliner> listItr = this.cityLinerRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.cityLinerRepositoryImpl = CityLinerRepositoryImpl.getCityLinerRepositoryImpl();
        this.cityliner = CitylinerBuilder.getCityliner("CTL-010", "Cityliner");
    }

    @Test
    public void a_create() {
        Cityliner createdCityliner = this.cityLinerRepositoryImpl.create(this.cityliner);
        System.out.println("In create, created = " + createdCityliner);
        Assert.assertNotNull(createdCityliner);
        Assert.assertSame(createdCityliner, this.cityliner);
    }

    @Test
    public void c_update() {
        String newBusTypeCode = "CityLiner-1011";
        Cityliner updatedCityliner = new Cityliner.CitylinerBuilder().copy(getSaved()).busTypeCode(newBusTypeCode).build();
        System.out.println("In update, updated = " + updatedCityliner);
        this.cityLinerRepositoryImpl.update(updatedCityliner);
        Assert.assertSame(newBusTypeCode, updatedCityliner.getBusTypeCode());
    }

    @Test
    public void e_delete() {
        Cityliner savedCityliner = getSaved();
        this.cityLinerRepositoryImpl.delete(savedCityliner.getBusTypeCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        Cityliner savedCityliner = getSaved();
        Cityliner readCityliner = this.cityLinerRepositoryImpl.read(savedCityliner.getBusTypeCode());
        System.out.println("In read, read = "+ readCityliner);
        Assert.assertSame(readCityliner, savedCityliner);
    }

    @Test
    public void d_getAll() {
        ArrayList<Cityliner> cityliners = this.cityLinerRepositoryImpl.getAll();
        System.out.println("In getall, all = " + cityliners);
    }
}