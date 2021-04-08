package com.example.springhillel.config;

import com.example.springhillel.model.entity.Ticket;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {

 /*   @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

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
//        JdbcBatchItemWriter<Ticket> writer = new JdbcBatchItemWriterBuilder<>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Ticket>());
//        writer.setSql("UPDATE ticket_user SET status_id = ? WHERE id = ?");
//        writer.setDataSource(dataSource);

        ItemPreparedStatementSetter<Ticket> itemPreparedStatementSetter = new TicketPreparedStatementSetter();
//        writer.setItemPreparedStatementSetter(itemPreparedStatementSetter);

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
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(jobBuilderFactory)
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
    }*/

}
