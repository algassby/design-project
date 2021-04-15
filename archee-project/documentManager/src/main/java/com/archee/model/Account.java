package com.archee.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "security_account")
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8911843823475275671L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String  mail;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = com.archee.model.Profile.class)
	private Profile profil;
	
	@OneToOne( targetEntity = com.archee.model.Role.class)
	private Role role;

	public Account() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfil() {
		return profil;
	}

	public void setProfil(Profile profil) {
		this.profil = profil;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
