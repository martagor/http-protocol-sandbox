package service.impl;

import dto.TaskDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import service.IToDoService;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.OK;

public class ToDoServiceImpl implements IToDoService {

    public RestTemplate restTemplate;
    public String baseUrl = "https://shrouded-fjord-81597.herokuapp.com/api";

    public ToDoServiceImpl() {
        restTemplate = new RestTemplate();
    }

    public boolean healthCheck() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(baseUrl+ "/health-check", String.class);
        return responseEntity.getStatusCode() == OK;
    }

    public List<TaskDTO> findAllTaskByUser(String userId) {

        ResponseEntity<TaskDTO[]> response = restTemplate.getForEntity(baseUrl + "/task/all/" + userId, TaskDTO[].class);
        return asList(response.getBody());
    }

    public TaskDTO createNewTask(String value, Long userId, Boolean completed) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setUser(userId);
        taskDTO.setValue(value);
        taskDTO.setCompleted(completed);
        HttpEntity<TaskDTO> requestBody = new HttpEntity<>(taskDTO);
        ResponseEntity<TaskDTO> response = restTemplate.exchange(baseUrl + "/task/", HttpMethod.PUT,
                requestBody, TaskDTO.class);
        return response.getBody();

    }

    public boolean updateTask(Long id) {
        return false;
    }

    public TaskDTO updateTask(TaskDTO taskDTO) {
        return restTemplate.exchange(baseUrl + "/task/", HttpMethod.PUT,
                new HttpEntity<>(taskDTO), TaskDTO.class).getBody();
    }

    public boolean deleteTask(Long id) {
        ResponseEntity<Void> result = restTemplate.exchange(baseUrl + "/task/" + id, HttpMethod.DELETE, null, Void.class);
        return result.getStatusCode() == OK;
    }
}
