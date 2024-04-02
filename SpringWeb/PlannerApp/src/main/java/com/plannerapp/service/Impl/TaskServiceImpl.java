package com.plannerapp.service.Impl;

import com.plannerapp.model.binding.AddTaskBindingModel;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import com.plannerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

   private final TaskRepository taskRepository;

   private final PriorityRepository priorityRepository;

   private UserService userService;

   private CurrentUser currentUser;

   private UserRepository userRepository;

   private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, PriorityRepository priorityRepository, UserService userService, CurrentUser currentUser, UserRepository userRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.userService = userService;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addTask(AddTaskBindingModel addTaskBindingModel) {
        Priority priority = priorityRepository.findByName(addTaskBindingModel.getPriority());
        User user = userRepository.findByUsername(currentUser.getUsername());

        if (priority != null || user != null){
            Task task = modelMapper.map(addTaskBindingModel, Task.class);

            task.setAssigned(user);
            task.setPriority(priority);

            taskRepository.save(task);
        }

    }

    @Override
    public List<Task> findAllAssignedToMe(Long id) {
        return taskRepository.findAllByAssigned_Id(id);
    }

    @Override
    public void taskToReturn(Long id,String username) {
        Optional<Task> taskId = taskRepository.findById(id);

        if (taskId.isPresent()) {

            Task task = taskId.get();
            if (username == null) {
                task.setAssigned(null);

            } else {
                User user = userRepository.findByUsername(currentUser.getUsername());
                task.setAssigned(user);
            }
                taskRepository.save(task);
            }

        }

    @Override
    public List<Task> findAllAvailableTask() {
        return taskRepository.findAllByAssignedIsNull();
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }
}
