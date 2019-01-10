package bankaccount.demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp(){
        account = new BankAccount();
        account.setPin(1234);
    }

    @Test
    public void pin(){
        assertEquals(1234, account.getPin());
    }

    @Test
    public void naming(){
        account.setName("Ajay");
        assertEquals("Ajay", account.getName());
    }

    @Test
    public void accountNum(){
        account.setAccountNumber(987654);
        assertEquals(987654, account.getAccountNumber(), 0);
    }

    @Test
    public void sortCode(){
        account.setSortCode(232323);
        assertEquals(232323, account.getSortCode(), 0);
    }

    @Test
    public void increaseBalance(){
        account.deposit(1234, 200.34);
        assertEquals(200.34, account.displayBalance(1234), 0.0);
    }

    @Test
    public void decreaseBalance(){
        account.deposit(1234, 200.34);
        account.withdraw(1234, 10.30);
        assertEquals(190.04, account.displayBalance(1234), 0.0);
    }

}