package ru.clevertec.ecl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.entities.Tag;

import java.time.LocalDate;

public class TestSpring {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("OK");
            session.beginTransaction();
            var tag = new Tag();
            tag.setName("Dodo");
            GiftCertificate giftCertificate = new GiftCertificate();
            giftCertificate.setName("Sertificate 123");
            giftCertificate.setDuration(100);
            giftCertificate.setCreateDate(LocalDate.now());
            giftCertificate.setDescription("sdifuhvidshfv");
            giftCertificate.setPrice(200);
            giftCertificate.setLastUpdateDate(LocalDate.now());
            giftCertificate.addTag(tag);
            session.save(giftCertificate);
            var tag1 = new Tag();
            tag1.setName("AVG");
            tag1.addCertificate(giftCertificate);
            session.save(tag1);
            session.getTransaction().commit();

        }
    }

}
