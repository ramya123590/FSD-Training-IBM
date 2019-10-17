package com.mycompany.hibernate_demo_singletable.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity  
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="CONTRACTOR")   
@PrimaryKeyJoinColumn(name = "ID")

public class Contractor extends Labor{
 
 @Column(name="pay_per_hour")
 private float pay_per_hour;
 
 @Column(name="contract_duration")
 private String contract_duration;

}