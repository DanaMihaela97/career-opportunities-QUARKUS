package com.career.opportunities.service.impl;

import com.career.opportunities.entity.Job;
import com.career.opportunities.repository.JobRepository;
import com.career.opportunities.service.JobService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class JobServiceImpl implements JobService {

    @Inject
    JobRepository jobRepository;

    @Override
    public Uni<Job> createJob(Job job) {
        return Uni.createFrom().item(()->{
            jobRepository.persist(job);
            return job;
        });
    }

    @Override
    public Uni<List<Job>> getAllJobs() {
        return Uni.createFrom().item(jobRepository::listAll);
    }

    @Override
    public Uni<Optional<Job>> getJobById(Long id) {
        return Uni.createFrom().item(() -> Optional.ofNullable(jobRepository.findById(id)));
    }

    @Override
    public Uni<Void> deleteJobById(Long id) {
        return Uni.createFrom().voidItem().invoke(()->{
            Job job = jobRepository.findById(id);
            if (job!=null){
                jobRepository.deleteById(id);
            }
        });
    }
}
