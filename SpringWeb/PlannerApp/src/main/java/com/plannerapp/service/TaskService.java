package com.plannerapp.service;

import com.plannerapp.model.binding.AddTaskBindingModel;
import com.plannerapp.model.entity.Task;


import java.util.List;

public interface TaskService {
    void addTask(AddTaskBindingModel addTaskBindingModel);

    List<Task> findAllAssignedToMe(Long id);

    void taskToReturn(Long id, String username);


    List<Task> findAllAvailableTask();

    void remove(Long id);
}
