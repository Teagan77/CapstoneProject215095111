package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.randall.teagan.Domain.Employee.Task;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.TaskRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service("TaskServiceImpl")
public class TaskServiceImpl implements TaskServiceInterface {

    @Autowired
    @Qualifier("TaskRepository")
    private TaskRepositoryImpl taskRepositoryImpl;

    @Override
    public Task create(Task task) {
        return taskRepositoryImpl.create(task);
    }

    @Override
    public Task update(Task task) {
        return taskRepositoryImpl.update(task);
    }

    @Override
    public void delete(String taskId) {
        taskRepositoryImpl.delete(taskId);
    }

    @Override
    public Task read(String taskId) {
        return taskRepositoryImpl.read(taskId);
    }

    @Override
    public ArrayList<Task> getAll() {
        return taskRepositoryImpl.getAll();
    }
}
