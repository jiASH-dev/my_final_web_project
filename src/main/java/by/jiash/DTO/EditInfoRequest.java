package by.jiash.DTO;

import by.jiash.model.Enums.Property;

public class EditInfoRequest {
    private final int id;
    private final String newValue;
    private final Property property;

    public EditInfoRequest(int id, String newValue, Property property) {
        this.id = id;
        this.newValue = newValue;
        this.property = property;
    }

    public int getId() {
        return id;
    }

    public String getNewValue() {
        return newValue;
    }

    public Property getProperty() {
        return property;
    }
}
