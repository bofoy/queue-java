package com.bofoy.queue.domain.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class JobDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "job_id")
	private int jobId;
	
	@Column(name = "lineman_name")
	private String linemanName;
	
	@Column(name = "agent_name")
	private String agentName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "total_amount")
	private BigDecimal totalAmount;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "start_time")
	private Timestamp startTime;
	
	@Column(name = "end_time")
	private Timestamp endTime;
	
	@Column(name = "job_completed")
	private boolean completed;

	public JobDTO() {}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getLinemanName() {
		return linemanName;
	}

	public void setLinemanName(String linemanName) {
		this.linemanName = linemanName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getDuration() {
		return duration;
	}
	
	public boolean getCompleted() {
		return completed;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
