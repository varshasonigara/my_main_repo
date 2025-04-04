package com.example.springbatchdemo.config;

import com.example.springbatchdemo.business.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    @Bean
    public FlatFileItemReader<Person> reader() {
        return  new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("sample-data.csv"))
                .delimited()
                .names("firstName", "lastName")
                .targetType(Person.class)
                .build();
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Person>()
                .dataSource(dataSource)
                .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
                .beanMapped()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
                      FlatFileItemReader<Person> itemReader, JdbcBatchItemWriter<Person> itemWriter) {
        return new StepBuilder("step1", jobRepository)
                .<Person, Person>chunk(3, transactionManager)
                .reader(itemReader)
                .writer(itemWriter)
                .processor(processor())
                .build();
    }

    @Bean
    public Job importJob(JobRepository jobRepository, Step step, JobCompletionNotificationListener listener) {
        return new JobBuilder("importJob", jobRepository)
                .start(step)
                .listener(listener)
                .build();
    }
}
