package br.edu.fa7.exemploJBehave.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import br.edu.fa7.exemploJBehave.model.Conta;

public class StepDef {

	private Conta conta;
	
	@Given("uma conta com saldo $saldo")
	public void givenUmaContaComSaldo(double saldo) {
		conta = new Conta(saldo);
	}

	@When("efetuar um saque de $valor")
	public void whenEfetuarUmSaque(double valor) {
		conta.saque(valor);
	}

	@Then("o saldo da conta será $saldo")
	public void thenOSaldoDaContaSera(double saldo) {
		Assert.assertEquals(saldo, conta.getSaldo(), 0.00001);
	}
}
