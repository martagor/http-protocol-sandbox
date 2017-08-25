package dto;

public class TaskDTO {

    private Long id;
    private Long user;
    private String value;
    private Boolean completed;

    public TaskDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", user=" + user +
                ", value='" + value + '\'' +
                ", completed=" + completed +
                '}';
    }
}
