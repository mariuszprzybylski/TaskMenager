package pl.mprzybylski.taskMenager.dao;

import pl.mprzybylski.taskMenager.model.Task;

import java.util.List;

public interface TaskDao {

    List<Task> findAll();

    void add(Task task);

    Task findById(int id);

    void deleteById(int id);

    List<Task> allFinished();

    List<Task> allUnFinished();

    void update(Task task);

}
