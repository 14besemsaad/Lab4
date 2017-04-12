import java.util.Scanner;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		
		JDBC j=new JDBC();
		Scanner scanner = new Scanner(System.in);
		int choice;
		int choice2;
		
		ExtraLargeTable e= new ExtraLargeTable();
		LargeTable l= new LargeTable();
		MediumTable m= new MediumTable();
		SmallTable s= new SmallTable();
		
		
		System.out.println("1- Customer");
		System.out.println("2- Admin");		choice=scanner.nextInt();
		
		while(true)
		{
			switch(choice)
			{
			case 1:
				scanner.nextLine();
				System.out.println("1- Make a reservation");
				System.out.println("2- Sign Up");
				choice2=scanner.nextInt();
				switch(choice2)
				{
				case 1:
					int people;
					String name;
					int time;
					boolean av=false;
					scanner.nextLine();
					String u;
					String p;
					System.out.println("Give username");
					u=scanner.next();
					System.out.println("Give password");
					p=scanner.next();
					if(j.checkCustomer(u, p))
					{
						System.out.println("Authentication Succesful");
					}
					else
					{
						System.out.println("Authentication Failed");
						break;
					}
					
					System.out.println("For how many people do you want to make the reservation?");
					people=scanner.nextInt();
					
					System.out.println("For what time do you want make the reservation?");
					time=scanner.nextInt();
					
					if(people<=2)
						av=s.checkAvailability(time);
					else if(people<=4)
						av=m.checkAvailability(time);
					else if(people<=6)
						av=l.checkAvailability(time);
					else if(people<=12)
					{
						
						av=e.checkAvailability(time);
						
					}
					if(av==false)
					{
						System.out.println("Sorry all the tables are occupied. Try another time.");
						break;
					}
					scanner.nextLine();
					System.out.println("By which name do you want to make the reservation?");
					name=scanner.next();
					if(people<=2)
						s.addReservation(name, time, people);
					else if(people<=4)
						m.addReservation(name, time, people);
					else if(people<=6)
						l.addReservation(name, time, people);
					else if(people<=12)
						e.addReservation(name, time, people);
					System.out.println("Cogratulations your reservation has been made for "+time+"00 hours today.");
					
					break;
				case 2:
					String n,username,password;
					System.out.println("Give your first name:");
					n=scanner.next();
					System.out.println("Enter your unique username:");
					username=scanner.next();
					System.out.println("Enter your password:");
					password=scanner.next();
					j.addcustomer(n,username,password)
					;
					break;

				}
				break;
				
			case 2:
				scanner.nextLine();
				String password="admin";
				int choice3;
				
				System.out.println("Enter the password");
				String npass=scanner.next();
				while(!scanner.next().equals(password))
				{
					System.out.println("Wrong password. Please try again.");
				}
				scanner.nextLine();
				System.out.println("Login Successful");
				System.out.println("1- View all reservations");
				choice3=scanner.nextInt();
				switch(choice3)
				{
					case 1:
						System.out.println("For Extra Large Table:");
						e.printReservation();
						System.out.println("For Large Table:");
						l.printReservation();
						System.out.println("For Medium Table:");
						m.printReservation();
						System.out.println("For Small Table:");
						s.printReservation();
						break;
					
				}
				
				break;
			}
			scanner.nextLine();
			System.out.println("1- Customer");
			System.out.println("2- Admin");
			choice=scanner.nextInt();
		
		
	}

}
}
