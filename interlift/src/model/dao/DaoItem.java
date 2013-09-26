package model.dao;

import java.util.List;

import model.database.Item;

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
public class DaoItem {

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
	public Boolean save(Item item) {
		Session session = getCurrentSession();
		try {
			session.save(item);
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
	public Boolean update(Item item) {
		Session session = getCurrentSession();
		try {
			session.merge(item);
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
	public Boolean delete(Item item) {
		Session session = getCurrentSession();
		try {
			session.delete(item);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Item findByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Item.class);
		criteria.add(Restrictions.eq(field, value));
		Object bp = criteria.uniqueResult();
		return bp != null ? (Item) bp : null;
	}

	@SuppressWarnings("unchecked")
	public List<Item> listByString(String field, String value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Item.class);
		criteria.add(Restrictions.eq(field, value).ignoreCase());
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<String> listStringByFields(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Item.class);
		criteria.setProjection(Projections.distinct(Projections.property(field)));
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}
}