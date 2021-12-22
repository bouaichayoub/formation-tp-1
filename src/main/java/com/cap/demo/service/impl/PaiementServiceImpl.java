package com.cap.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.demo.bean.Commande;
import com.cap.demo.bean.Paiement;
import com.cap.demo.dao.PaiementDao;
import com.cap.demo.service.facade.PaiementService;

@Service
public class PaiementServiceImpl implements PaiementService{

	@Autowired
	private PaiementDao paiementDao;
	@Override
	public Paiement findByRef(String ref) {
		return paiementDao.findByRef(ref);
	}

	@Override
	@Transactional
	public int deleteByRef(String ref) {
		return paiementDao.deleteByRef(ref);
	}

	@Override
	public int save(Paiement paiement) {
		if(findByRef(paiement.getRef()) != null) {
			return -1;
		}else {
			paiementDao.save(paiement);
			return 1;
		}
	}

	@Override
	public List<Commande> findByCommandeRef(String ref) {
		return paiementDao.findByCommandeRef(ref);
	}

}
