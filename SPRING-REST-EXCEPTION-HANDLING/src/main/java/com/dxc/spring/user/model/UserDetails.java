package com.dxc.spring.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User_Details")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(initialValue = 1000,
	    		allocationSize = 1,
	    		name = "user_sequence",
	    		sequenceName = "user_sequence")
    @GeneratedValue(generator = "user_sequence")
    @Column(name = "User_Id")
    private long userId;
    
    @NotNull
    @NotEmpty
    @Column(name = "First_Name")
    private String firstName;
    
    @Column(name = "Last_Name")
    private String lastName;

    public UserDetails() {
	super();
    }

    public UserDetails(long userId, String firstName, String lastName) {
	super();
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
