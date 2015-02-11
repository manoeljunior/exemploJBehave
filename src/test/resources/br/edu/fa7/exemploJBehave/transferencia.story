Operações Financeiras

Scenario: Efetuar o saque em uma conta
Given uma conta com saldo 1000
When efetuar um saque de 100
Then o saldo da conta será 900
		