package com.example.springhillel.config;

import com.example.springhillel.model.dto.TicketDTO;
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
//@EnableBatchProcessing
public class SpringBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Bean
    public ItemReader<TicketDTO> itemReader(DataSource dataSource){

        return new JdbcCursorItemReaderBuilder<TicketDTO>()
                .name("itemReaderJdbc")
                .dataSource(dataSource)
                .sql("SELECT * FROM ticket_user")
                .rowMapper(new BeanPropertyRowMapper<>(TicketDTO.class))
                .build();

    }

    @Bean
    public ItemWriter<TicketDTO> itemWriter(DataSource dataSource){
//        JdbcBatchItemWriter<Ticket> writer = new JdbcBatchItemWriterBuilder<>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Ticket>());
//        writer.setSql("UPDATE ticket_user SET status_id = ? WHERE id = ?");
//        writer.setDataSource(dataSource);

        ItemPreparedStatementSetter<TicketDTO> itemPreparedStatementSetter = new TicketPreparedStatementSetter();
//        writer.setItemPreparedStatementSetter(itemPreparedStatementSetter);

        return new JdbcBatchItemWriterBuilder<TicketDTO>().dataSource(dataSource)
                .sql("UPDATE ticket_user SET status_id = ? WHERE id = ?")
                .itemPreparedStatementSetter(itemPreparedStatementSetter)
                .build();
    }

    @Bean
    public ItemProcessor<TicketDTO, TicketDTO> processor() {
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
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<TicketDTO> reader,
                      ItemWriter<TicketDTO> writer, ItemProcessor<TicketDTO, TicketDTO> processor) {
        return stepBuilderFactory.get("step1")
                .<TicketDTO, TicketDTO> chunk(10)
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
