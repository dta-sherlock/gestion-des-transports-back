package dev.entity;

import javax.persistence.*;

@Entity
public class User {

    public enum ROLES {
        COLLAB, DRIVER, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private ROLES roles;
    private boolean IS_ACTIVE;
    @OneToOne
    private Booking booking;

    public User() {}

    public User(String email, String password, ROLES roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.IS_ACTIVE = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLES getRoles() { return roles; }

    public void setRoles(ROLES roles) { this.roles = roles; }

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}