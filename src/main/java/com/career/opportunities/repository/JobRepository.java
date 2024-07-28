package com.career.opportunities.repository;

import com.career.opportunities.entity.Job;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JobRepository implements PanacheRepositoryBase<Job, Long> {

}
