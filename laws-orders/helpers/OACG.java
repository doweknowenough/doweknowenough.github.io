import java.util.*;
import java.io.*;

// OriginalActCodeGenerator
public class OACG{
	public static void main(String[] args) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter("./filename.txt"));
		Scanner scn = new Scanner(System.in);

		// initial code
		writer.write("<!doctype html>\n<html>\n\t<head>\n\t\t<title>");
		writer.write(s);
		writer.write("</title>\n\t</head>\n\t<body>\n");
		
		// name of act
		String s = scn.nextLine();

		// date
		// intro
		// arrangement of chapters
		// arrangement of sections
		// arrangement of schedules

		makecode(writer,scn,"sections",1);
		writer.write("\t</body>\n</html>");
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
				bw.write("<section class=\"section container\">\n");
				makecode(bw,scn,"section",numtabs+1);
				writetabs(bw,numtabs+1);
				bw.write("</section>\n");
			}
		}else if(type.equals("section")){
			System.out.println("Enter section title");
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"section title\">\n");
			String s = scn.nextLine();
			writetabs(bw,numtabs+2);
			bw.write(s);
			bw.write("\n");
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"section content\">\n");
			
			// Enter code for writing into section content
			makecode(bw,scn,"content",numtabs+2);
			
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
		}else if(type.equals("enum")){
			System.out.println("Enter enumeration index");
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"enumerate\">\n");
			writetabs(bw,numtabs+2);
			bw.write("<section class=\"enumerate index\">\n");
			String s = scn.nextLine();
			writetabs(bw,numtabs+3);
			bw.write(s);
			bw.write("\n");
			writetabs(bw,numtabs+2);
			bw.write("</section>\n");
			writetabs(bw,numtabs+2);
			bw.write("<section class=\"enumerate content\">\n");
			
			// Enter code for writing into enumeration content
			makecode(bw,scn,"content",numtabs+3);

			writetabs(bw,numtabs+2);
			bw.write("</section>\n");
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
		}else if(type.equals("proviso")){
			writetabs(bw,numtabs);
			bw.write("<section class=\"provision\">\n");
			
			// Enter code for writing into provision content
			makecode(bw,scn,"content",numtabs+1);

			writetabs(bw,numtabs);
			bw.write("</section>\n");
		}else if(type.equals("explanation")){
			writetabs(bw,numtabs);
			bw.write("<section class=\"explanation\">\n");
			
			// Enter code for writing into explanation content
			makecode(bw,scn,"content",numtabs+1);

			writetabs(bw,numtabs);
			bw.write("</section>\n");
		}else if(type.equals("content")){
			System.out.println("Enumeration or Description or Provision or Explanation?");
			String s = scn.nextLine();
			if(s.equals("E")){
				System.out.println("Enter number of enumerates");
				int n = scn.nextInt();
				s = scn.nextLine();
				writetabs(bw,numtabs+1);
				bw.write("<section class=\"enumeration\">\n");
				for(int i = 1;i<=n;i++){
					makecode(bw,scn,"enum",numtabs+1);
				}
				writetabs(bw,numtabs+1);
				bw.write("</section>\n");
			}else if(s.equals("D")){
				System.out.println("Enter the descriptive text");
				s = scn.nextLine();
				writetabs(bw,numtabs+1);
				bw.write(s);
				bw.write("\n");
				// take a input
				// ask whether there is enumeration ahead
				// ask whether there is provision ahead
				// ask whether there is explanation ahead
			}else if(s.equals("P")){
				makecode(bw,scn,"proviso",numtabs);
			}else if(s.equals("X")){
				makecode(bw,scn,"explanation",numtabs);
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
}