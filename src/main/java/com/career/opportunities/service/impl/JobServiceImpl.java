package com.career.opportunities.service.impl;

import com.career.opportunities.entity.Job;
import com.career.opportunities.repository.JobRepository;
import com.career.opportunities.service.JobService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.jboss.logging.Logger;

@ApplicationScoped
public class JobServiceImpl implements JobService {

    private static final Logger LOGGER = Logger.getLogger(JobServiceImpl.class.getName());

    @Inject
    JobRepository jobRepository;

    @Override
    @Transactional
    public Uni<Job> createJob(Job job) {
        return Uni.createFrom().item(() -> {
            try {
                jobRepository.persist(job);
                return job;
            } catch (Exception e) {
                LOGGER.error("Error creating job", e);
                throw new RuntimeException("Error creating job", e);
            }
        });
    }

    @Override
    public Uni<List<Job>> getAllJobs() {
        return Uni.createFrom().item(() -> {
            try {
                return jobRepository.listAll();
            } catch (Exception e) {
                LOGGER.error("Error retrieving all jobs", e);
                throw new RuntimeException("Error retrieving all jobs", e);
            }
        });
    }

    @Override
    public Uni<Optional<Job>> getJobById(Long id) {
        return Uni.createFrom().item(() -> {
            try {
                return Optional.ofNullable(jobRepository.findById(id));
            } catch (Exception e) {
                LOGGER.error("Error retrieving job by ID", e);
                throw new RuntimeException("Error retrieving job by ID", e);
            }
        });
    }

    @Override
    @Transactional
    public Uni<Void> deleteJobById(Long id) {
        return Uni.createFrom().voidItem().invoke(() -> {
            try {
                Job job = jobRepository.findById(id);
                if (job != null) {
                    jobRepository.deleteById(id);
                }
            } catch (Exception e) {
                LOGGER.error("Error deleting job by ID", e);
                throw new RuntimeException("Error deleting job by ID", e);
            }
        });
    }
}
