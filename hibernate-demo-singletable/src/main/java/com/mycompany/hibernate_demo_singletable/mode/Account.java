package com.mycompany.hibernate_demo_singletable.mode;


import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Account Person")
public class Account extends Person{
	private String bank;

	public Account() {
		super();
	}

	public Account(String name, String phone, Date dob,  String bank) {
		super(name,phone,dob);
		this.bank = bank;
	}
}
