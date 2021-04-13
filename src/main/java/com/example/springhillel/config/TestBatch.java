package com.example.springhillel.config;

import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.repository.AbstractRepository;
import com.example.springhillel.springbatch.ticket.TicketItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class TestBatch {

 /*   @Autowired
    private AbstractRepository<Ticket> abstractRepository;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    TicketTest ticketTest;

    @Bean
    public ItemReader<Ticket> itemReader(){

//        RepositoryItemReader<Ticket> reader = new RepositoryItemReader<>();

       *//* reader.setRepository((PagingAndSortingRepository<?, ?>) abstractRepository);
        reader.setMethodName("findAll");*//*
        *//*reader.setPageSize(this.pageSize);
        reader.setCurrentItemCount(this.currentItemCount);
        reader.setMaxItemCount(this.maxItemCount);
        reader.setSaveState(this.saveState);
        reader.setSort(this.sorts);
        reader.setName(this.name);*//*

        Map<String, Sort.Direction> sortMap = new HashMap<>();
        sortMap.put("id", Sort.Direction.DESC);

        return new RepositoryItemReaderBuilder<Ticket>()
                .repository(ticketTest)
                .methodName("findAll")
                .sorts(sortMap)
                .saveState(false)
                .build();

    }

    @Bean
    public ItemWriter<Ticket> itemWriter(){

        return new RepositoryItemWriterBuilder<Ticket>()
                .repository(abstractRepository)
                .methodName("save")
                .build();
    }

    @Bean
    public Job importTicketJob(JobBuilderFactory  jobBuilderFactory, Step step1) {
        return jobBuilderFactory.get("importTicketJobTest1")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Ticket> reader,
                      ItemWriter<Ticket> writer, ItemProcessor<Ticket, Ticket> processor) {
        return stepBuilderFactory.get("step1")
                .<Ticket, Ticket> chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public ItemProcessor<Ticket, Ticket> processor() {
        return new TicketItemProcessor();
    }

   *//* @Bean
    public ItemProcessor<Ticket, Ticket> myProcessor() {
        return it -> {
            System.out.println(it);
            return it;
        };
    }*/

}
