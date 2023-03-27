package ru.clevertec.ecl.configuration;

import lombok.Data;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.SQLException;
@Data
public class DBCPDataSource {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/certificate_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(30);

    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
