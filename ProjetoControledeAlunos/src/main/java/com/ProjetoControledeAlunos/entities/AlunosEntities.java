package com.ProjetoControledeAlunos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class AlunosEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;

	
	@Column
	private String nome;
	

	@Column
	private String cpf;
	
	
	@Column
	private String rg;
	
	
	@Column
	private String endereco;


	public Long getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}