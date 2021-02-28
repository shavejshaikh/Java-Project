	package KBC;
	import java.net.*;
	import java.io.*;
	
	
	public class Server {
	
		public static void main(String[] args)  throws Exception
		{
			int choice,a,b,c=0,c1=0;
			
			ServerSocket ss = new ServerSocket(1024);
			Socket s = ss.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader (s.getInputStream() ) );
			choice =Integer.parseInt(br.readLine());
			a =Integer.parseInt(br.readLine());
			b = Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1 : c = a+b;
			break;
			case 2 : c = a-b;
			break;
			case 3 : c = a*b;
			break;
			case 4 : c = a/b;
			break;
			case 5 : c = (a%b);
			break;
			case 6: c=even(a);
			break;
			case 7: c1=armstrong(a);
			}
			
			PrintStream pr = new PrintStream(s.getOutputStream()) ;
			pr.println(c);
			pr.println(c1);
			ss.close();
			s.close();
			}
		
			public static int even(int a)
			{
				if(a%2==0)
				{
					return 1;
				}
				else return 0;
			}
		
			
			public static int armstrong(int a)
			{
				int temp,sum=0,t;
				temp=a;
				while(temp!=0)
				{
					t=temp%10;
					sum=sum+(t*t*t);
					temp=temp/10;	
				}
				return sum;
			}
	
	}
	
