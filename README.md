# DataAbstractionAssignment
##### *~ for Computer Programming 11 online course ~*

---

### Requirements:

> In this assignment you are to create a Customer class for a bank alongside a Deposit class and a Withdraw class.
> 
> All of the methods you need to complete are already in the project.  The project is in our github folder called DataAbstractionAssignment.
> 
> You will need to fill out all the methods that have //code here
> 
> You will need to create tests on the following methods and add on the Specification comments.
> 
> Deposit.toString()
> 
> Withdraw.toString()
> 
> Customer.deposit()
> 
> Customer.withdraw()
> 
> A few new things:
> 
> The date object is a class that can easily insert today's date as its default constructor.  Look up the class from java to learn how to use the constructor to create any date.
> 
> public static final String CHECKING/SAVING
> 
> final means that this value cannot be changed.  Static means it is accessible from outside class.  These two values should be always be used when the methods, deposit and withdraw, are invoked.  They belong in the "String account" parameter.  This is a common way you can ensure the user uses the correct String.
> 
> Class Requirements:
> 
> The class should be able using the deposit method deposit amounts into checking or saving balance depending if user chose checking or saving account.
> 
> It should create a new deposit object and add it to the list of deposits.  The display deposits should have the following out put for each deposit:
> 
> Deposit:
> 
> Deposit of: $400.0 Date: Sun Nov 04 00:00:00 PDT 2018 into account: Checking
> Deposit of: $500.0 Date: Thu Aug 16 10:52:17 PDT 2018 into account: Saving
> 
> Withdraw method and display should work the same.
> 
> Do not forget to check overdraft for withdraw method.

---

*This project is licensed under the MIT license. For more information, please see [LICENSE](./LICENSE).*


