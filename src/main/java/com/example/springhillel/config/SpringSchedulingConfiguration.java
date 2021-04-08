package com.example.springhillel.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
//@EnableScheduling
public class SpringSchedulingConfiguration {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    JobExplorer jobExplorer;

/*    @Autowired
    public JobOperator jobOperator;*/

    private AtomicBoolean enabled = new AtomicBoolean(true);
    private AtomicInteger batchRunCounter = new AtomicInteger(0);
/*
    @Autowired
    JobInstance jobInstance;*/

    @Autowired
    JobRepository jobRepository;

    @Autowired
    Job job;

    private JobExecution execution;


    @Scheduled(fixedDelay = 10000)
    @Async
    public void scheduleFixedDelayTask() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);

        JobParameters param = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

        jobLauncher.run(job, param);

//            execution = jobLauncher.run(job, new JobParameters());

    }
}
