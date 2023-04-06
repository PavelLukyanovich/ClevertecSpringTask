package ru.clevertec.ecl.repository.certificate;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CertificateRepositoryImpl implements CertificateRepository {

    private final SessionFactory sessionFactory;


    @Override
    public List<GiftCertificate> getCertificates() {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query<GiftCertificate> query = session.createQuery("from GiftCertificate c left join Tag t where c.name= :name " +
                "or c.description= :description or t.name= :tName", GiftCertificate.class);
        query.setProperties(GiftCertificate.class);
        List<GiftCertificate> giftCertificateList = query.list();
        transaction.commit();
        session.close();
        return giftCertificateList;
    }

    @Override
    public GiftCertificate getCertificateById(Long id) {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        GiftCertificate giftCertificate = session.get(GiftCertificate.class, id);
        transaction.commit();
        session.close();
        return giftCertificate;
    }

    @Override
    public GiftCertificate create(GiftCertificate giftCertificate) {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(giftCertificate);
        transaction.commit();
        session.close();
        return giftCertificate;
    }

    @Override
    public boolean update(Long id, UpdateCertificateRequest request) {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        GiftCertificate giftCertificate = session.get(GiftCertificate.class, id);
        session.update(giftCertificate);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Long id) {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from GiftCertificate c where c.id=(?1)");
        query.setParameter(1, id);
        query.executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }
}
