package com.example.springhillel.config;


import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.repository.TicketRepository;
import com.example.springhillel.repository.jpaRepository.JpaTicketRepositoryImpl;
import org.hibernate.dialect.Database;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class ConfigTest {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    EntityManagerFactory emf;

    @Autowired
    DataSource dataSource;


    @Bean
    public ItemReader<Ticket> itemReader() {
       /* JpaCursorItemReaderBuilder<Ticket> jpaCursorItemReaderBuilder = new JpaCursorItemReaderBuilder<>();
        jpaCursorItemReaderBuilder.entityManagerFactory(emf);
        jpaCursorItemReaderBuilder.queryString("SELECT t FROM Ticket t");
        jpaCursorItemReaderBuilder.build();
        jpaCursorItemReaderBuilder.saveState(true);*/
        JpaCursorItemReader<Ticket> s = new JpaCursorItemReader<>();

        s.setEntityManagerFactory(emf);
        s.setQueryString("SELECT t FROM Ticket t");
        s.setSaveState(true);


        return s;

    }

    @Bean
    public ItemProcessor<Ticket, Ticket> processor() {
        return new TicketItemProcessor();
    }

    @Bean
    public ItemWriter<Ticket> writer() {
        JpaItemWriter<Ticket> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(emf);

        return writer;
    }

    @Bean
    public Job importTicket(JobBuilderFactory jobs, Step s1) {

        return jobs.get("import")
                .incrementer(new RunIdIncrementer())
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Ticket> reader,
                      ItemWriter<Ticket> writer, ItemProcessor<Ticket, Ticket> processor) {
        return stepBuilderFactory.get("step1")
                .<Ticket, Ticket>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
