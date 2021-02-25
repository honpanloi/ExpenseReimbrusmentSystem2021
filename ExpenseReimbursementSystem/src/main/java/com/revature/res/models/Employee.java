package com.revature.res.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "ers_2021")
public class Employee {
	@Id
	@Column
	@GeneratedValue(generator = "ers_2021.employee_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "ers_2021.employee_id_seq", sequenceName = "ers_2021.employee_id_seq")
	private long empl_id;
	@Column
	private Long direct_manager_empl_id;
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
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private boolean is_manager;
	public long getEmpl_id() {
		return empl_id;
	}
	public void setEmpl_id(long empl_id) {
		this.empl_id = empl_id;
	}
	public Long getDirect_manager_empl_id() {
		return direct_manager_empl_id;
	}
	public void setDirect_manager_empl_id(Long direct_manager_empl_id) {
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public boolean isIs_manager() {
		return is_manager;
	}
	public void setIs_manager(boolean is_manager) {
		this.is_manager = is_manager;
	}
	public Employee(long empl_id, Long direct_manager_empl_id, String position, String email, Date dob, long prim_phone,
			double amount_reimbursed_of_the_year, String first_name, String last_name, boolean is_manager) {
		super();
		this.empl_id = empl_id;
		this.direct_manager_empl_id = direct_manager_empl_id;
		this.position = position;
		this.email = email;
		this.dob = dob;
		this.prim_phone = prim_phone;
		this.amount_reimbursed_of_the_year = amount_reimbursed_of_the_year;
		this.first_name = first_name;
		this.last_name = last_name;
		this.is_manager = is_manager;
	}
	
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [empl_id=" + empl_id + ", direct_manager_empl_id=" + direct_manager_empl_id + ", position="
				+ position + ", email=" + email + ", dob=" + dob + ", prim_phone=" + prim_phone
				+ ", amount_reimbursed_of_the_year=" + amount_reimbursed_of_the_year + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", is_manager=" + is_manager + "]";
	}
	
	
	
}
