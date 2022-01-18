package model.Entities;

import Enums.Type;
import java.sql.Date;

public class Development {
    private int id;
    private String location;
    private User owner;
    private Date date;
    private boolean isPassed;
    private String description;
    private Type type;

    public Development(int id, String location, User owner, Date date, boolean isPassed, String description, Type type) {
        this.location = location;
        this.date = date;
        this.isPassed = isPassed;
        this.description = description;
        this.id = id;
        this.type = type;
        this.owner = owner;
    }

    public Development(int id, String location, Date date, boolean isPassed, String description, Type type) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.isPassed = isPassed;
        this.description = description;
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public User getOwner() {
        return owner;
    }
}

