package org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Factory.VehicleBuilders.MidibusBuilder;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.MidibusRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MidibusServiceImplTest {

    private MidibusRepositoryImpl midibusRepositoryImpl;
    private Midibus midibus;

    private Midibus getSaved(){
        ListIterator<Midibus> listItr = this.midibusRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.midibusRepositoryImpl = MidibusRepositoryImpl.getMidibusRepositoryImpl();
        this.midibus = MidibusBuilder.getMidibus("MB-009", "Minibus");
    }

    @Test
    public void a_create() {
        Midibus createdMidibus = this.midibusRepositoryImpl.create(this.midibus);
        System.out.println("In create, created = " + createdMidibus);
        Assert.assertNotNull(createdMidibus);
        Assert.assertSame(createdMidibus, this.midibus);
    }

    @Test
    public void c_update() {
        String newBusTypeCode = "Mini-0087";
        Midibus updatedMidibus = new Midibus.MidibusBuilder().copy(getSaved()).busTypeCode(newBusTypeCode).build();
        System.out.println("In update, updated = " + updatedMidibus);
        this.midibusRepositoryImpl.update(updatedMidibus);
        Assert.assertSame(newBusTypeCode, updatedMidibus.getBusTypeCode());
    }

    @Test
    public void e_delete() {
        Midibus savedMidibus = getSaved();
        this.midibusRepositoryImpl.delete(savedMidibus.getBusTypeCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        Midibus savedMidibus = getSaved();
        Midibus readMidibus = this.midibusRepositoryImpl.read(savedMidibus.getBusTypeCode());
        System.out.println("In read, read = "+ readMidibus);
        Assert.assertSame(readMidibus, savedMidibus);
    }

    @Test
    public void d_getAll() {
        ArrayList<Midibus> midibuses = this.midibusRepositoryImpl.getAll();
        System.out.println("In getall, all = " + midibuses);
    }
}