package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.Employee;
import org.randall.teagan.Domain.Employee.Task;
import org.randall.teagan.Domain.Employee.Manager;

import java.util.ArrayList;
import java.util.Date;

public class TaskBuilder {

    public static Task getEmpTask(Manager taskManager, ArrayList<Employee> employees, String taskDesc, Date dueDate) {
        return new Task.TaskBuilder()
                .manager(taskManager)
                .employees(employees)
                .taskDesc(taskDesc)
                .dueDate(dueDate)
                .build();
    }
}
