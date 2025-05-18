package com.gestaofacil.GestaoFacil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

	@GetMapping("/index")
	public String index () {
		return "index";
	}
	
	@GetMapping("/sobre")
	public String sobre () {
		return "sobre";
	}
	
	@GetMapping("/recursos")
	public String recursos () {
		return "recursos";
	}
	
	
}
