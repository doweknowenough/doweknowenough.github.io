import java.util.*;
import java.io.*;

// OriginalActCodeGenerator
public class OACG{
	public static void main(String[] args) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter("./filename.txt"));
		Scanner scn = new Scanner(System.in);
		int numtabs = 0;

		String s = scn.nextLine();
		if(s.equals("intro")){
			// initial code
			// name of act
			// date
			// intro
		}else if(s.equals("arrangement")){
			// arrangement of chapters
			// arrangement of sections
			// arrangement of schedules
		}else if(s.equals("sections")){
			makecode(bw,scn,s,numtabs);
		}
		writer.close();
	}

	public static void arrangement(BufferedWriter obj, Scanner scn) throws Exception{

	}

	public static void makecode(BufferedWriter bw, Scanner scn, String type, int numtabs) throws Exception{
		if(type.equals("sections")){
			System.out.println("Enter number of sections");
			int n = scn.nextInt();
			String s = scn.nextLine();
			for(int i = 1;i<=n;i++){
				writetabs(bw,numtabs+1);
				bw.write("<section class=\"section container\">");
				makecode(bw,scn,"section",numtabs+1);
				writetabs(bw,numtabs+1);
				bw.write("</section>");
			}
		}else if(type.equals("section")){
			System.out.println("Enter section title");
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"section title\">");
			String s = scn.nextLine();
			bw.write(s);
			writetabs(bw,numtabs+1);
			bw.write("</section>");
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"section content\">");
			
			// Enter code for writing into section content
			makecode(bw,scn,"content",numtabs);
			
			writetabs(bw,numtabs+1);
			bw.write("</section>");
		}else if(type.equals("enum")){
			System.out.println("Enter enumeration index");
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"enumerate\">");
			writetabs(bw,numtabs+2);
			bw.write("<section class=\"enumerate index\">");
			String s = scn.nextLine();
			bw.write(s);
			writetabs(bw,numtabs+2);
			bw.write("</section>");
			writetabs(bw,numtabs+2);
			bw.write("<section class=\"enumerate content\">");
			
			// Enter code for writing into enumeration content
			makecode(bw,scn,"content",numtabs+3);

			writetabs(bw,numtabs+2);
			bw.write("</section>");
			writetabs(bw,numtabs+1);
			bw.write("</section>");
		}else if(type.equals("proviso")){
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"provision\">");
			
			// Enter code for writing into enumeration content
			makecode(bw,scn,"content",numtabs+1);

			writetabs(bw,numtabs+1);
			bw.write("</section>");
		}else if(type.equals("explanation")){
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"explanation\">");
			
			// Enter code for writing into enumeration content
			makecode(bw,scn,"content",numtabs+1);

			writetabs(bw,numtabs+1);
			bw.write("</section>");
		}else if(type.equals("content")){
			System.out.println("Enumeration or Description or Provision or Explanation?");
			String s = scn.nextLine();
			if(s.equals("E")){
				System.out.println("Enter number of enumerates");
				int n = scn.nextInt();
				s = scn.nextLine();
				writetabs(bw,numtabs+1);
				bw.write("<section class=\"enumeration\">");
				for(int i = 1;i<=n;i++){
					makecode(bw,scn,"enum",numtabs+1);
				}
				writetabs(bw,numtabs+1);
				bw.write("</section>");
			}else if(s.equals("D")){
				s = scn.nextLine();
				bw.write(s);
				// take a input
				// ask whether there is enumeration ahead
				// ask whether there is provision ahead
				// ask whether there is explanation ahead
			}else if(s.equals("P")){
				makecode(bw,scn,"proviso",numtabs+1);
			}else if(s.equals("X")){
				makecode(bw,scn,"explanation",numtabs+1);
			}else{
				System.out.println("Functionality not provided for");
			}

			System.out.println("Do we need to continue?");
			s = scn.nextLine();
			if(s.equals("Y")){
				makecode(bw,scn,"content",numtabs+1);
			}
		}
	}

	// A function to generate prompt based on input string which specifies
	// number of various constituent elements

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