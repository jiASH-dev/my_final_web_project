package Enums;

import Constants.SQLRequests;

public enum Section {
    TODAY(SQLRequests.TODAY_POSTSCRIPT),
    TOMORROW(SQLRequests.TOMORROW_POSTSCRIPT),
    SOON(SQLRequests.SOON_POSTSCRIPT),
    PAST(SQLRequests.PAST_POSTSCRIPT),
    ALL(SQLRequests.ALL_POSTSCRIPT),
    SELF(SQLRequests.SELF_POSTSCRIPT);

    String value;

    Section(String value) {
        this.value = value;
    }

    public String getValue() {
        return SQLRequests.GLOBAL_FINDER_REQUEST + value;
    }
}
