package data;

public class User {
    private String name;
    private int id;
    private String user;
    private String password;
    private Boolean Adm;
    
    public User(){
        
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

    public void setContraseña(String contrasena) {
        this.password = contrasena;
    }

    public void setAccount(Boolean Adm) {
        this.Adm = Adm;
    }
}