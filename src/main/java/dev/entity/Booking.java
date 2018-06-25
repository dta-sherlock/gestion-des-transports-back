package dev.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private LocalDateTime bookedAt;
	private LocalDateTime returnsAt;
	@OneToOne
	private User user;
	
	public Booking(){
		
	}
	
	public Booking(LocalDateTime bookedAt, LocalDateTime returnsAt){
		this.bookedAt = bookedAt;
		this.returnsAt = returnsAt;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getBookedAt() {
		return bookedAt;
	}
	public void setBookedAt(LocalDateTime bookedAt) {
		this.bookedAt = bookedAt;
	}
	public LocalDateTime getReturnsAt() {
		return returnsAt;
	}
	public void setReturnsAt(LocalDateTime returnsAt) {
		this.returnsAt = returnsAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
