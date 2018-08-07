package com.DotClothes.imp;

import com.DotClothes.connection.Connection;
import com.DotClothes.model.Model;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T extends Model> {

    private Session session = Connection.getSession();
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        final ParameterizedType supperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) ((ParameterizedType) supperClass).getActualTypeArguments()[0];
    }

    public void add(T model) {
        try {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void update(T model) {
        try {
            session.beginTransaction();
            session.merge(model);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public T get(long id) {
            Criteria getEntity = session.getSessionFactory().openSession().createCriteria(this.clazz);
            getEntity.add(Restrictions.eq("id", id));
            return (T) getEntity.uniqueResult();
    }

    public void remove(T model) {
        try {
            session.beginTransaction();
            session.delete(model);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
            Criteria getAllEntity = session.getSessionFactory().openSession().createCriteria(this.clazz);
            getAllEntity.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return getAllEntity.list();
    }
}
