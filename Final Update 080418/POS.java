

	/**ADMIN
	 * 
	 */
	//package Pointofsales ;

	/**
	 * @author ADMIN
	 *
	 */

		import java.util.*;
		public class POS
		{

			
			static int cus_no=0;
			static Scanner scan=new Scanner(System.in);
			static String detail [][]=new String[5][6];
			
		   
			public static  void login()
			{	
			
			  String admin[]={"admin","123"};
			
			ArrayList<String> cun=new ArrayList<String>();
			ArrayList<String>pswd=new ArrayList<String>();
			cun.add("cash");
			pswd.add("456");
			
			 String position;
			 String username,password;
			
				System.out.println("\n**********************************************       Login      *************************************************");
				System.out.println("Enter your position admin or cashier /n position(admin=0 / cashier=1)");
				position=scan.next();
				System.out.println("User_Name :");
				username=scan.next();
				System.out.println("PassWord :");
				password=scan.next();
				
				if(position.equals("0") && username.equals(admin[0]) && password.equals(admin[1]))
				{
					admin_Login(cun,pswd);
				}
				else if(position.equals("1") && username.equals(cun.get(0)) && password.equals(pswd.get(0)) )
				{
					cashier_Login(username);
				}
				else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("PassWord or UserName Incorrect !!!");
					System.out.println("Try Again !!!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					login();
				}
				
				
				
			}
			
			//Cashierlogin
				public static void cashier_Login(String username)
				{
					
					
					System.out.println("*****************************************************************************************************************\n");
					System.out.println(" 					Hi! "+ username.toUpperCase()+"! WELCOME TO POINT OF SALE SYSTEM.." );
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					
					Add_Item(username);
					
				}
				
				//Add_Item
				public static void Add_Item(String username){
				double TotalPrice=0;
				
				
				double Unitprice[]=new double[100];
				double price[]=new double[100];
				int quantity[]=new int[100];
				String product[]=new String[100];
				int quantityNo=0;
				System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++    		Add Items   	+++++++++++++++++++++++++++++++++++++++++++");
				System.out.println();
				System.out.println(" %%%%%%           			PLEASE ENTER 0 TO FINISH  ADDING ITEMS !!!!   				%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println();
				for(int i=0;i<100;i++)
				{
					System.out.print("Enter Product Name:");
					product[i]=scan.next();
					
					if(product[i].equals("0"))
					{
						for(int j=0;j<i;j++)
						{
							TotalPrice+=price[j];
						}
						quantityNo=i;
						Make_Sale(TotalPrice,quantityNo,Unitprice,price,quantity,product,username);
						break;
					}
					System.out.print("Enter quantity:");
					quantity[i]=scan.nextInt();
					System.out.print("unit Price : ");
					Unitprice[i]=scan.nextDouble();
					price[i]=Unitprice[i]*quantity[i];
					System.out.println("Price : "+price[i]);
					System.out.println();
					
					
				}
				System.out.println("go back = 1 | Login page = 2");
				int bi = scan.nextInt();
				
				if (bi==1) {
					cashier_Login(username);
				}else if (bi==2) {
					login();
				}else {
					System.out.println("Wrong Option");}
				
			}
			
			//Make_Sale
			public static void Make_Sale(double TotalPrice,int no,double Unitprice[],double price[],int quantity[],String product[],String username )
			{
				Date date=new Date();
				String str =String.format(" %tc", date ); 
				double amount_Pay,Balance;
				System.out.println("======================================================");
				System.out.println("Total Price: "+TotalPrice);
				System.out.println("No Of Items : "+no);
				System.out.print("Enter Amount Pay:");
				amount_Pay=scan.nextInt();
				Balance=amount_Pay-TotalPrice;
				System.out.println("Balance Pay:"+Balance);
				System.out.println("======================================================");
				
				
				
				
				detail[cus_no][0]=username;
				detail[cus_no][1]=" ";
				for(int i=0;i<no;i++)
				{
					detail[cus_no][1]=detail[cus_no][1].concat(product[i] +" "+quantity[i]+",");
				}
				detail[cus_no][2]=String.valueOf(TotalPrice);
				detail[cus_no][3]=String.valueOf(amount_Pay);
				detail[cus_no][4]= String.valueOf(Balance);
				detail[cus_no][5]=str;
				cus_no++;
				
				
				
				
				
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++   Thank You   +++++++++++++++++++++++++++++++++++++++++++++++\n");
				String answer="y";
				System.out.println("Do you want logout ?(Yes = y // No = n)");
				answer=scan.next();
				if(answer.equals("n")||answer.equals("N")){
					cashier_Login(username);
				}
				login();
			}
			

			//Admin_Login
			public  static void admin_Login(ArrayList cun,ArrayList pswd)
			{
				int option;
				
				
				System.out.println("*****************************************************************************************************************\n");
				System.out.println("					Hi! Admin, WELCOME TO POINT OF SALE SYSTEM..");
				System.out.println("*****************************************************************************************************************\n");
				System.out.println("1. Show Daily Summary \n 2. Add / Remove User \n Select activity : ");
				option=scan.nextInt();
				System.out.println();
				if(option==1)
					show_DailySummary();
				else if(option==2)
					Add_RemoveUser(cun,pswd);
				else
				{
					System.out.println("Error..Please Select 1 / 2...");
					System.out.print("1. Show Daily Summary \n 2. Add / Remove User \n Select activity : ");
					option=scan.nextInt();
					System.out.println();
				}
			}
			
			public static void Add_RemoveUser(ArrayList cun,ArrayList pswd){
				int option;
				String new_user,password,con_pas,delete_user;
				System.out.print("1. Add User\n 2.Remove User \n Select activity : ");
				option=scan.nextInt();
				if(option==1)
				{
					System.out.println();
					System.out.print("Enter New UserName :  ");
					new_user=scan.next();
					System.out.print("Enter Password : ");
					password=scan.next();
					System.out.print("Confirm Password : ");
					con_pas=scan.next();
					System.out.println();
					
					if(password.equals(con_pas))
					{
						cun.add(new_user);
						pswd.add(password);
						System.out.println(" you have created New User "+ new_user +" SuccessFully !");
						admin_Login(cun,pswd);	
					}
						
					else
						System.out.println(" Password and confirm Password are not matched !");
				}
				
				else if(option==2)
				{
					System.out.println();
					System.out.print("Enter  UserName to Delete :  ");
					delete_user=scan.next();
					cun.remove(delete_user);
					System.out.println(" you have Deleted  "+ delete_user +" SuccessFully !");
					admin_Login(cun,pswd);
				}
				
			}
			
			public static void show_DailySummary(){
				
				System.out.println("*******************************************		Daily Summary		******************************************************");
				System.out.println("**************************************************************************************************************************");
				System.out.println("Customer No\tCashier Name\tDate\t\t\t\t\tProduct Detail\t\t\tTotal_Price\t\tAmount_Pay\t\tBalance");
				System.out.println("**************************************************************************************************************************");
				for(int r=0;r<cus_no;r++)
				{
					System.out.println((r+1)+"\t\t"+detail[r][0]+"\t\t"+detail[r][5]+"\t\t"+detail[r][1]+"\t\t"+detail[r][2]+"\t\t\t"+detail[r][3]+"\t\t\t"+detail[r][4]);
					System.out.println("***********************************************************************************************************************");
				
				
				}
				
			}
			

			public static void main(String[] args) 
			{
				System.out.println("/////////////////////////////////////////////////////////######//////////////////////////////////////////////////");
				System.out.println("-------------------------------------------###    POINT OF SALES SYSTEM    ###-----------------------------------");
				System.out.println("/////////////////////////////////////////////////////////######//////////////////////////////////////////////////");
				login();
		    }
			
		}
		








