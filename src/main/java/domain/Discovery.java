package domain;

import java.time.LocalDateTime;

public class Discovery {
    private int id;
    private String title;
    private String url;
    private String description;
    private LocalDateTime dateTime;
    private int categoryId;
    private int userId;

    public Discovery(String title, String url, String description, LocalDateTime dateTime, int categoryId, int userId) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.dateTime = dateTime;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Discovery() {
    }

    public Discovery(String title, String url, String description, LocalDateTime dateTime, int categoryId) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.dateTime = dateTime;
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        categoryId = categoryId;
    }
}
