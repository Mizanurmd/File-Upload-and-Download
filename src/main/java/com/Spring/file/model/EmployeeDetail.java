package com.Spring.file.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employeeaDetail")
public class EmployeeDetail extends Base{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  name ;
	private String disgnation;
	private String fName;
	private String email;
	private String phone;
	private String address;
	private String nid;
	private String birthDate;
	private String joinDate;
	private double salary;

}
