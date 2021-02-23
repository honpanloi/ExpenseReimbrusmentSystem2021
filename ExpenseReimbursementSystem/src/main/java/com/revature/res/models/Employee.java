package com.revature.res.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "ers_2021")
public class Employee {
	@Id
	@Column
	@GeneratedValue(generator = "ers_2021.employee_id_seq", strategy = GenerationType.AUTO)
	//@SequenceGenerator(allocationSize = 1, name = "ers_2021.employee_id_seq", sequenceName = "ers_2021.employee_id_seq")
	private long empl_id;
	@Column
	private long direct_manager_empl_id;
	@Column
	private String position;
	@Column
	private String email;
	@Column
	private Date dob;
	@Column
	private long prim_phone;
	@Column
	private double amount_reimbursed_of_the_year;
	public long getEmpl_id() {
		return empl_id;
	}
	public void setEmpl_id(long empl_id) {
		this.empl_id = empl_id;
	}
	public long getDirect_manager_empl_id() {
		return direct_manager_empl_id;
	}
	public void setDirect_manager_empl_id(long direct_manager_empl_id) {
		this.direct_manager_empl_id = direct_manager_empl_id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getPrim_phone() {
		return prim_phone;
	}
	public void setPrim_phone(long prim_phone) {
		this.prim_phone = prim_phone;
	}
	public double getAmount_reimbursed_of_the_year() {
		return amount_reimbursed_of_the_year;
	}
	public void setAmount_reimbursed_of_the_year(double amount_reimbursed_of_the_year) {
		this.amount_reimbursed_of_the_year = amount_reimbursed_of_the_year;
	}
	public Employee(long empl_id, long direct_manager_empl_id, String position, String email, Date dob, long prim_phone,
			double amount_reimbursed_of_the_year) {
		super();
		this.empl_id = empl_id;
		this.direct_manager_empl_id = direct_manager_empl_id;
		this.position = position;
		this.email = email;
		this.dob = dob;
		this.prim_phone = prim_phone;
		this.amount_reimbursed_of_the_year = amount_reimbursed_of_the_year;
	}
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [empl_id=" + empl_id + ", direct_manager_empl_id=" + direct_manager_empl_id + ", position="
				+ position + ", email=" + email + ", dob=" + dob + ", prim_phone=" + prim_phone
				+ ", amount_reimbursed_of_the_year=" + amount_reimbursed_of_the_year + "]";
	}
	
}
