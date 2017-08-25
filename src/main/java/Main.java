import service.IToDoService;
import service.impl.ToDoServiceImpl;

public class Main {
    public static void main(String[] args) {

        IToDoService toDoService = new ToDoServiceImpl();
        System.out.println(toDoService.healthCheck());

        toDoService.findAllTaskByUser("1").stream().forEach(System.out::println);
    }
}
