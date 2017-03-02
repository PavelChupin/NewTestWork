package ru.addressbook.data;

public class LoginData {
    private final String user;
    private final String password;

    public LoginData(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
