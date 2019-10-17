package com.mycompany.hibernate_demo_mapping.dao;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
 
@Data
@Entity
@Table(name = "instructor")
public class Customer implements Serializable {
	private static final long serialVersionUID = -266053600262638923L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Instructor id_1;
}
