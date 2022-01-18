package by.jiash.DTO;

import by.jiash.model.Enums.Type;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Arrays;

//DevelopmentDTO
public class AddDevelopmentRequest {
    private final int id;
    private final String location;
    private final Date date;
    private final String description;
    private final Type type;
    private final String[] eventNames;
    private final LocalTime[] timesStart;
    private final LocalTime[] timesEnd;

    public AddDevelopmentRequest(int id, String location, Date date, String description, Type type, String[] eventNames, LocalTime[] timesStart, LocalTime[] timesEnd) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.description = description;
        this.type = type;
        this.eventNames = eventNames;
        this.timesStart = timesStart;
        this.timesEnd = timesEnd;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public String[] getEventNames() {
        return eventNames;
    }

    public LocalTime[] getTimesStart() {
        return timesStart;
    }

    public LocalTime[] getTimesEnd() {
        return timesEnd;
    }

    @Override
    public String toString() {
        return "AddDevelopmentRequest{" +
                "id=" + id + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", eventNames=" + Arrays.toString(eventNames) +
                ", timesStart=" + Arrays.toString(timesStart) +
                ", timesEnd=" + Arrays.toString(timesEnd) +
                '}';
    }
}
