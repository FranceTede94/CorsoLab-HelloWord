package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
//localhost:8080/Calcolanumero?numero1=123&numero2=200
public class ControlloNumero {
	
	@GetMapping("/Calcolanumero")
	public String getPage(Model model,
			@RequestParam(name = "numero1", required = false, defaultValue = "0") int primonumero,
			@RequestParam(name = "numero2", required = false, defaultValue = "0") int secondonumero
	
			
			) {//al metodo gli passo un istanza del modello
		model.addAttribute("title","Inserisci un numero e vedi quale sia più grande");//aggiungo un parametro al modell
		model.addAttribute("numero1",primonumero);
		model.addAttribute("numero2",secondonumero);
		
		int numeromaggiore;
		
		if (primonumero > secondonumero) {
			numeromaggiore = primonumero;
		}
		else {
			numeromaggiore = secondonumero;
		}
		
		model.addAttribute("maggiore", numeromaggiore);
		return "index";
	}
	
}
