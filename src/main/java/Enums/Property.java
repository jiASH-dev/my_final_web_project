package Enums;

import Constants.SQLRequests;

public enum Property {
    FIRST_NAME(SQLRequests.FIRST_NAME_POSTSCRIPT),
    LAST_NAME(SQLRequests.LAST_NAME_POSTSCRIPT),
    EMAIL(SQLRequests.EMAIL_POSTSCRIPT),
    PASSWORD(SQLRequests.PASSWORD_POSTSCRIPT);

    String value;

    Property(String value) {
        this.value = value;
    }

    public String getValue() {
        return SQLRequests.GLOBAL_EDIT_REQUEST + value;
    }
}
