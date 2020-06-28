package com.example.Practice.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity 
@Table(name="user")
public class User {
	@Id
   // @Column(name="id")
    @NotNull(message="may not be null")
	private int id;
	//@Column(name="pswd")
	@NotNull
	@Size(min=3,max=10)
	private String pswd;
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pswd=" + pswd + "]";
	}
	public User(int id, String pswd) {
		super();
		this.id = id;
		this.pswd = pswd;
	}

	
	
}
