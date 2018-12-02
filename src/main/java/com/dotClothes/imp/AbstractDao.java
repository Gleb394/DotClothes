package com.dotClothes.imp;

import com.dotClothes.model.Model;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional
public abstract class AbstractDao<T extends Model> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<?> clazz;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        final ParameterizedType supperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<?>) supperClass.getActualTypeArguments()[0];
    }

    public void add(T model) {
        try {
            sessionFactory.getCurrentSession().beginTransaction();
            sessionFactory.getCurrentSession().save(model);
            sessionFactory.getCurrentSession().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
        } finally {
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().close();
        }
    }

    public void update(T model) {
        try {
            sessionFactory.getCurrentSession().beginTransaction();
            sessionFactory.getCurrentSession().merge(model);
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            sessionFactory.getCurrentSession().getTransaction().rollback();
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public T get(long id) {
            Criteria getEntity = sessionFactory.getCurrentSession().getSessionFactory().openSession().createCriteria(clazz);
            getEntity.add(Restrictions.eq("id", id));
            return (T) getEntity.uniqueResult();
    }

    public void remove(T model) {
        try {
            sessionFactory.getCurrentSession().beginTransaction();
            sessionFactory.getCurrentSession().delete(model);
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            sessionFactory.getCurrentSession().getTransaction().rollback();
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
            Criteria getAllEntity = sessionFactory.getCurrentSession().getSessionFactory().openSession().createCriteria(clazz);
            getAllEntity.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return getAllEntity.list();
    }
}
