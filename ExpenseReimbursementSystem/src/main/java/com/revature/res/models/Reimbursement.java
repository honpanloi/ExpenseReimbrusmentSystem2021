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
@Table(name = "reimbursement", schema = "ers_2021")
public class Reimbursement {
	@Id
	@Column
	@GeneratedValue(generator = "ers_2021.employee_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "ers_2021.reimbursement_id_seq", sequenceName = "ers_2021.reimbursement_id_seq")
	private long reimb_id;
	@Column
	private long belongs_to_empl_id;
	@Column
	private long process_by_empl_id;
	@Column
	private String reimb_status;
	@Column
	private String time_requested;
	@Column
	private double reimb_amount;
	@Column
	private String time_completed;
	@Column
	private Date event_occurred;
	public long getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(long reimb_id) {
		this.reimb_id = reimb_id;
	}
	public long getBelongs_to_empl_id() {
		return belongs_to_empl_id;
	}
	public void setBelongs_to_empl_id(long belongs_to_empl_id) {
		this.belongs_to_empl_id = belongs_to_empl_id;
	}
	public long getProcess_by_empl_id() {
		return process_by_empl_id;
	}
	public void setProcess_by_empl_id(long process_by_empl_id) {
		this.process_by_empl_id = process_by_empl_id;
	}
	public String getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	public String getTime_requested() {
		return time_requested;
	}
	public void setTime_requested(String time_requested) {
		this.time_requested = time_requested;
	}
	public double getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public String getTime_completed() {
		return time_completed;
	}
	public void setTime_completed(String time_completed) {
		this.time_completed = time_completed;
	}
	public Date getEvent_occurred() {
		return event_occurred;
	}
	public void setEvent_occurred(Date event_occurred) {
		this.event_occurred = event_occurred;
	}
	public Reimbursement(long reimb_id, long belongs_to_empl_id, long process_by_empl_id, String reimb_status,
			String time_requested, double reimb_amount, String time_completed, Date event_occurred) {
		super();
		this.reimb_id = reimb_id;
		this.belongs_to_empl_id = belongs_to_empl_id;
		this.process_by_empl_id = process_by_empl_id;
		this.reimb_status = reimb_status;
		this.time_requested = time_requested;
		this.reimb_amount = reimb_amount;
		this.time_completed = time_completed;
		this.event_occurred = event_occurred;
	}
	public Reimbursement() {
	
	}
	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", belongs_to_empl_id=" + belongs_to_empl_id
				+ ", process_by_empl_id=" + process_by_empl_id + ", reimb_status=" + reimb_status + ", time_requested="
				+ time_requested + ", reimb_amount=" + reimb_amount + ", time_completed=" + time_completed
				+ ", event_occurred=" + event_occurred + "]";
	}
	
	
}
