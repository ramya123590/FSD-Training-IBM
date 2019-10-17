package com.mycompany.hibernate_demo_singletable.mode;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Employee Person")
public class Employee extends Person {
	private String postion;
	private String location;

	public Employee() {
	}

	public Employee(String name, String phone, Date dob, String position, String location) {
		super(name,phone,dob);
		postion = position;
		this.location = location;
	}
}