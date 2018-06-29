package dev.entity;

import java.util.List;
import javax.persistence.*;

@Entity
public class User {

    public enum ROLES {
        COLLAB, DRIVER, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer id;
    private String email;
    private String password;
    private ROLES roles;
    private boolean is_active;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Booking> booking;

    public User() {}

    public User(String email, String password, ROLES roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.is_active = true;
    }

    public User(String email, String password, ROLES roles, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.is_active = true;
    }

    public User(String email, String password, ROLES roles, List<Booking> booking, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.is_active = true;
        this.booking = booking;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public ROLES getRoles() {
        return roles;
    }

    public void setRoles(ROLES roles) {
        this.roles = roles;
    }

    public boolean isIS_ACTIVE() {
        return is_active;
    }

    public void setIS_ACTIVE(boolean is_active) {
        this.is_active = is_active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}