package com.company;

public class UserObject {
    private String user;
    private String password;

    public UserObject(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(UserObject obj) {
        try {
            if (user.equals(obj.getUser()) && password.equals(obj.getPassword()))
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean isValid() {
        if (UserUtils.ValidChars(user) && UserUtils.ValidChars(password)) {
            return true;
        }
        return false;
    }
}
