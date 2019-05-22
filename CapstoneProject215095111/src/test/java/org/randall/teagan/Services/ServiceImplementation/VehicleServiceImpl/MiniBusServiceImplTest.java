package org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Factory.VehicleBuilders.MinibusBuilder;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.MinibusRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MiniBusServiceImplTest {

    private MinibusRepositoryImpl minibusRepositoryImpl;
    private Minibus minibus;

    private Minibus getSaved(){
        ListIterator<Minibus> listItr = this.minibusRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.minibusRepositoryImpl = MinibusRepositoryImpl.getMinibusRepositoryImpl();
        this.minibus = MinibusBuilder.getMinibus("MB-009", "Minibus");
    }

    @Test
    public void a_create() {
        Minibus createdMinibus = this.minibusRepositoryImpl.create(this.minibus);
        System.out.println("In create, created = " + createdMinibus);
        Assert.assertNotNull(createdMinibus);
        Assert.assertSame(createdMinibus, this.minibus);
    }

    @Test
    public void c_update() {
        String newBusTypeCode = "Mini-0087";
        Minibus updatedMinibus = new Minibus.MinibusBuilder().copy(getSaved()).busTypeCode(newBusTypeCode).build();
        System.out.println("In update, updated = " + updatedMinibus);
        this.minibusRepositoryImpl.update(updatedMinibus);
        Assert.assertSame(newBusTypeCode, updatedMinibus.getBusTypeCode());
    }

    @Test
    public void e_delete() {
        Minibus savedMinibus = getSaved();
        this.minibusRepositoryImpl.delete(savedMinibus.getBusTypeCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        Minibus savedMinibus = getSaved();
        Minibus readMinibus = this.minibusRepositoryImpl.read(savedMinibus.getBusTypeCode());
        System.out.println("In read, read = "+ readMinibus);
        Assert.assertSame(readMinibus, savedMinibus);
    }

    @Test
    public void d_getAll() {
        ArrayList<Minibus> minibuses = this.minibusRepositoryImpl.getAll();
        System.out.println("In getall, all = " + minibuses);
    }
}