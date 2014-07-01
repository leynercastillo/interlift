package model.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import model.database.Quotation;

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
public class DaoQuotation /* extends GenericDao<Quotation> */{

	private Properties properties;

	@Autowired
	private SessionFactory sessionFactory;

	public DaoQuotation() {
		properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("/configuration/numeration.properties"));
		} catch (IOException e) {
			System.out.println("The properties wasn't loaded.");
		}
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param quotation
	 *                Object to save in database.
	 * @param update
	 *                Boolean for generate version number of quotation (Only change the price, not more).
	 * @return true if saved / false if not saved
	 */
	public Boolean save(Quotation quotation) {
		Session session = getCurrentSession();
		quotation.setDate(new Date());
		try {
			List<Quotation> list = listByInt("budgetNumber", quotation.getBudgetNumber());
			if (list.size() > 0) {
				getCurrentSession().evict(quotation);
				quotation.setIdQuotation(0);
				quotation.setVersionNumber((short) (getVersionQuotation(list.get(0)) + 1));
			} else if (quotation.isType()) {
				Integer number = getMaxNumber("newNumber");
				quotation.setNewNumber(number == null ? 0 : number + 1);
				quotation.setModernizationNumber(-1);
			} else {
				Integer number = getMaxNumber("modernizationNumber");
				quotation.setModernizationNumber(number == null ? 0 : number + 1);
				quotation.setNewNumber(-1);
			}
			session.save(quotation);
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
	public Boolean update(Quotation quotation) {
		Session session = getCurrentSession();
		try {
			session.merge(quotation);
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
	public Boolean delete(Quotation quotation) {
		Session session = getCurrentSession();
		try {
			session.delete(quotation);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Quotation findByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		criteria.add(Restrictions.eq(field, value));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (Quotation) obj;
	}

	@SuppressWarnings("unchecked")
	public List<Quotation> listByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		criteria.add(Restrictions.eq(field, value));
		criteria.addOrder(Order.desc("date"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Quotation> listByInt(String field, int value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		criteria.add(Restrictions.eq(field, value));
		criteria.addOrder(Order.desc("date"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Quotation> listQuotationOrderByField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		criteria.addOrder(Order.asc(field).ignoreCase());
		criteria.addOrder(Order.desc("date"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<String> listStringByFields(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		criteria.setProjection(Projections.distinct(Projections.property(field)));
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	/**
	 * @param field
	 *                The Field that is looking for max value.
	 * @return The integer max value in this field db.
	 */
	public Integer getMaxNumber(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		criteria.setProjection(Projections.max(field));
		Integer number = (Integer) criteria.uniqueResult();
		if (number == null || number == -1) {
			if (field.compareTo("newNumber") == 0)
				number = Integer.valueOf(properties.getProperty("quotation_new_number"));
			else
				number = Integer.valueOf(properties.getProperty("quotation_modernization_number"));
		}
		return number;
	}

	public Short getVersionQuotation(Quotation quotation) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		if (quotation.isType())
			criteria.add(Restrictions.eq("newNumber", quotation.getNewNumber()));
		else
			criteria.add(Restrictions.eq("modernizationNumber", quotation.getModernizationNumber()));
		criteria.setProjection(Projections.max("versionNumber"));
		Short version = (Short) criteria.uniqueResult();
		return version == null ? null : version;
	}

	/**
	 * @param field
	 *                field for which it ordered the list.
	 * @return list of Quotation approved ordered by field.
	 */
	@SuppressWarnings("unchecked")
	public List<Quotation> listActiveOrderAscByField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	/**
	 * @param field
	 *                field for which it ordered the list.
	 * @return list of Quotation approved ordered by field.
	 */
	@SuppressWarnings("unchecked")
	public List<Quotation> listActiveOrderDescByField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Quotation.class);
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.addOrder(Order.desc(field));
		return criteria.list();
	}
}