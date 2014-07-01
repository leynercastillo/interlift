package model.dao;

import java.util.List;

import model.database.BasicData;

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
public class DaoBasicdata {

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
	public Boolean save(BasicData basicData) {
		Session session = getCurrentSession();
		try {
			session.save(basicData);
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
	public Boolean update(BasicData basicData) {
		Session session = getCurrentSession();
		try {
			session.merge(basicData);
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
	public Boolean delete(BasicData basicData) {
		Session session = getCurrentSession();
		try {
			session.delete(basicData);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public BasicData findByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BasicData.class);
		criteria.add(Restrictions.eq(field, value));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (BasicData) obj;
	}

	public BasicData findByName(String table, String field, String name) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BasicData.class);
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.add(Restrictions.eq("editable", false));
		criteria.add(Restrictions.eq("field", field).ignoreCase());
		criteria.add(Restrictions.eq("name", name).ignoreCase());
		criteria.add(Restrictions.eq("dataBaseName", table));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (BasicData) obj;
	}

	@SuppressWarnings("unchecked")
	public List<BasicData> listByFieldTable(String table, String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BasicData.class);
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.add(Restrictions.eq("field", field).ignoreCase());
		criteria.add(Restrictions.eq("dataBaseName", table));
		criteria.addOrder(Order.asc("priority"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<BasicData> listByParent(BasicData parent) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BasicData.class);
		criteria.add(Restrictions.eq("basicData", parent));
		criteria.addOrder(Order.asc("priority"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<String> listFieldByDataBase(String field, String database) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BasicData.class);
		criteria.setProjection(Projections.distinct(Projections.property(field)));
		criteria.add(Restrictions.eq(database, field));
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<BasicData> listByFieldValue(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BasicData.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
	
	public BasicData findByFieldTable(String table, String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(BasicData.class);
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.add(Restrictions.eq("field", field).ignoreCase());
		criteria.add(Restrictions.eq("dataBaseName", table));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (BasicData) obj;
	}
	
	
}