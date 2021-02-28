import java.util.Scanner;
public class Pizza
{
	static String state,city,mark,build,loc;
	static int pin,room,mob;
	public static void main(String[] args)
	{
			int x,y,z=0,cost=0,m=0;
			double total_gst,gst;
			String name;
			Scanner sc=new Scanner(System.in);
			
			System.out.println("\t\t\t\t*****PIZZA CORNER*****\t\t\t\t");
	//Enter name 
			System.out.println("Enter the Name:");
			name=sc.nextLine();
			
	//Password
			System.out.println("Enter the 5 digit number of login id :");
			y=sc.nextInt();
		
			int n1=y;
			while(n1!=0)
			{
				n1=n1/10;
				z++;
			}
			if(z!=5)		
			{
				System.out.println("Login id is Incorrect");
				
				System.out.println("\t\t\t\t!!!THANK YOU!!!\t\t\t\t");
			}
			
			
			else
			{
			System.out.println("Login id is Correct\n");
		
	//Menu Card
			do
			{		
				System.out.println("\n\t****Menu card of Pizza corner****");
				System.out.println("\t| 1.Pizza \t 2.Meal     | \n\t| 3.Drink \t 4.Pasta    |\n\t| 5.Sides \t 6.Desserts |\n\t| 7.Magic pan \t 8.Offer    |");
				System.out.println("\t Press 9 for checkout");
				System.out.print("\n\t Please enter your choice : ");
				x=sc.nextInt();
			
			switch(x)
			{
				case 1:
						System.out.println("\n\t|  ****  Pizzas  ****    | Rs. |");
						System.out.println("\t| 1.Veggie Supreme       | 490 |");
						System.out.println("\t| 2.Exotica              | 490 |");
						System.out.println("\t| 3.Paneer Vegorama      | 490 |");
						System.out.println("\t| 4.Chicken Supreme      | 570 |");
						System.out.println("\t| 5.Triple Chicken Feast | 570 |");
						System.out.println("\t| 6.Chicken Italiano     | 570 |");
						System.out.println("\t| 7.Ultimate Chicken     | 570 |");
						System.out.println("\t| 8.Tandoori Paneer      | 460 |");
						
						System.out.println("\tChoose the option for pizza: ");
						int pizza=sc.nextInt();
						
						switch(pizza)
						{
							case 1:
							case 2:
							case 3:cost=cost+490;
									break;
									
							case 4:
							case 5:
							case 6:
							case 7:cost=cost+570;
									break;
								   
							case 8:cost=cost+460;
									break;
							default:
									System.out.println("\tInvalid choice for pizza");
									break;
								
						}
						break;
						
						
				case 2:	
						System.out.println("\n\t|       ****  MEAL  ****       | Rs. |");
						System.out.println("\t| 1.Triple Treat Box Veg       | 410 |");
						System.out.println("\t| 2.Triple Treat Box Non-veg   | 400 |");
						System.out.println("\t| 3.Family Fun Meal For 2      | 390 |");
						System.out.println("\t| 4.Magic Pan Box of 4 Veg     | 350 |");
						System.out.println("\t| 5.Magic pan Box of 4 Non-veg | 400 |");
						
						System.out.println("\tChoose the option for Meal:");
						int meal=sc.nextInt();
						
						switch(meal)
						{
							case 1:cost=cost+410;
								break;
							
							case 2:cost=cost+400;
								break;
							
							case 3:cost=cost+390;
								break;
							
							case 4:cost=cost+350;
								break;
							
							case 5:cost=cost+400;
								break;
							
							default:System.out.println("\tInvalid choice for Meal");
								break;
							
						}
						break;
						
				
				case 3:
						System.out.println("\n\t| ** DRINK ** | Rs. |");
						System.out.println("\t| 1.Red Bull  | 126 |");
						System.out.println("\t| 2.Frooti    |  61 |");
						System.out.println("\t| 3.Cafe Cuba |  52 |");
						System.out.println("\t| 4.Appy Edge |  34 |");
						System.out.println("\t| 5.7-UP      |  38 |");
						System.out.println("\t| 6.Mirinda   |  60 |");
						System.out.println("\t| 7.Pepsi     |  60 |");
						
						System.out.println("\tChoose the option of Drink:");
						int drink=sc.nextInt();
						
						switch(drink)
						{
							case 1:cost=cost+126;
								break;
								
							case 2:cost=cost+61;
								break;
								
							case 3:cost=cost+52;
								break;
								
							case 4:cost=cost+34;
								break;
								
							case 5:cost=cost+38;
								break;
								
							case 6:
							case 7:cost=cost+60;
								break;
								
							default:System.out.println("\tInvalid choice for Drink");
								break;
						}
						break;
						
				
				case 4:	
						System.out.println("\n\t|      **** PASTA ****           | Rs. | ");
						System.out.println("\t| 1.Spanish Tomato Veg Pasta     | 139 |");
						System.out.println("\t| 2.Spanish Tomato Non-Veg Pasta | 159 |");
						
						System.out.println("\tChoose the option of pasta:");
						int pasta=sc.nextInt();
						
						switch(pasta)
						{
							case 1:cost=cost+139;
								break;
								
							case 2:cost=cost+159;
								break;
								
							default:System.out.println("\tInvalid choose for Pasta");
								break;	
								
						}
						break;
						
						
				case 5:
						System.out.println("\n\t|   **** SIDES ****            | Rs. |");
						System.out.println("\t| 1.Spicy Baked Chicken Wings  | 169 |");
						System.out.println("\t| 2.Garlic Bread Exotica       | 139 |");
						System.out.println("\t| 3.Cheese Garlic Bread        | 109 |");
						System.out.println("\t| 4.Garlic Bread Spicy Supreme | 129 |");
						System.out.println("\t| 5.Garlic Bread               |  89 |");
						System.out.println("\t| 6.Stuffed Pocket Veg         |  79 |");
						System.out.println("\t| 7.Stuffed Pocket Non-veg     |  99 |");
						System.out.println("\t| 8.Texas Garlic Dip           |  25 |");
						
						System.out.println("\tChoose the option of Sides:");						
						int sides =sc.nextInt();
						
						switch(sides)
						{
							case 1:cost=cost+169;
								break;
								
							case 2:cost=cost+139;
								break;
								
							case 3:cost=cost+109;
								break;
								
							case 4:cost=cost+129;
								break;
								
							case 5:cost=cost+89;
								break;
								
							case 6:cost=cost+79;
								break;
								
							case 7:cost=cost+99;
								break;
								
							case 8:cost=cost+25;
								break;
								
							default:System.out.println("\tInvalid choice for Sides ");
								break;	
						}
						break;
						
				case 6:	
						System.out.println("\n\t| **** Desserts ****   | Rs. |");
						System.out.println("\t| 1.Choco Mousse       |  79 |");
						System.out.println("\t| 2.Choco Truffle Cake |  79 |");
						
						System.out.println("\tChoose the option for Dessert:");						
						int dessert=sc.nextInt();
						switch(dessert)
						{
							case 1:cost=cost+79;
								break;
							
							case 2:cost=cost+79;
								break;
								
							default:System.out.println("\tInvalid choice for Dessert");
								break;	
						}
						
						break;
						
						
				case 7:
						System.out.println("\n\t| **** Magic Pan ****    | Rs. |");
						System.out.println("\t| 1.Paneer & Capsicum    |  99 |");
						System.out.println("\t| 2.Chola & Onion        |  79 |");
						System.out.println("\t| 3.corn                 |  59 |");
						System.out.println("\t| 4.Onion                |  59 |");
						System.out.println("\t| 5.Chicken Keema & Corn | 109 |");
						
						System.out.println("\tChoose the option for magic pan :");
						int magic=sc.nextInt();
						
						switch(magic)
						{
							case 1:cost=cost+99;
								break;
								
							case 2:cost=cost+79;
								break;
								
							case 3:
							case 4:	cost=cost+59;
								break;
								
							case 5:cost=cost+109;
								break;
						
							default:System.out.println("\tInvalid choice for Magic pan");
								break;
						}
						break;
					
				case 8:
						System.out.println("\n\t|         **** Offers ****                        | Rs. |");
						System.out.println("\t| 1.Pepsi + Tandoori Paneer Pizza + Choco mousse  | 700 |");
						System.out.println("\t| 2.Pepsi + Ultimate Chicken Pizza + Choco mousse | 750 |");
						
						System.out.println("\tChoose the option for offer:");
						int offer=sc.nextInt();
						
						switch(offer)
						{
							case 1:cost=cost+700;
								break;
								
							case 2:cost=cost+750;
								break;
								
							default:System.out.println("\tInvalid choice for Offer");
								break;
						}
						break;
						
				case 9:
						break;
						
				default:
						System.out.println("\tInvalid option\n");
						break;
						
				}//end of switch
			
			}//End of do
			
			while(x!=9);
		
			gst=(cost*9)/100;
			total_gst=cost+(2*gst);
			
//Delivery address and contact no
			if(x==9)
			{
				System.out.println("\n\t\tDelivery Address\t\t");
				System.out.println("Enter state :");
				state=sc.next();
				
				System.out.println("Enter pincode:");
				pin=sc.nextInt();
				
				System.out.println("Enter Town/City:");
				String city=sc.next();
				
				System.out.println("Enter Colony/Street/Locality:");
				loc=sc.next();
				
				System.out.println("Enter Flat no/Room no:");
				room=sc.nextInt();
		
				System.out.println("Enter Building name/Chawl name:");
				build=sc.next();
				build=sc.next();
				
				System.out.println("Enter the Landmark:");
			    mark=sc.next();
				
				System.out.println("Enter Mobile no:");
				int mob=sc.nextInt();
			    int n2=mob;
				while(n2!=0)
				{
					n2=n2/10;
					m++;
				}
				if(m!=10)		
				System.out.println("Mobile no is Incorrect\n");
				else
				System.out.println("Mobile no is Correct\n");
				
				
			}

	//Bill
			if(cost>0 &&cost<500)
			{
			System.out.println("\n\t\tBill\t\t");
			System.out.println("Name : "+name);
			System.out.println("Address : "+room);
			System.out.println("Total amount before GST Rs : "+cost);
			System.out.println("SGST Rs : "+gst+"%" );
			System.out.println("GST Rs : "+gst+"%" );
			System.out.println("Total amount after GST is Rs : "+total_gst);
			total_gst=total_gst+100;
			System.out.println("Delivery charge Rs: 100");
			System.out.println("Final amount Rs: "+total_gst);
			System.out.println("\n");
			}
			else
			{
			System.out.println("\n\t\tBill\t\t");	
			System.out.println("Name : "+name);
			System.out.println("Total amount before GST is Rs : "+cost);
			System.out.println("SGST: "+gst+"%");
			System.out.println("GST: "+gst+"%");
			System.out.println("Final amount Rs:  "+total_gst);
			System.out.println("\n");
			}
	//Feedback	
			System.out.println("\t\t***Please give a Feedback***\t");
			System.out.println("\fIf 'YES' Press 1 & For 'NO' Press 2");
			int j=sc.nextInt();
			if(j==1)
			{
				System.out.println("Enter Feedback:");
				String feedback=sc.next();
			}
			
			System.out.println("\t\t\t\t!!!THANK YOU!!!\t\t\t\t");
			
			
			}//End of else	
	}//End of main		
}//End of class