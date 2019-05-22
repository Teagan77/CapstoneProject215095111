package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.*;
import org.randall.teagan.Factory.EmployeeBuilders.*;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.TaskRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class TaskRepositoryImplTest {

    private TaskRepositoryImpl taskRepositoryImpl;

    TaskBuilder taskBuilder = new TaskBuilder();

    public Task getFirstTask() {

        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int age = 22;
        String id = "215095111";
        double pay = 20000.00;
        String gender = "male";
        Date date = new Date();
        String jobTitle = "Manager";
        String posCode = "MGR000";
        String qualCode = "BTECHBSMGM";
        String physicalAddress = "1 Gore Street, DeZonnebloem";
        int postalAddress = 5280;
        int postalCode = 4280;
        String contactNo = "0725986625";
        String taskDesc = "A task.";
        String taskNo = "76392";
        String managerID = "89798";
        String payslipID = "878733";

        EmployeePosition position = EmpPosBuilder.getEmpPos(jobTitle, posCode);
        EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(pay, date,payslipID);
        EmpAddress address = EmpAddressBuilder.getEmpAddress(physicalAddress, postalAddress, postalCode);
        EmpContact contact = EmpContactBuilder.getEmpContact(contactNo);

        Employee firstEmp = EmpBuilder.getEmployee(id, name, surname, age, gender, position, payslip, address, contact);
        Manager firstManager = ManagerBuilder.getManager(jobTitle, posCode, qualCode, managerID);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(firstEmp);


        Task task = TaskBuilder.getEmpTask(firstManager,employees, taskDesc,date,taskNo);
        return task;
    }

    public Task getUpdatedFirstTask() {

        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int age = 22;
        String id = "215095111";
        double pay = 20000.00;
        String gender = "male";
        Date date = new Date();
        String jobTitle = "Manager";
        String posCode = "MGR000";
        String qualCode = "BTECHBSMGM";
        String physicalAddress = "1 Gore Street, DeZonnebloem";
        int postalAddress = 5280;
        int postalCode = 4280;
        String contactNo = "0725986625";
        String taskDesc = "An updated task.";
        String taskNo = "76392";
        String managerID = "456546";
        String payslipID = "7498749";

        EmployeePosition position = EmpPosBuilder.getEmpPos(jobTitle, posCode);
        EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(pay, date,payslipID);
        EmpAddress address = EmpAddressBuilder.getEmpAddress(physicalAddress, postalAddress, postalCode);
        EmpContact contact = EmpContactBuilder.getEmpContact(contactNo);

        Employee firstEmp = EmpBuilder.getEmployee(id, name, surname, age, gender, position, payslip, address, contact);
        Manager firstManager = ManagerBuilder.getManager(jobTitle, posCode, qualCode,managerID);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(firstEmp);


        Task task = TaskBuilder.getEmpTask(firstManager,employees, taskDesc,date,taskNo);
        return task;
    }

    public Task getSecondTask() {

        String name = "Dk";
        String surname = "Basson";
        String phone = "0298754395";
        int age = 21;
        String id = "216981777";
        double pay = 12000.00;
        String gender = "male";
        Date date = new Date();
        String jobTitle = "Manager";
        String posCode = "MGR000";
        String qualCode = "BTECHBSMGM";
        String physicalAddress = "2 King Street, District 6";
        int postalAddress = 5987;
        int postalCode = 5880;
        String contactNo = "0785556892";
        String taskDesc = "A second task.";
        String taskNo = "56164";
        String managerID = "783733";
        String payslipID = "878944";

        EmployeePosition position = EmpPosBuilder.getEmpPos(jobTitle, posCode);
        EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(pay, date,payslipID);
        EmpAddress address = EmpAddressBuilder.getEmpAddress(physicalAddress, postalAddress, postalCode);
        EmpContact contact = EmpContactBuilder.getEmpContact(contactNo);

        Employee firstEmp = EmpBuilder.getEmployee(id, name, surname, age, gender, position, payslip, address, contact);
        Manager firstManager = ManagerBuilder.getManager(jobTitle, posCode, qualCode,managerID);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(firstEmp);


        Task task = TaskBuilder.getEmpTask(firstManager,employees, taskDesc,date,taskNo);
        return task;
    }

    Task firstTask = getFirstTask();
    Task updatedFirstTask = getUpdatedFirstTask();
    Task secondTask = getSecondTask();

    @Before
    public void setUp() throws Exception {
        this.taskRepositoryImpl = TaskRepositoryImpl.getTaskRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstTask.hashCode(), this.taskRepositoryImpl.create(firstTask).hashCode());
        this.taskRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.taskRepositoryImpl.create(firstTask);
        this.taskRepositoryImpl.update(updatedFirstTask);
        Assert.assertEquals("An updated task.", this.taskRepositoryImpl.read(updatedFirstTask.getTaskNo()).getTaskDescrip());
        this.taskRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.taskRepositoryImpl.create(firstTask);
        this.taskRepositoryImpl.create(secondTask);
        this.taskRepositoryImpl.delete(firstTask.getTaskNo());

        assertEquals(null, this.taskRepositoryImpl.read(firstTask.getTaskNo()));
        this.taskRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.taskRepositoryImpl.create(firstTask);
        assertEquals(true, this.taskRepositoryImpl.read(firstTask.getTaskNo()) instanceof Task);
        System.out.println(this.taskRepositoryImpl.read(firstTask.getTaskNo()));
        this.taskRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.taskRepositoryImpl.create(firstTask);
        ArrayList<Task> tasks = this.taskRepositoryImpl.getAll();
        assertEquals(1, tasks.size());
        this.taskRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.taskRepositoryImpl.create(firstTask);
        ArrayList<Task> tasks = this.taskRepositoryImpl.getAll();
        this.taskRepositoryImpl.removeAll();
        assertEquals( 0,tasks.size());
    }
}