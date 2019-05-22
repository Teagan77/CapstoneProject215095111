package org.randall.teagan.Repositories.Implementation.MembershipRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Factory.MembershipBuilders.MemTypeBuilder;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.MemberTypeRepositoryImpl;

import java.util.LinkedList;

public class MemberTypeRepositoryImplTest {

    private MemberTypeRepositoryImpl memTypeRepository;

    MemTypeBuilder memTypeBuilder = new MemTypeBuilder();

   LinkedList<MemberType> memtypes = new LinkedList<>();

    String memName = "Student Membership";
    String memCode = "ST001";

    String memNameUpdated = "Stud mem";

    String memName2 = "International Membership";
    String memCode2 = "IN002";

    MemberType firstMemType = memTypeBuilder.getMemberType(memCode, memName);
    MemberType secondMemType = memTypeBuilder.getMemberType(memCode2, memName2);
    MemberType updatedFirstType = memTypeBuilder.getMemberType(memCode,memNameUpdated);

    @Before
    public void setUp() throws Exception {
        this.memTypeRepository = MemberTypeRepositoryImpl.getMemberTypeRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstMemType.hashCode(), this.memTypeRepository.create(firstMemType).hashCode());
        this.memTypeRepository.removeAll();
    }

    @Test
    public void update() {
        this.memTypeRepository.create(firstMemType);
        this.memTypeRepository.update(updatedFirstType);
        Assert.assertEquals("Stud mem", this.memTypeRepository.read(firstMemType.getMemCode()).getMemTypeName());
        this.memTypeRepository.removeAll();
    }

    @Test
    public void delete() {
        this.memTypeRepository.create(firstMemType);
        this.memTypeRepository.create(secondMemType);
        this.memTypeRepository.delete(firstMemType.getMemCode());

        Assert.assertEquals(null, this.memTypeRepository.read(firstMemType.getMemCode()));
        this.memTypeRepository.removeAll();
    }

    @Test
    public void read() {
        this.memTypeRepository.create(firstMemType);
        Assert.assertEquals(true, this.memTypeRepository.read(firstMemType.getMemCode()) instanceof MemberType);
        System.out.println(this.memTypeRepository.read(firstMemType.getMemCode()));
        this.memTypeRepository.removeAll();
    }

    @Test
    public void getAll() {
        this.memTypeRepository.create(firstMemType);
        LinkedList<MemberType> memTypes = this.memTypeRepository.getAll();
        Assert.assertEquals(1, memTypes.size());
        this.memTypeRepository.removeAll();
    }

    @Test
    public void removeAll() {
        this.memTypeRepository.create(firstMemType);
        LinkedList<MemberType> memberTypes = this.memTypeRepository.getAll();
        this.memTypeRepository.removeAll();
        Assert.assertEquals( 0,memberTypes.size());
    }
}