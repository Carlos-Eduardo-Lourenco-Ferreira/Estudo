package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.model.Teste;
import com.example.demo.repository.TesteRepository;

@RestController
public class TesteController {
	
	@Autowired
	TesteRepository injecao;
	
	@CrossOrigin(origins="http://127.0.0.1:5500")
	@GetMapping("/teste")
	public List<Teste> get(){
		return injecao.findAll();
	}
	
	@CrossOrigin(origins="http://127.0.0.1:5500")
	@PostMapping("/teste")
	public boolean post(@RequestBody Teste t) {
		boolean result = t.verificaUsuario(t);
		if(result) {
			return true;
		}
		return false;
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@DeleteMapping("/teste/{cod}")
	public String delete(@PathVariable Long cod) {
		injecao.deleteById(cod);
		return "Excluiu";
	}
}
