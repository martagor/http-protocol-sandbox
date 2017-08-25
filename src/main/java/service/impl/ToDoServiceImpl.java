package service.impl;

import dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import service.IToDoService;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class ToDoServiceImpl implements IToDoService {

    public RestTemplate restTemplate;
    public String baseUrl = "https://shrouded-fjord-81597.herokuapp.com/api";

    public ToDoServiceImpl() {
        restTemplate = new RestTemplate();
    }

    public boolean healthCheck() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(baseUrl+ "/health-check", String.class);
        return responseEntity.getStatusCode() == HttpStatus.OK;
    }

    public List<TaskDTO> findAllTaskByUser(String userId) {

        ResponseEntity<TaskDTO[]> response = restTemplate.getForEntity(baseUrl + "/task/all/" + userId, TaskDTO[].class);
        return asList(response.getBody());
    }
}
