package service;

import dto.TaskDTO;

import java.util.List;

public interface IToDoService {
    boolean healthCheck();
    List<TaskDTO> findAllTaskByUser(String userId);
    TaskDTO createNewTask(String value, Long userId, Boolean completed);
    TaskDTO updateTask(TaskDTO taskDTO);
    boolean deleteTask(Long id);
}
