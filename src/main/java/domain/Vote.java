package domain;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class Vote {
    private int userId;
    private int discoveryId;
    private Type type;
    private LocalDateTime time;

    public Vote() {
    }

    public Vote(int userId, int discoveryId, Type type, LocalDateTime time) {
        this.userId = userId;
        this.discoveryId = discoveryId;
        this.type = type;
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDiscoveryId() {
        return discoveryId;
    }

    public void setDiscoveryId(int discoveryId) {
        this.discoveryId = discoveryId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
