package com.example.springhillel.config;

import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.springbatch.ticket.TicketItemProcessor;
import com.example.springhillel.springbatch.ticket.TicketPreparedStatementSetter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class SpringBatchConfiguration {

    @Autowired
    protected JobBuilderFactory jobBuilderFactory;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<Ticket> itemReader(DataSource dataSource){

        return new JdbcCursorItemReaderBuilder<Ticket>()
                .name("itemReaderJdbc")
                .dataSource(dataSource)
                .sql("SELECT * FROM ticket_user")
                .rowMapper(new BeanPropertyRowMapper<>(Ticket.class))
                .build();

    }

    @Bean
    public ItemWriter<Ticket> itemWriter(DataSource dataSource){

        ItemPreparedStatementSetter<Ticket> itemPreparedStatementSetter = new TicketPreparedStatementSetter();

        return new JdbcBatchItemWriterBuilder<Ticket>().dataSource(dataSource)
                .sql("UPDATE ticket_user SET status_id = ? WHERE id = ?")
                .itemPreparedStatementSetter(itemPreparedStatementSetter)
                .build();
    }

    @Bean
    public ItemProcessor<Ticket, Ticket> processor() {
        return new TicketItemProcessor();
    }

    @Bean
    public Job importTicketJob(JobBuilderFactory  jobBuilderFactory, Step step1) {
        return jobBuilderFactory.get("importTicketJobTest1")
                .incrementer(new RunIdIncrementer())
//                .listener(jobBuilderFactory)
//                .preventRestart()
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
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
