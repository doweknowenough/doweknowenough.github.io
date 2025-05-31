import java.util.*;
import java.io.*;

// OriginalActCodeGenerator
public class OACG{
	public static void main(String[] args) throws Exception{
		System.out.println("Enter 1 to make input file");
		System.out.println("Enter 2 to generate output file");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String s = scn.nextLine();

		if(n==1){
			System.out.println("Enter path to the input file");
			System.out.println("Sample-./../test/test-area/input.txt");
			s = scn.nextLine();
			BufferedWriter writer = new BufferedWriter(new FileWriter(s));
			makeinput(writer,scn,"sections");
			writer.close();
		}else if(n==2){
			System.out.println("Enter path to the input file");
			System.out.println("Sample-./../test/test-area/input.txt");
			s = scn.nextLine();
			BufferedReader reader = new BufferedReader(new FileReader("./../test/test-area/input.txt"));
			System.out.println("Enter path to the code file");
			System.out.println("Sample-./../test/test-area/output.txt");
			s = scn.nextLine();
			BufferedWriter writer = new BufferedWriter(new FileWriter(s));
			writer.write("<!doctype html>\n<html>\n\t<head>\n\t\t<meta charset=\"utf-8\">\n\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n\t\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n\t\t<title>");
			s = reader.readLine();
			writer.write(s);
			writer.write("</title>\n\t\t<link rel=\"stylesheet\" href=\"./../../helpers/act.css\">\n\t\t<link rel=\"icon\" type=\"image/x-icon\" href=\"./../../helpers/favicon.ico\">\n\t</head>\n\t<body>\n");
			makecode(writer,reader,"sections",1);
			reader.close();
			writer.write("\t</body>\n</html>");
			writer.close();
		}
		
		// date
		// intro
		// arrangement of chapters
		// arrangement of sections
		// arrangement of schedules which may contain a table
		// Also create a stack which can display what element is being currently worked upon
	}

	public static void arrangement(BufferedWriter obj, Scanner scn) throws Exception{

	}

	public static void makeinput(BufferedWriter bw, Scanner scn, String type) throws Exception{
		if(type.equals("sections")){
			System.out.println("Enter number of sections");
			int n = scn.nextInt();
			String s = scn.nextLine();
			bw.write(Integer.toString(n));
			bw.write('\n');
			for(int i = 1;i<=n;i++){
				makeinput(bw,scn,"section");
			}
		}else if(type.equals("section")){
			System.out.println("Enter section title");
			String s = scn.nextLine();
			bw.write(s);
			bw.write("\n");
			makeinput(bw,scn,"content");
		}else if(type.equals("enum")){
			System.out.println("Enter enumeration index");
			String s = scn.nextLine();
			bw.write(s);
			bw.write("\n");
			makeinput(bw,scn,"content");
		}else if(type.equals("proviso")){
			makeinput(bw,scn,"content");
		}else if(type.equals("explanation")){
			makeinput(bw,scn,"content");
		}else if(type.equals("content")){
			System.out.println("Enumeration or Description or Provision or Explanation?");
			String s = scn.nextLine();
			bw.write(s);
			bw.write('\n');
			if(s.equals("D")){
				System.out.println("Enter the descriptive text");
				s = scn.nextLine();
				while(s.equals("-1")==false){
					bw.write(s);
					bw.write("\n");
					System.out.println("Enter -1 if no content ahead like another para else enter the same");
					s = scn.nextLine();
				}
				bw.write(s);
				bw.write('\n');
			}else if(s.equals("E")){
				System.out.println("Enter number of enumerates");
				int n = scn.nextInt();
				s = scn.nextLine();
				bw.write(Integer.toString(n));
				bw.write('\n');
				for(int i = 1;i<=n;i++){
					makeinput(bw,scn,"enum");
				}
			}else if(s.equals("P")){
				makeinput(bw,scn,"proviso");
			}else if(s.equals("X")){
				makeinput(bw,scn,"explanation");
			}else{
				System.out.println("Functionality not provided for");
			}
			
			System.out.println("Continue?");
			s = scn.nextLine();
			bw.write(s);
			bw.write('\n');
			if(s.equals("Y")){
				makeinput(bw,scn,"content");
			}
		}
	}

	public static void makecode(BufferedWriter bw, BufferedReader br, String type, int numtabs) throws Exception{
		if(type.equals("sections")){
			int n = Integer.parseInt(br.readLine());

			for(int i = 1;i<=n;i++){
				writetabs(bw,numtabs+1);
				bw.write("<section class=\"section container\">\n");
				makecode(bw,br,"section",numtabs+1);
				writetabs(bw,numtabs+1);
				bw.write("</section>\n");
			}
		}else if(type.equals("section")){
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"section title\">\n");
			String s = br.readLine();
			writetabs(bw,numtabs+2);
			bw.write(s);
			bw.write("\n");
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"section content\">\n");
			makecode(bw,br,"content",numtabs+1);
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
		}else if(type.equals("enum")){
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"enumerate\">\n");
			writetabs(bw,numtabs+2);
			bw.write("<section class=\"enumerate index\">\n");
			String s = br.readLine();
			writetabs(bw,numtabs+3);
			bw.write(s);
			bw.write("\n");
			writetabs(bw,numtabs+2);
			bw.write("</section>\n");
			writetabs(bw,numtabs+2);
			bw.write("<section class=\"enumerate content\">\n");
			makecode(bw,br,"content",numtabs+2);
			writetabs(bw,numtabs+2);
			bw.write("</section>\n");
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
		}else if(type.equals("proviso")){
			writetabs(bw,numtabs);
			bw.write("<section class=\"provision\">\n");
			makecode(bw,br,"content",numtabs+1);
			writetabs(bw,numtabs);
			bw.write("</section>\n");
		}else if(type.equals("explanation")){
			writetabs(bw,numtabs);
			bw.write("<section class=\"explanation\">\n");
			makecode(bw,br,"content",numtabs+1);
			writetabs(bw,numtabs);
			bw.write("</section>\n");
		}else if(type.equals("content")){
			String s = br.readLine();
			if(s.equals("D")){
				s = br.readLine();
				while(s.equals("-1")==false){
					writetabs(bw,numtabs+1);
					bw.write(s);
					bw.write("\n");
					s = br.readLine();
				}
			}else if(s.equals("E")){
				int n = Integer.parseInt(br.readLine());
				writetabs(bw,numtabs+1);
				bw.write("<section class=\"enumeration\">\n");
				for(int i = 1;i<=n;i++){
					makecode(bw,br,"enum",numtabs+1);
				}
				writetabs(bw,numtabs+1);
				bw.write("</section>\n");
			}else if(s.equals("P")){
				makecode(bw,br,"proviso",numtabs);
			}else if(s.equals("X")){
				makecode(bw,br,"explanation",numtabs);
			}else{
				// Do Nothing
			}
			
			s = br.readLine();
			if(s.equals("Y")){
				makecode(bw,br,"content",numtabs+1);
			}
		}
	}

	public static void writetabs(BufferedWriter obj, int count) throws Exception{
		while(count!=0){
			obj.write('\t');
			count-=1;
		}
	}
}

class Stack{
	String[] stack;
	int pointer;

	public Stack(){
		this.stack = new String[1000];
		this.pointer = 0;
	}

	public void push(String s){
		int i = this.pointer;
		this.stack[i] = s;
		this.pointer = i+1;
	}

	public void pop(){
		int i = this.pointer;
		this.pointer = i-1;
	}

	public void display(){
		StringBuilder sb = new StringBuilder();
		for(int i = this.pointer-1;i>=0;i--){
			sb.append(this.stack[i]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}