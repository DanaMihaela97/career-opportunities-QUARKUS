package com.career.opportunities.service;

import com.career.opportunities.entity.Job;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.Optional;

public interface JobService {
    Uni<Job> createJob(Job job);
    Uni<List<Job>> getAllJobs();
    Uni<Optional<Job>> getJobById(Long id);
    Uni<Void> deleteJobById(Long id);

}
