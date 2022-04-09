package test;

import main.Withdraw;
import main.Customer;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class WithdrawTest {
    Withdraw testWithdrawSaving;
    Withdraw testWithdrawChecking;

    @Before
    public void setup() {
        testWithdrawSaving = new Withdraw(123.45, new Date(0), Customer.SAVING);
        testWithdrawChecking = new Withdraw(987.65, new Date(0), Customer.CHECKING);
    }

    @Test
    public void testWithdrawToString() {
        String testWithdrawSavingStr = testWithdrawSaving.toString();
        assertEquals("Withdrawal of: $123.45 Date: Wed Dec 31 16:00:00 PST 1969 from account: Saving", testWithdrawSavingStr);

        String testWithdrawCheckingStr = testWithdrawChecking.toString();
        assertEquals("Withdrawal of: $987.65 Date: Wed Dec 31 16:00:00 PST 1969 from account: Checking", testWithdrawCheckingStr);
    }
}
