package test;

import main.Customer;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class CustomerTest {
    Customer testCustomer;

    @Before
    public void setup() {
        testCustomer = new Customer("test", 1, 0, 0);
    }

    // For following tests, both accounts are checked to ensure that amount is deposited/withdrawn from the correct account.

    @Test
    public void testCustomerNewDeposit() {
        testCustomer.deposit(123.45, new Date(), Customer.CHECKING);
        assertEquals(123.45, testCustomer.getBalance(Customer.CHECKING), 0.01);
        assertEquals(0.0, testCustomer.getBalance(Customer.SAVING), 0.01);

        testCustomer.deposit(123.45, new Date(), Customer.SAVING);
        assertEquals(123.45, testCustomer.getBalance(Customer.CHECKING), 0.01);
        assertEquals(123.45, testCustomer.getBalance(Customer.SAVING), 0.01);
    }

    @Test
    public void testCustomerNewWithdraw() {
        testCustomer.withdraw(12.34, new Date(), Customer.CHECKING);
        assertEquals(-12.34, testCustomer.getBalance(Customer.CHECKING), 0.01);
        assertEquals(0.0, testCustomer.getBalance(Customer.SAVING), 0.01);

        testCustomer.withdraw(12.34, new Date(), Customer.SAVING);
        assertEquals(-12.34, testCustomer.getBalance(Customer.CHECKING), 0.01);
        assertEquals(-12.34, testCustomer.getBalance(Customer.SAVING), 0.01);
    }
}
