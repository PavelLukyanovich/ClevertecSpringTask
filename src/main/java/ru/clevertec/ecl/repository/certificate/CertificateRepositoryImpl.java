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

import java.util.List;
import java.util.Objects;


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
        List<GiftCertificate> giftCertificateList;
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
        if (Objects.nonNull(certificateParamDto.getSortDate())) {
            hqlQuery.append(" order by gc.createDate ").append(certificateParamDto.getSortDate().name());
        }
        if (Objects.nonNull(certificateParamDto.getSortName())) {
            String operation = Objects.nonNull(certificateParamDto.getSortDate()) ? (",") : (" order by");
            hqlQuery.append(operation).append(" gc.name ").append(certificateParamDto.getSortName().name());
        }

        String queryString = hqlQuery.toString();
        System.out.println(queryString);
        query = session.createQuery(queryString, GiftCertificate.class);

        if (StringUtils.isNotBlank(certificateParamDto.getTagName())) {

            query.setParameter("tagName", certificateParamDto.getTagName());
        }
        if (StringUtils.isNotBlank(certificateParamDto.getCertName())) {

            query.setParameter("certName", certificateParamDto.getCertName());
        }
        if (StringUtils.isNotBlank(certificateParamDto.getCertDescription())) {

            query.setParameter("certDescription", certificateParamDto.getCertDescription());
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

        GiftCertificate loadCertificate = session.load(GiftCertificate.class, id);
        if (Objects.nonNull(request.getName())) {
            loadCertificate.setName(request.getName());
        }
        if (Objects.nonNull(request.getDescription())) {
            loadCertificate.setDescription(request.getDescription());
        }
        if (Objects.nonNull(request.getPrice())) {
            loadCertificate.setPrice(request.getPrice());
        }
        if (Objects.nonNull(request.getDuration())) {
            loadCertificate.setDuration(request.getDuration());
        }
        if (Objects.nonNull(request.getCreateDate())) {
            loadCertificate.setCreateDate(request.getCreateDate());
        }
        if (Objects.nonNull(request.getLastUpdateDate())) {
            loadCertificate.setLastUpdateDate(request.getLastUpdateDate());
        }
        if (Objects.nonNull(request.getTagList())) {
            loadCertificate.setTagList(request.getTagList());
        }

        session.saveOrUpdate(loadCertificate);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Long delete(Long id) {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        GiftCertificate loadCertificate = session.load(GiftCertificate.class, id);
        if (Objects.nonNull(loadCertificate)) {
            session.delete(loadCertificate);
        }
        transaction.commit();
        session.close();
        return id;
    }
}
