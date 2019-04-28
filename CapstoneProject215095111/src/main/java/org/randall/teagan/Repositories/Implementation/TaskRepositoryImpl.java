package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Employee.Task;
import org.randall.teagan.Repositories.RepositoryInterfaces.TaskRepository;

import java.util.ArrayList;

public class TaskRepositoryImpl implements TaskRepository {

    private ArrayList<Task> tasks;

    private static TaskRepositoryImpl taskRepositoryImpl;

    private TaskRepositoryImpl(){
        this.tasks = new ArrayList<>();
    }

    protected static TaskRepositoryImpl getTaskRepositoryImpl(){
        if(taskRepositoryImpl == null){
            taskRepositoryImpl = new TaskRepositoryImpl();
        }
        return taskRepositoryImpl;
    }


    @Override
    public Task create(Task task) {
        this.tasks.add(task);
        return task;
    }

    @Override
    public Task update(Task task) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < tasks.size();i++) {

            if (tasks.get(i).getTaskNo() == task.getTaskNo()) {
                exists = true;
                index = i;
                tasks.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent task.");
        }

        tasks.add(index, task);
        return task;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < tasks.size();i++) {

            if (tasks.get(i).getTaskNo() == id) {
                tasks.remove(i);
            }
        }
    }

    @Override
    public Task read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < tasks.size();i++) {

            if (tasks.get(i).getTaskNo() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return tasks.get(index);
    }

    @Override
    public ArrayList<Task> getAll() {
        return tasks;
    }

    @Override
    public void removeAll() {
        tasks.removeAll(tasks);
    }
}
