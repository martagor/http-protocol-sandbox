package service;

import dto.TaskDTO;

import java.util.List;

public interface IToDoService {
    boolean healthCheck();
    List<TaskDTO> findAllTaskByUser(String userId);
}
