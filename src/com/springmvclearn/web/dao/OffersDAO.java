package com.springmvclearn.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("offersDao")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {

		return jdbc.query("select * from offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));

				return offer;
			}

		});
	}

	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("update offers set name=:name, text=:text, email=:email where id=:id", params) == 1;
	}

	public boolean create(Offer offer) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("insert into offer (name, text, email) values (:name, :text, :email)", params) == 1;
	}

	public boolean createWithSession(Offer offer) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("insert into offer (name, text, email) values (:name, :text, :email)", params) == 1;
	}

	@Transactional
	public int[] create(List<Offer> offers) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());

		return jdbc.batchUpdate("insert into offer (id, name, text, email) values (:id, :name, :text, :email)", params);
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("delete from offers where id=:id", params) == 1;
	}

	public Offer getOffer(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers where id=:id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));

				return offer;
			}

		});
	}

	public List<Offer> getAllOffers() {
		return session().createQuery("from Offer").list();
	}

	public void creates(Offer offer) {

		session().save(offer);
		
	}

	//Display all the Customers
	//HQL
	public List<Offer> HibernateChecking() {
		String hql = "from Offer o";
		Query q = session().createQuery(hql);
		List<Offer> lists = q.list();
		return lists;
	}
	
	//QBC
	public List<Offer> QbcDisplay(){
		
		Criteria ct = session().createCriteria(Offer.class);
		List<Offer> list = ct.list();
		return list;
	}

	//With Condition
	//HQL
	public List<Offer> HibernateConditionDisplay(){
		
		String hql = "from Offer o where o.email=?";
		Query q = session().createQuery(hql);
		q = q.setString(0, "email");
		List<Offer> list = q.list();
		return list;
	}
	
	public List<Offer> QbcConditionDisplay(){
		
		Criteria ct = session().createCriteria(Offer.class);
		ct = ct.add(Expression.eq("email", "email"));
		List<Offer> list = ct.list();
		return list;
	}
	
	
	//With Multiple Condition
		//HQL
		public List<Offer> HibernateMConditionDisplay(){
			
			String hql = "from Offer o where o.email=? and name=?";
			Query q = session().createQuery(hql);
			q = q.setString(0, "email");
			q = q.setString(1, "sanjay");
			List<Offer> list = q.list();
			return list;
		}
		
		public List<Offer> QbcMConditionDisplay(){
			
			Criteria ct = session().createCriteria(Offer.class);
			ct = ct.add(Expression.and(Expression.eq("email", "email"), Expression.gt("name", "sanjay")));
			List<Offer> list = ct.list();
			return list;
		}
	
		
		
		//Saving in database using Hibernate 
		
		public void save(Offer offer) {
			
			Transaction trans = session().beginTransaction();
			session().save(offer);
			trans.commit();
		}
		
		public List<Offer> getAllOffer(){
			
			Transaction trans = session().beginTransaction();
			List<Offer> offers = session().createQuery("from Offer").list();
			trans.commit();
			return offers;
		}
		
		public void creates(StudentClass studentClass) {
			
			Transaction trans = session().beginTransaction();
			session().save(studentClass);
			trans.commit();
		}
		
		public void create(Student student) {
			
			Transaction trans = session().beginTransaction();
			session().save(student);
			trans.commit();
		}
}
