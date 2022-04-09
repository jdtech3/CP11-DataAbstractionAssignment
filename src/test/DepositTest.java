package test;

import main.Deposit;
import main.Customer;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DepositTest {
    Deposit testDepositSaving;
    Deposit testDepositChecking;

    @Before
    public void setup() {
        testDepositSaving = new Deposit(123.45, new Date(0), Customer.SAVING);
        testDepositChecking = new Deposit(987.65, new Date(0), Customer.CHECKING);
    }

    @Test
    public void testWithdrawToString() {
        String testDepositSavingStr = testDepositSaving.toString();
        assertEquals("Deposit of: $123.45 Date: Wed Dec 31 16:00:00 PST 1969 into account: Saving", testDepositSavingStr);

        String testDepositCheckingStr = testDepositChecking.toString();
        assertEquals("Deposit of: $987.65 Date: Wed Dec 31 16:00:00 PST 1969 into account: Checking", testDepositCheckingStr);
    }
}
