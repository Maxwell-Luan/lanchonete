package com.lanchonete.megalanches.entities;

import java.util.Objects;

public class Funcionario {

	private Long id;
	private String nome;
	private double saldo;
	
	public Funcionario() {
	}
	
	public Funcionario(Long id, String nome, double saldo) {
		super();
		this.id = id;
		this.nome = nome;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", saldo=" + saldo + "]";
	}
	
}
