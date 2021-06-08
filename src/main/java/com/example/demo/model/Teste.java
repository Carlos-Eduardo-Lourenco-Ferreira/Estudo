package com.example.demo.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_teste")
public class Teste implements Serializable{

	private static final long serialVersionUID = 1990748667310793230L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username, senha;
	
	// CONSTRUCTORS
	public Teste() {
		
	}
	
	public Teste(String username, String senha) {
		this.setUsername(username);
		this.setSenha(senha);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean verificaUsuario(Teste usuario) {
		if((usuario.getUsername() == this.getUsername()) && (usuario.getSenha() == this.getSenha())) {
			return true;
		}
		return false;
	}
	
}
