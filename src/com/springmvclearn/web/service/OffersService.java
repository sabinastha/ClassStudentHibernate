package com.springmvclearn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvclearn.web.dao.Offer;
import com.springmvclearn.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDao;

	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}
	
	
//	public List<Offer> getCurrent(){
//		return offersDao.getOffers();
//	}
	
	public boolean create(Offer offer){
	return	offersDao.create(offer);
	}
	
	public void save(Offer offer) {
		offersDao.save(offer);
	}
	
	public List<Offer> getAllOffer(){
		
		return offersDao.getAllOffer();
	}
	
	
	

}
