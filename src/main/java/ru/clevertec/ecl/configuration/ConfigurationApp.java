package ru.clevertec.ecl.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.ecl.utils.hibernate.HibernateUtil;

@Configuration
public class ConfigurationApp {

    @Bean
    public SessionFactory sessionFactory() {

        return HibernateUtil.getSessionFactory();

    }
}