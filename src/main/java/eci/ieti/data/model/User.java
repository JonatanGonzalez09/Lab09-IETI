package eci.ieti.data.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;

    private String name;
    private String email;

    public User() {

    }

    public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }   

    @Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
