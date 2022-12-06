port java.util.Scanner;
import java.io.*;
public class ATMinterface {
	String name ;
	String userName;
	String password;
	String accountNumber;
	double Balance=3000.00;
	int transaction =0;
	String transactionHistory=" ";
	//user Register
	public void register() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your name: ");
		this.name=sc.nextLine();
		System.out.println("Enter username: ");
		this.userName=sc.nextLine();
		System.out.println("Password: ");
		this.password=sc.nextLine();
		System.out.println("Enter yuor account Number: ");
		this.accountNumber=sc.nextLine();
		System.out.println("Registrarion completed successfully! Kindly login to your Account. ");
	}
	//user login
	public boolean login() {
		boolean isLogin =false;
		while(!isLogin) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter username: ");
			String username=sc.nextLine();
			if(userName.equals(username))
			{
				while(!isLogin)
				{
					System.out.println("Password: ");
					String Password=sc.nextLine();
					if(Password.equals(password))
					{
						System.out.println("login successfull ");
						isLogin= true;
						
					}else {
						System.out.println("Incorrect password ");
					}
				}
				
			}else {
				System.out.println("Username Not found");
			}
			
		}
		return isLogin;
	}
	//withdraw money
	public void withdraw()
	{
		System.out.println("\nEnter the amount to be withdrawn : ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        try
        {
            if(Balance >= amount)
            {
                Balance -= amount;
                System.out.println("\nWithdrawal successful!");
                String str ="Rs "+ amount + " Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else
                System.out.println("\nInsufficient Balance.");
        }
        catch(Exception e){}
    }

    // Deposit

    public void deposit()
    {
        System.out.println("\nEnter amount to deposit : ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        try
        {
            if(amount <= 100000.00)
            {
                transaction++;
                Balance += amount;
                System.out.println("\nDeposit successful!");
                String str = "Rs "+amount+" deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else
                System.out.println("\nLimit Exceeded!");
        }
        catch(Exception e){}
    }

    // Transfer

    public void transfer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter recepient name : ");
        String recepient = sc.nextLine();
        System.out.println("\nEnter amount to be transferred : ");
        double amount = sc.nextDouble();
        try
        {
            if(Balance >= amount)
            {
                if(amount <= 30000.00)
                {
                    transaction++;
                    Balance -= amount;
                    System.out.println("\nSuccessfully transferred to "+recepient);
                    String str = "Rs "+amount+" transferred to "+recepient+"\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else
                    System.out.println("\nSorry! Limit is ₹30000.00");
            }
            else
                System.out.println("\nInsufficient Balance.");
        }
        catch(Exception e){}
    }

    // Check balance

    public void checkBalance()
    {
        System.out.println("\nRs "+Balance);
    }

    // transaction history

    public void transHistory()
    {
        if(transaction == 0)
            System.out.println("\nEmpty!");
        else
            System.out.println("\n"+transactionHistory);
    }
}

// Interface of ATM

class ATM_Interface
{
    public static int takeInput(int lmt)
    {
        int input = 0;
        boolean flag = false;
        while(!flag)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if(flag && input > lmt || input < 1)
                {
                    System.out.println("Select the number between 1 to "+lmt);
                    flag = false;
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter integer value only");
                flag = false;
            }
        };
        return input;
    }

    // main method

    public static void main(String[] args) {
        System.out.println("\n   WELCOME TO Buldhana ATM   \n");
        System.out.println("1.Register\n2.Exit");
        System.out.print("Enter your choice : ");
        int choice = takeInput(2);
        if(choice == 1)
        {
        	ATMinterface  b = new ATMinterface  ();
            b.register();
            while(true)
            {
                System.out.println("\n1.Login\n2.Exit");
                System.out.print("Enter your choice : ");
                int ch = takeInput(2);
                if(ch == 1)
                {
                    if(b.login())
                    {
                        System.out.println("\n\nWELCOME BACK! "+b.name+"\n\n");
                        boolean isFinished = false;
                        while(!isFinished)
                        {
                            System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Check Balance");
                            System.out.print("Enter your choice : ");
                            int c = takeInput(6);
                            switch(c)
                            {
                            case 1:
                                b.deposit();
                                break;
                            case 2:
                                b.withdraw();
                                break;
                            case 3:
                                b.transfer();
                                break;
                            case 4:
                                b.transHistory();
                                break;
                            case 5:
                                b.checkBalance();
                                break;
                            case 6:
                                isFinished = true;
                                break;
                            default:
                                System.out.println("\nWrong Choice!");
                            }
                        }
                    }
                }
                else
                    System.exit(0);
            }
        }
        else
            System.exit(0);
    }
}
		
	
	
	
		
		
	

	


