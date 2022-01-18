package Enums;

public enum Type {
    CONFERENCE("конференция"), TRAINING("тренинг"), SEMINAR("семинар");

    String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
