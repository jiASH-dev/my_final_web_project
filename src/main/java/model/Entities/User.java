package model.Entities;

public class User {
    private int id;
    private String FirstName;
    private String LastName;
    private String login;
    private String email;

    public User(int id, String FirstName, String LastName, String login, String email) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.login = login;
        this.email = email;
    }

    public User(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}
