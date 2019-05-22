package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.*;
import org.randall.teagan.Factory.EmployeeBuilders.*;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.TaskRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskServiceImplTest {

    private TaskRepositoryImpl taskRepositoryImpl;
    private Task firstTask;
    private Manager firstManager;
    private Employee firstEmp;
    private EmployeePosition employeePosition;
    private EmployeePayslip employeePayslip;
    private EmpAddress empAddress;
    private EmpContact empContact;
    private ArrayList<Employee> employees;

    private Task getSaved(){
        ListIterator<Task> listItr = this.taskRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.employeePosition = EmpPosBuilder.getEmpPos("Driver", "DRV005");
        Date date = new Date();
        this.employeePayslip = EmpPayslipBuilder.getEmpPayslip(10000.00, date, "BTFO96");
        this.empContact = EmpContactBuilder.getEmpContact("076258973");
        this.empAddress = EmpAddressBuilder.getEmpAddress("1 Plein St Zonnebloem", 5205, 4209);
        this.firstEmp = EmpBuilder.getEmployee("215095111", "Teagan", "Randall", 23, "Male",employeePosition, employeePayslip, empAddress, empContact);
        this.employees = new ArrayList<>();
        employees.add(firstEmp);
        this.taskRepositoryImpl = TaskRepositoryImpl.getTaskRepositoryImpl();
        this.firstManager = ManagerBuilder.getManager("Manager", "MGR005", "BTECHCOMMGM", "215095111");
        this.firstTask = TaskBuilder.getEmpTask(firstManager, employees, "A task.", date, "2165848");
    }

    @Test
    public void a_create() {
        Task createdTask = this.taskRepositoryImpl.create(this.firstTask);
        System.out.println("In create, created = " + createdTask);
        Assert.assertNotNull(createdTask);
        Assert.assertSame(createdTask, this.firstTask);
    }

    @Test
    public void c_update() {
        String newTaskDesc = "An updated Task.";
        Task updatedTask = new Task.TaskBuilder().copy(getSaved()).taskDesc(newTaskDesc).build();
        System.out.println("In update, updated = " + updatedTask);
        this.taskRepositoryImpl.update(updatedTask);
        Assert.assertSame(newTaskDesc, updatedTask.getTaskDescrip());
    }

    @Test
    public void e_delete() {
        Task savedTask = getSaved();
        this.taskRepositoryImpl.delete(savedTask.getTaskNo());
        d_getAll();
    }

    @Test
    public void b_read() {
        Task savedTask = getSaved();
        Task readTask = this.taskRepositoryImpl.read(savedTask.getTaskNo());
        System.out.println("In read, read = "+ readTask);
        Assert.assertSame(readTask, savedTask);
    }

    @Test
    public void d_getAll() {
        ArrayList<Task> tasks = this.taskRepositoryImpl.getAll();
        System.out.println("In getall, all = " + tasks);
    }
}