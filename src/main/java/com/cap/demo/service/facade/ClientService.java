package com.cap.demo.service.facade;

import java.util.List;

import com.cap.demo.bean.Client;

public interface ClientService {
	
	Client findByRaisonSociale(String raisonSociale);
	
	List<Client> findByVille(String ville);
	
	List<Client> findAll();
	
	int save(Client client);
	
	Client findById(Long id);
}
