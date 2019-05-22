package org.randall.teagan.Controllers.EmployeeController;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Employee.Task;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    @Qualifier("TaskServiceImpl")
    TaskServiceImpl taskServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Task create(@RequestBody Task task) {
        return taskServiceImpl.create(task);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Task update(@RequestBody Task task) {
        return taskServiceImpl.update(task);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        taskServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Task read(@PathVariable String id) {
        return taskServiceImpl.read(id);
    }

    @GetMapping(value = "/readTask/all")
    @ResponseBody
    public ArrayList<Task> getAll() {
        return taskServiceImpl.getAll();
    }
}

