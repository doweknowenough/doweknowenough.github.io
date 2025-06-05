import java.util.*;

public class Checkbox{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);

		System.out.println("Functionality?");
		System.out.println("Enter 1 for principle act");
		System.out.println("Enter 2 for an amending act");
		System.out.println("Enter 3 for ordinance");
		System.out.println("Enter 4 for rules");
		System.out.println("Enter 5 for regulations");
		System.out.println("Enter 6 for orders");
		System.out.println("Enter 7 for notification");
		System.out.println("Enter 8 for circular");

		int n = scn.nextInt();
		String s = scn.nextLine();
		if(n==1){
			System.out.println("Made changes in code of acts, it amends?");
			System.out.println("Made changes in code of acts, it repeals?");
			System.out.println("Made changes to list of acts in force or repealed?");
		}else if(n==2){
			System.out.println("Made separate file?");
			System.out.println("Made changes in code of acts, it amends?");
			System.out.println("Made changes to list of acts in force or repealed?");
		}
	}
}