package com.cap.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.demo.bean.Client;
import com.cap.demo.bean.Commande;
import com.cap.demo.dao.CommandeDao;
import com.cap.demo.service.facade.ClientService;
import com.cap.demo.service.facade.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{

	@Autowired
	private CommandeDao commandeDao;
	
	@Autowired
	private ClientService clientService;
	
	@Override
	public Commande findByRef(String ref) {
		return commandeDao.findByRef(ref);
	}

	@Override
	@Transactional
	public int deleteByRef(String ref) {
		return commandeDao.deleteByRef(ref);
	}

	@Override
	public int save(Commande commande) {
		if(findByRef(commande.getRef()) != null) {
			return -1;
		}
		Client client = clientService.findById(commande.getClient().getId());
		if(client == null || client.getId() == null){
			client = clientService.findByRaisonSociale(commande.getClient().getRaisonSociale());
		}
		if(client == null || client.getId() == null){
			return -2;
		}else {
			commandeDao.save(commande);
			return 1;
		}
	}

}
