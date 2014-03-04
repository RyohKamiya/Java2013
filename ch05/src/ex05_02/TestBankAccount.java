package ex05_02;

import org.junit.Test;

public class TestBankAccount {

	@Test
	public void testMain(){
		BankAccount ba = new BankAccount();
		ba.deposit(1);
	}
}
