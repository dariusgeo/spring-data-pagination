package edu.link.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="job_history")
public class JobHistory implements Serializable{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId JobHistoryPK jobHistoryID;
	
	@Column(name="end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="department_id")
	private Department department;

	public JobHistoryPK getJobHistoryID() {
		return jobHistoryID;
	}

	public void setJobHistoryID(JobHistoryPK jobHistoryID) {
		this.jobHistoryID = jobHistoryID;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}