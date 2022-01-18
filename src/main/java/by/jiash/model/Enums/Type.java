package by.jiash.model.Enums;

import by.jiash.Constants.Constants;

public enum Type {
    CONFERENCE(Constants.CONFERENCE_VALUE_LABEL),
    TRAINING(Constants.TRAINING_VALUE_LABEL),
    SEMINAR(Constants.SEMINAR_VALUE_LABEL);

    String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
