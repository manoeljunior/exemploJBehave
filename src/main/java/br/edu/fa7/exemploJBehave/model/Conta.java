package br.edu.fa7.exemploJBehave.model;

public class Conta {

	private double saldo;
	
	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public void saque(double valor) {
		saldo -= valor;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
}
