package Constants;

public class Constants {
    public static String INVALID_DATA = "Введен неверный логин или пароль";
    public static String INVALID_DATE = "Нельзя добавлять мероприятие на прошедшую дату";
    public static String INVALID_TIME = "Нельзя добавлять мероприятие на прошедшее время";
    public static String ALREADY_EXIST_TIME = "Этот промежуток времени уже занят";
    public static String ALREADY_EXIST_DATA = "Пользователь с такими данными уже существует";
    public static String USER_EMPTY_DEVELOPMENT_MAP = "На данный момент у вас отсутствуют мероприятия";
    public static String ANY_EMPTY_DEVELOPMENT_MAP = "На данный момент по этой категории отсутствуют мероприятия";

    public static String LOGIN_PAGE_URL = "/logIn.jsp";
    public static String WELCOME_PAGE_URL = "/index.jsp";
    public static String REGISTRATION_PAGE_URL = "/registration.jsp";
    public static String USER_DEVELOPMENTS_INFO_URL = "/userDevelopmentsInfo.jsp";
    public static String ANY_DEVELOPMENTS_INFO_URL = "/anyDevelopmentsInfo.jsp";
    public static String EDIT_DATA_URL = "/editData.jsp";
    public static String ADD_DEVELOPMENT_PAGE_URL = "/addDevelopment.jsp";

    public final static String LOGIN_CONTROLLER = "/logIn";
    public final static String SHOW_DEVELOPMENT_CONTROLLER = "/showDevelopment";
    public final static String ADD_DEVELOPMENT_CONTROLLER = "/createNewDevelopment";
    public final static String DELETE_DEVELOPMENT_CONTROLLER = "/removeDevelopment";
    public final static String EDIT_INFO_CONTROLLER = "/editInfo";
    public final static String LOGOUT_CONTROLLER = "/logOut";
    public final static String REGISTRATION_CONTROLLER = "/registration";
    public final static String SHOW_DEVELOPMENT_DETAILS_CONTROLLER = "/showDevelopmentDetails";
    public final static String TYPE_SPECIFIER_CONTROLLER = "/defineType";
    public final static String SET_STATUS_CONTROLLER = "/setStatus";

    public final static String LOCATION_PARAMETER_LABEL = "location";
    public final static String LOGIN_PARAMETER_LABEL = "login";
    public final static String PASSWORD_PARAMETER_LABEL = "password";
    public final static String DATE_PARAMETER_LABEL = "date";
    public final static String DESCRIPTION_PARAMETER_LABEL = "description";
    public final static String TYPE_PARAMETER_LABEL = "type";
    public final static String EVENT_NAME_PARAMETER_LABEL = "eventName";
    public final static String EVENT_TIME_START_PARAMETER_LABEL = "eventTimeStart";
    public final static String EVENT_TIME_END_PARAMETER_LABEL = "eventTimeEnd";
    public final static String DEVELOPMENT_ID_PARAMETER_LABEL = "developmentId";
    public final static String CHOOSE_PARAMETER_LABEL = "choose";
    public final static String EDITED_PROPERTY_PARAMETER_LABEL = "edited_property";
    public final static String FIRST_NAME_PARAMETER_LABEL = "first_name";
    public final static String LAST_NAME_PARAMETER_LABEL = "last_name";
    public final static String EMAIL_PARAMETER_LABEL = "email";
    public final static String RETURN_URL_PARAMETER_LABEL = "return_url";

    public final static String USER_ATTRIBUTE_LABEL = "user";
    public final static String CHOOSE_ATTRIBUTE_LABEL = "choose";
    public final static String MESSAGE_ATTRIBUTE_LABEL = "message";
    public final static String DEVELOPMENT_MAP_ATTRIBUTE_LABEL = "developmentMap";
    public final static String DEVELOPMENT_DETAILS_ATTRIBUTE_LABEL = "developmentDetails";

    public final static String CONFERENCE_LABEL = "conference";
    public final static String TRAINING_LABEL = "training";
    public final static String SEMINAR_LABEL = "seminar";
}
