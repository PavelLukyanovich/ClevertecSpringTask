package ru.clevertec.ecl.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Configuration
@ComponentScan("ru.clevertec.ecl")
@EnableWebMvc
public class ConfigurationApp {

    @Bean
    public Connection connection() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/certificate_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(30);
        return dataSource.getConnection();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws SQLException {
        return new JdbcTemplate(new SingleConnectionDataSource(connection(), false));
    }

    @Bean
    public DatabasePopulator databasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        ClassPathResource script = new ClassPathResource("data.sql");
        databasePopulator.addScript(script);
        System.out.println(script);
        System.out.println("!!!!");
        return databasePopulator;


    }
}
