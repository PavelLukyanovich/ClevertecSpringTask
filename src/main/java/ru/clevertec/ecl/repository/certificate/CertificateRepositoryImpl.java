package ru.clevertec.ecl.repository.certificate;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;
import ru.clevertec.ecl.model.requests.certificate.UpdateCertificateRequest;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class CertificateRepositoryImpl implements CertificateRepository {

    private final SessionFactory sessionFactory;


    @Override
    public List<GiftCertificate> getCertificates(CertificateParamDto certificateParamDto) {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        StringBuilder hqlQuery = new StringBuilder("select gc from GiftCertificate gc");
        Query<GiftCertificate> query;
        List<GiftCertificate> giftCertificateList = new ArrayList<>();
        if (StringUtils.isNotBlank(certificateParamDto.getTagName())) {

            hqlQuery.append(" join gc.tagList t where t.name = :tagName");
        }
        if (StringUtils.isNotBlank(certificateParamDto.getCertName())) {
            if (StringUtils.isNotBlank(certificateParamDto.getTagName())) {
                hqlQuery.append(" and gc.name = :certName");
            } else {
                hqlQuery.append(" where gc.name = :certName");
            }
        }
        if (StringUtils.isNotBlank(certificateParamDto.getCertDescription())) {
            if (StringUtils.isNotBlank(certificateParamDto.getTagName()) || StringUtils.isNotBlank(certificateParamDto.getCertName())) {
                hqlQuery.append(" and gc.description = :certDescription");
            } else {
                hqlQuery.append(" where gc.description = :certDescription");
            }
        }
        if (StringUtils.isNotBlank(certificateParamDto.getSortDate())) {
            hqlQuery.append(" order by gc.createDate sortDate");
        }
        if (StringUtils.isNotBlank(certificateParamDto.getSortName())) {
            hqlQuery.append(" order by gc.name sortName");
        }
        query = session.createQuery(hqlQuery.toString(), GiftCertificate.class);
        if (StringUtils.isNotBlank(certificateParamDto.getTagName())) {

            query.setParameter("tagName", certificateParamDto.getTagName());
        }
        if (StringUtils.isNotBlank(certificateParamDto.getCertName())) {

            query.setParameter("certName", certificateParamDto.getCertName());
        }
        if (StringUtils.isNotBlank(certificateParamDto.getCertDescription())) {

            query.setParameter("certDescription", certificateParamDto.getCertDescription());
        }
        if (StringUtils.isNotBlank(certificateParamDto.getSortDate())) {

            query.setParameter("sortDate", certificateParamDto.getSortDate());
        }
        if (StringUtils.isNotBlank(certificateParamDto.getSortName())) {

            query.setParameter("sortName", certificateParamDto.getSortName());
        }

        giftCertificateList = query.list();

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
