package com.mycompany.hibernate_demo_singletable.table_per_class;


import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "labor")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Labor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;

	public Labor() {

	}

}