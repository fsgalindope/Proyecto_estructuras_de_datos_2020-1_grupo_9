package data;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int id;
    private String user;
    private String password;
    private Boolean Adm;

    public User() {

    }

    public Boolean getAdm() {
        return Adm;
    }

    public void setAdm(Boolean Adm) {
        this.Adm = Adm;
    }

    public User(String name, int id, String user, String password, Boolean Adm) {
        this.name = name;
        this.id = id;
        this.user = user;
        this.password = password;
        this.Adm = Adm;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAccount() {
        return Adm;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(Boolean Adm) {
        this.Adm = Adm;
    }

    public String toString() {
        int ad = 0;
        if (Adm) {
            ad = 1;
        }
        return (user + ";" + String.valueOf(id) + ";" + name + ";" + password + ";" + String.valueOf(ad));
    }
}