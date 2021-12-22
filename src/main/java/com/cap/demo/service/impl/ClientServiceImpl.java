package com.cap.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.demo.bean.Client;
import com.cap.demo.dao.ClientDao;
import com.cap.demo.service.facade.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public Client findByRaisonSociale(String raisonSociale) {
		return clientDao.findByRaisonSociale(raisonSociale);
	}

	@Override
	public List<Client> findByVille(String ville) {
		return clientDao.findByVille(ville);
	}

	@Override
	public int save(Client client) {
		if(findByRaisonSociale(client.getRaisonSociale()) != null) {
			return -1;
		}else {
			clientDao.save(client);
			return 1;
		}
	}

	@Override
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Override
	public Client findById(Long id) {
		return clientDao.getById(id);
	}

}
