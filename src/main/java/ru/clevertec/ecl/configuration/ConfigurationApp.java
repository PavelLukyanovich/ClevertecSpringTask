package ru.clevertec.ecl.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.clevertec.ecl.utils.hibernate.HibernateUtil;

@Configuration
@ComponentScan("ru.clevertec.ecl")
@EnableWebMvc
public class ConfigurationApp {

    @Bean
    public SessionFactory sessionFactory() {

        return HibernateUtil.getSessionFactory();

    }

}
