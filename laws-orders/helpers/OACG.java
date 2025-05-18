import java.util.*;
import java.io.*;

// OriginalActCodeGenerator
public class OACG{
	public static void main(String[] args) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter("./filename.txt"));
		Scanner scn = new Scanner(System.in);
		int count = 0;
		String s = scn.nextLine();
		while(s.equals("-1")==false && count<10){
			writetabs(writer,count);
			enumeration(writer,s);
			newline(writer);
			count+=1;
			s = scn.nextLine();
		}
		writer.close();
	}

	// A function to generate prompt based on input string which specifies
	// number of various constituent elements

	public static void enumeration(BufferedWriter obj, String s) throws Exception{
		obj.write(s);
	}

	public static void writetabs(BufferedWriter obj, int count) throws Exception{
		while(count!=0){
			obj.write('\t');
			count-=1;
		}
	}

	public static void newline(BufferedWriter obj) throws Exception{
		obj.write('\n');
	}
}