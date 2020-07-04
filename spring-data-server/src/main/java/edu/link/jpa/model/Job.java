package edu.link.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="jobs")
public class Job implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="job_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="job_seq_gen")
	@SequenceGenerator(name="job_seq_gen", sequenceName="jobs_seq")
	private String jobId;
	
	@Column(name="job_title")
	private String title;
	
	@Column(name="min_salary")
	private Double minSalary;
	
	@Column(name="max_salary")
	private Double maxSalary;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}
}
