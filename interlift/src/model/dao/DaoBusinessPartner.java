package model.dao;

import java.util.List;

import model.database.BusinessPartner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoBusinessPartner {

	@Autowired
	private SessionFactory sessionFactory;

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param model
	 *                Object to save in database
	 * @return true if saved / false if not saved
	 */
	public Boolean save(BusinessPartner businessPartner) {
		Session session = getCurrentSession();
		try {
			session.save(businessPartner);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *                Object to update in database
	 * @return true if updated / false if not updated
	 */
	public Boolean update(BusinessPartner businessPartner) {
		Session session = getCurrentSession();
		try {
			session.merge(businessPartner);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *                Object to delete in database
	 * @return true if deleted / false if not deleted
	 */
	public Boolean delete(BusinessPartner businessPartner) {
		Session session = getCurrentSession();
		try {
			session.delete(businessPartner);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<BusinessPartner> listActiveOrderByField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BusinessPartner.class);
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	public BusinessPartner findByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BusinessPartner.class);
		criteria.add(Restrictions.eq(field, value));
		Object object = criteria.uniqueResult();
		return object != null ? (BusinessPartner) object : null;
	}

	public BusinessPartner findActiveByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BusinessPartner.class);
		criteria.add(Restrictions.eq(field, value));
		criteria.add(Restrictions.eq("status", 'A'));
		Object object = criteria.uniqueResult();
		return object != null ? (BusinessPartner) object : null;
	}

	@SuppressWarnings("unchecked")
	public List<String> listStringByFields(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BusinessPartner.class);
		criteria.setProjection(Projections.distinct(Projections.property(field)));
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}
}