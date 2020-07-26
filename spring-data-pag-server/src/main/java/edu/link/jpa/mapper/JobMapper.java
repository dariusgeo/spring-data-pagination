package edu.link.jpa.mapper;

import edu.link.jpa.dto.JobDTO;
import edu.link.jpa.model.Job;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobDTO jobToJobDTO(Job employee);

    List<JobDTO> jobsToJobDTOs(List<Job> jobs);

    Job jobDTOToJob(JobDTO job);

    List<Job> jobDTOsToJobs(List<JobDTO> jobs);
}
