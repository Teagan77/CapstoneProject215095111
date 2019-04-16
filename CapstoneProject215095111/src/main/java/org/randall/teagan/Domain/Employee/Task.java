package org.randall.teagan.Domain.Employee;

import java.util.ArrayList;
import java.util.Date;

public class Task {

    private Manager TaskManager;
    private ArrayList<Employee> employees;
    private String taskDesc;
    private Date dueDate;

    private Task(){}

    private Task(TaskBuilder taskBuilder){
        this.TaskManager = taskBuilder.TaskManager;
        this.employees = taskBuilder.employees;
        this.taskDesc = taskBuilder.taskDesc;
        this.dueDate = taskBuilder.dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Manager getTaskManager() {
        return TaskManager;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public String getTaskDescrip() {
        return taskDesc;
    }

    public static class TaskBuilder{

        private Manager TaskManager;
        private ArrayList<Employee> employees;
        private String taskDesc;
        private Date dueDate;

        public TaskBuilder manager(Manager manager) {
            this.TaskManager = manager;
            return this;
        }

        public TaskBuilder employees(ArrayList<Employee> employees){
            this.employees = employees;
            return this;
        }

        public TaskBuilder taskDesc(String taskDesc){
            this.taskDesc = taskDesc;
            return this;
        }

        public TaskBuilder dueDate(Date dueDate){
            this.dueDate = dueDate;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                " manager ='" + getTaskManager() + '\'' +
                " employees ='" + getEmployees() + '\'' +
                " taskDesc ='" + getTaskDescrip() + '\'' +
                " dueDate ='" + getDueDate() + '\'' +
                '}';
    }
}