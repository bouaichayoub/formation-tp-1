package com.cap.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.demo.bean.Commande;
import com.cap.demo.bean.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long>{
	Paiement findByRef(String ref);
	
	int deleteByRef(String ref);
	
	List<Commande> findByCommandeRef(String ref);
}
