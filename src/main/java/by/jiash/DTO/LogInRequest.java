package by.jiash.DTO;

//UserDTO
public class LogInRequest {
    private final String login;
    private final String password;

    public LogInRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
