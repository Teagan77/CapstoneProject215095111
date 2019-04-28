package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Employee.Task;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface TaskRepository extends Repository<Task, String> {

    void removeAll();
    ArrayList<Task> getAll();
}
