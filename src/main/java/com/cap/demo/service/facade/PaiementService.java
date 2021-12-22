package com.cap.demo.service.facade;

import java.util.List;

import com.cap.demo.bean.Commande;
import com.cap.demo.bean.Paiement;

public interface PaiementService {

	Paiement findByRef(String ref);
	
	int deleteByRef(String ref);
	
	int save(Paiement paiement);
	
	List<Commande> findByCommandeRef(String ref);
}
