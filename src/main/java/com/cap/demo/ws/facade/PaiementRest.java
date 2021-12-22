package com.cap.demo.ws.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.demo.bean.Commande;
import com.cap.demo.bean.Paiement;
import com.cap.demo.service.facade.PaiementService;

@RestController
@RequestMapping(value= "api/paiement")
public class PaiementRest {
	
	@Autowired
	private PaiementService paiementService; 
	@GetMapping("/commande/ref/{ref}")
	public List<Commande> findByCommandeRef(@PathVariable String ref) {
		return paiementService.findByCommandeRef(ref);
	}
	@GetMapping("/ref/{ref}")
	public Paiement findByRef(@PathVariable String ref) {
		return paiementService.findByRef(ref);
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return paiementService.deleteByRef(ref);
	}
	
	@PostMapping("/")
	public int save(@RequestBody Paiement paiement){
		return paiementService.save(paiement);
	}
}
