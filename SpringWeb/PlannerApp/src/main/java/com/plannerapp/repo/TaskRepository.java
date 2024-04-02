package com.plannerapp.repo;

import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

        List<Task> findAllByAssignedIsNull();

//    @Query("SELECT t FROM Task t WHERE t.assigned is NULL")
//    List<Task> getAllAvailable();


        List<Task> findAllByAssigned_Id(Long id);
}
