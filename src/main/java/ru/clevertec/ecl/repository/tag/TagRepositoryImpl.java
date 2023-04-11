package ru.clevertec.ecl.repository.tag;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.tag.UpdateTagRequest;
import ru.clevertec.ecl.utils.hibernate.HibernateUtil;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepository {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Tag> getTags() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Tag> tagList = session.createQuery("from Tag ").list();
        transaction.commit();
        session.close();
        return tagList;
    }

    @Override
    public Tag getTagById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Tag tag = session.get(Tag.class, id);
        transaction.commit();
        session.close();
        return tag;
    }

    @Override
    public Long update(Long id, UpdateTagRequest request) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Tag loadTag = session.load(Tag.class, id);
        loadTag.setName(request.getName());
        loadTag.setCertificateList(request.getCertificateList());
        session.saveOrUpdate(loadTag);
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public Long delete(Long id) {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Tag loadTag = session.load(Tag.class, id);
        if (Objects.nonNull(loadTag)) {
            session.delete(loadTag);
        }
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public Tag create(Tag tag) {

        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(tag);
        transaction.commit();
        session.close();
        return tag;
    }
}
