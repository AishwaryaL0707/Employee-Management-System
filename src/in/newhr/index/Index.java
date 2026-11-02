package in.newhr.index;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=0;
		System.out.println("<===== NewHR login =====>");
		do {
			System.out.println("<1> Login");
			System.out.println("<2> Signup");
			System.out.println("<3> Exit");
			i=sc.nextInt();
			switch(i) {
				case 1: Login.login();
				break;
				case 2:Signup.signup();
				break;
				case 3:System.out.println("Application closed!");
				break;
				default: System.out.println("Incorrect option. Try again!");
			}
		}while(i!=3);
	}
}
