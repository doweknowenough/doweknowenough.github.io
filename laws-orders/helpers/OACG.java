import java.util.*;
import java.io.*;

// What has not been included?
// // Arrangement of sections can also be done using javascript after all code has been completed
// // Date of signing
// // Date of coming into effect

// OriginalActCodeGenerator
public class OACG{
	public static void main(String[] args) throws Exception{
		System.out.println("Enter 1 to make input file");
		System.out.println("Enter 2 to generate output file");
		System.out.println("Enter 3 to remove all newlines from given text file");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String s = scn.nextLine();

		if(n==1){
			BufferedWriter writer = new BufferedWriter(new FileWriter(args[0]));
			Stack stack = new Stack();
			makeinput(writer,scn,"sections",stack);
			writer.close();
		}else if(n==2){
			BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
			BufferedReader reader2 = new BufferedReader(new FileReader(args[1]));
			BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]));
			writer.write("<!doctype html>\n<html>\n\t<head>\n\t\t<meta charset=\"utf-8\">\n\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n\t\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n\t\t<title>");
			s = reader2.readLine();
			writer.write(s);
			writer.write("</title>\n\t\t<link rel=\"stylesheet\" href=\"./../../helpers/act.css\">\n\t\t<link rel=\"icon\" type=\"image/x-icon\" href=\"./../../helpers/favicon.ico\">\n\t</head>\n\t<body>\n\t\t<section class=\"document container\">\n");
			makecode(writer,reader1,reader2,"sections",2);
			reader1.close();
			reader2.close();
			writer.write("\t\t</section>\n\t\t</body>\n</html>");
			writer.close();
		}else if(n==3){
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
			while(reader.ready()){
				s = reader.readLine();
				writer.write(s);
				writer.write(' ');
			}
			reader.close();
			writer.close();
		}
	}

	public static void makeinput(BufferedWriter bw, Scanner scn, String type, Stack stack) throws Exception{
		if(type.equals("sections")){
			stack.push("Intro");
			makeinput(bw,scn,"content",stack);
			stack.pop();

			System.out.println("Enter number of sections");
			int n = scn.nextInt();
			String s = scn.nextLine();
			bw.write(Integer.toString(n));
			bw.write('\n');
			for(int i = 1;i<=n;i++){
				stack.push("Section " + Integer.toString(i) + "/" + Integer.toString(n));
				makeinput(bw,scn,"section",stack);
				stack.pop();
			}
		}else if(type.equals("section")){
			stack.display();
			System.out.println("Section content");
			makeinput(bw,scn,"content",stack);
		}else if(type.equals("enum")){
			stack.display();
			System.out.println("Enumeration content");
			makeinput(bw,scn,"content",stack);
		}else if(type.equals("proviso")){
			makeinput(bw,scn,"content",stack);
		}else if(type.equals("explanation")){
			makeinput(bw,scn,"content",stack);
		}else if(type.equals("content")){
			stack.display();
			System.out.println("Enumeration or Description or Provision or Explanation?");
			String s = scn.nextLine();
			bw.write(s);
			bw.write('\n');
			if(s.equals("D") || s.equals("d")){
				stack.display();
				System.out.println("Enter number of paragraphs");
				int n = scn.nextInt();
				s = scn.nextLine();
				bw.write(Integer.toString(n));
				bw.write('\n');
			}else if(s.equals("E") || s.equals("e")){
				stack.display();
				System.out.println("Enter number of enumerates");
				int n = scn.nextInt();
				s = scn.nextLine();
				bw.write(Integer.toString(n));
				bw.write('\n');
				for(int i = 1;i<=n;i++){
					stack.push("Enumerate " + Integer.toString(i) + "/" + Integer.toString(n));
					makeinput(bw,scn,"enum",stack);
					stack.pop();
				}
			}else if(s.equals("P") || s.equals("p")){
				stack.push("Proviso ");
				makeinput(bw,scn,"proviso",stack);
				stack.pop();
			}else if(s.equals("X") || s.equals("x")){
				stack.push("Explanation ");
				makeinput(bw,scn,"explanation",stack);
				stack.pop();
			}else{
				System.out.println("Functionality not provided for");
			}
			stack.display();
			System.out.println("Continue?");
			s = scn.nextLine();
			bw.write(s);
			bw.write('\n');
			if(s.equals("Y") || s.equals("y")){
				makeinput(bw,scn,"content",stack);
			}
		}
	}

	public static void makecode(BufferedWriter bw, BufferedReader br, BufferedReader br_act, String type, int numtabs) throws Exception{
		if(type.equals("sections")){
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"intro container\">\n");
			makecode(bw,br,br_act,"content",numtabs+1);
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");

			int n = Integer.parseInt(br.readLine());
			for(int i = 1;i<=n;i++){
				writetabs(bw,numtabs+1);
				bw.write("<section class=\"section container\">\n");
				makecode(bw,br,br_act,"section",numtabs+1);
				writetabs(bw,numtabs+1);
				bw.write("</section>\n");
			}
		}else if(type.equals("section")){
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"section title\">\n");
			String s = br_act.readLine();
			writetabs(bw,numtabs+2);
			bw.write(s);
			bw.write("\n");
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"section content\">\n");
			makecode(bw,br,br_act,"content",numtabs+1);
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
		}else if(type.equals("enum")){
			writetabs(bw,numtabs+1);
			bw.write("<section class=\"enumerate\">\n");
			writetabs(bw,numtabs+2);
			bw.write("<section class=\"enumerate index\">\n");
			String s = br_act.readLine();
			writetabs(bw,numtabs+3);
			bw.write(s);
			bw.write("\n");
			writetabs(bw,numtabs+2);
			bw.write("</section>\n");
			writetabs(bw,numtabs+2);
			bw.write("<section class=\"enumerate content\">\n");
			makecode(bw,br,br_act,"content",numtabs+2);
			writetabs(bw,numtabs+2);
			bw.write("</section>\n");
			writetabs(bw,numtabs+1);
			bw.write("</section>\n");
		}else if(type.equals("proviso")){
			writetabs(bw,numtabs);
			bw.write("<section class=\"provision\">\n");
			makecode(bw,br,br_act,"content",numtabs);
			writetabs(bw,numtabs);
			bw.write("</section>\n");
		}else if(type.equals("explanation")){
			writetabs(bw,numtabs);
			bw.write("<section class=\"explanation\">\n");
			makecode(bw,br,br_act,"content",numtabs);
			writetabs(bw,numtabs);
			bw.write("</section>\n");
		}else if(type.equals("content")){
			String s = br.readLine();
			if(s.equals("D") || s.equals("d")){
				int n = Integer.parseInt(br.readLine());
				for(int i = 0;i<n;i++){
					writetabs(bw,numtabs+1);
					s = br_act.readLine();
					bw.write(s);
					if(i!=n-1){
						bw.write("<br>");
					}
					bw.write('\n');
				}
			}else if(s.equals("E") || s.equals("e")){
				int n = Integer.parseInt(br.readLine());
				writetabs(bw,numtabs+1);
				bw.write("<section class=\"enumeration\">\n");
				for(int i = 1;i<=n;i++){
					makecode(bw,br,br_act,"enum",numtabs+1);
				}
				writetabs(bw,numtabs+1);
				bw.write("</section>\n");
			}else if(s.equals("P") || s.equals("p")){
				makecode(bw,br,br_act,"proviso",numtabs);
			}else if(s.equals("X") || s.equals("x")){
				makecode(bw,br,br_act,"explanation",numtabs);
			}else{
				// Do Nothing
			}
			
			s = br.readLine();
			if(s.equals("Y") || s.equals("y")){
				makecode(bw,br,br_act,"content",numtabs+1);
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
		for(int i = 0;i<=this.pointer-1;i++){
			sb.append(this.stack[i]);
			sb.append("->");
		}
		System.out.println(sb.toString());
	}
}