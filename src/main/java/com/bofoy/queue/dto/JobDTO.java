package com.bofoy.queue.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
	
	@Column(name = "lineman_email")
	private String linemanEmail;
	
	@Column(name = "agent_email")
	private String agentEmail;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "total_amount")
	private BigDecimal totalAmount;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "start_time")
	private LocalDateTime startTime;
	
	@Column(name = "end_time")
	private LocalDateTime endTime;
	
	@Column(name = "job_completed")
	private boolean completed;

	public JobDTO() {}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getLinemanEmail() {
		return linemanEmail;
	}

	public void setLinemanEmail(String linemanEmail) {
		this.linemanEmail = linemanEmail;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
