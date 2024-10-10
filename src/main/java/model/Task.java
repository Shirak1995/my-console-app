package model;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private Category category;

    public Task(int id, String title, String description, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public Category getCategory() {
        return category;
    }
}
