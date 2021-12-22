package com.cap.demo.service.facade;

import com.cap.demo.bean.Commande;

public interface CommandeService {

	Commande findByRef(String ref);
	
	int deleteByRef(String ref);
	
	int save(Commande commande);
}
