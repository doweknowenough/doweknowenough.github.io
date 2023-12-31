import os
import csv

if __name__ == '__main__':
	directory = "/Volumes/Macintosh_HD2/Github/doweknowenough.github.io/laws-orders/acts/"
	helper= "/Volumes/Macintosh_HD2/Github/doweknowenough.github.io/laws-orders/helper.html"
	with open('acts.csv', mode ='r') as file:
		csvFile = csv.reader(file)
		n = 1
		for lines in csvFile:
			file_name = str(lines[1]) + "-" + str(lines[2])
			directory2 = directory + file_name

			# if n%100==0:
			os.makedirs(directory2)
			file_path = directory2
			file_path+="/index.html"
			write_text = ["<html>\n","\t<head>\n","\t\t<title>",lines[0],", ",lines[1],"</title>\n","\t</head>\n","\t<body>\n","\t\t<a href='https://www.indiacode.nic.in/'>Indiacode Link (or) Link to latest text of law</a>\n",
			"\t\t<h3>","Amendments made to the act</h3>\n",
			"\t\t<ol>\n",
				"\t\t\t<li>\n",
					"\t\t\t\tLatest Amending Act\n",
						"\t\t\t\t<ol>\n",
							"\t\t\t\t\t<li>\n","\t\t\t\t\t\tSection 6, Provision 1, Sub provision 2 as stood before the amendment\n","\t\t\t\t\t</li>\n",
							"\t\t\t\t\t<li>\n","\t\t\t\t\t\tSection 7 as stood before the amendment\n","\t\t\t\t\t</li>\n",
						"\t\t\t\t</ol>\n",
				"\t\t\t</li>\n",
				"\t\t\t<li>\n",
					"\t\t\t\tFirst Amending Act\n",
						"\t\t\t\t<ol>\n",
							"\t\t\t\t\t<li>\n","\t\t\t\t\t\tSection 6, Provision 1, Sub provision 2 as stood before the amendment\n","\t\t\t\t\t</li>\n",
							"\t\t\t\t\t<li>\n","\t\t\t\t\t\tSection 7 as stood before the amendment\n","\t\t\t\t\t</li>\n",
						"\t\t\t\t</ol>\n",
				"\t\t\t</li>\n",
			"\t\t</ol>\n",
			"\t\t<h3>","Rules made under the act</h3>\n",
			"\t\t<ol>\n",
				"\t\t\t<li>\n",
					"\t\t\t\t<a href='https://www.indiacode.nic.in/'>Link to latest Rules, Year</a>\n",
						"\t\t\t\t<ol>\n",
							"\t\t\t\t\t<li>\n",
								"\t\t\t\t\t\t<a href='https://www.indiacode.nic.in/'>Latest Amending Rules, Year</a>\n",
								"\t\t\t\t\t\t<ol>\n",
									"\t\t\t\t\t\t\t<li>\n","\t\t\t\t\t\t\t\tRule 4, sub rule 3, sub sub rule 5 as stood before the amending rules\n","\t\t\t\t\t\t\t</li>\n",
									"\t\t\t\t\t\t\t<li>\n","\t\t\t\t\t\t\t\tRule 4, sub rule 3, sub sub rule 5 as stood before the amending rules\n","\t\t\t\t\t\t\t</li>\n",
								"\t\t\t\t\t\t</ol>\n",
							"\t\t\t\t\t</li>\n",
							"\t\t\t\t\t<li>\n",
								"\t\t\t\t\t\t<a href='https://www.indiacode.nic.in/'>First Amending Rules, Year</a>\n",
								"\t\t\t\t\t\t<ol>\n",
									"\t\t\t\t\t\t\t<li>\n","\t\t\t\t\t\t\t\tRule 4, sub rule 3, sub sub rule 5 as stood before the amending rules\n","\t\t\t\t\t\t\t</li>\n",
									"\t\t\t\t\t\t\t<li>\n","\t\t\t\t\t\t\t\tRule 4, sub rule 3, sub sub rule 5 as stood before the amending rules\n","\t\t\t\t\t\t\t</li>\n",
								"\t\t\t\t\t\t</ol>\n",
							"\t\t\t\t\t</li>\n",
						"\t\t\t\t</ol>\n",
				"\t\t\t</li>\n",
				"\t\t\t<li>\n",
					"\t\t\t\t<a href='https://www.indiacode.nic.in/'>Link to first Rules, Year</a>\n",
						"\t\t\t\t<ol>\n",
							"\t\t\t\t\t<li>\n",
								"\t\t\t\t\t\t<a href='https://www.indiacode.nic.in/'>Latest Amending Rules, Year</a>\n",
								"\t\t\t\t\t\t<ol>\n",
									"\t\t\t\t\t\t\t<li>\n","\t\t\t\t\t\t\t\tRule 4, sub rule 3, sub sub rule 5 as stood before the amending rules\n","\t\t\t\t\t\t\t</li>\n",
									"\t\t\t\t\t\t\t<li>\n","\t\t\t\t\t\t\t\tRule 4, sub rule 3, sub sub rule 5 as stood before the amending rules\n","\t\t\t\t\t\t\t</li>\n",
								"\t\t\t\t\t\t</ol>\n",
							"\t\t\t\t\t</li>\n",
							"\t\t\t\t\t<li>\n",
								"\t\t\t\t\t\t<a href='https://www.indiacode.nic.in/'>First Amending Rules, Year</a>\n",
								"\t\t\t\t\t\t<ol>\n",
									"\t\t\t\t\t\t\t<li>\n","\t\t\t\t\t\t\t\tRule 4, sub rule 3, sub sub rule 5 as stood before the amending rules\n","\t\t\t\t\t\t\t</li>\n",
									"\t\t\t\t\t\t\t<li>\n","\t\t\t\t\t\t\t\tRule 4, sub rule 3, sub sub rule 5 as stood before the amending rules\n","\t\t\t\t\t\t\t</li>\n",
								"\t\t\t\t\t\t</ol>\n",
							"\t\t\t\t\t</li>\n",
						"\t\t\t\t</ol>\n",
				"\t\t\t</li>\n",
			"\t\t</ol>\n",
			"\t\t<h3>","Miscellaneous Provisions</h3>\n",
			"\t\t<ol>\n",
				"\t\t\t<li>\n",
					"\t\t\t\tNotwithstanding provisions\n",
				"\t\t\t</li>\n",
				"\t\t\t<li>\n",
					"\t\t\t\tOverrides some other act\n",
				"\t\t\t</li>\n",
				"\t\t\t<li>\n",
					"\t\t\t\tOperationalises or executes provisions of some other act (or) This act is related to these acts\n",
				"\t\t\t</li>\n",
			"\t\t</ol>\n",
			"\t</body>\n","</html>"]
			write_text2 = ["<li>\n","\t","<a href='./acts/",lines[1],"-",lines[2],"/'>",lines[0],", ",lines[1],"</a>\n","</li>\n"]
			with open(file_path, "w") as file1:
			    file1.writelines(write_text)
			
			with open(helper, "a") as file2:
				file2.writelines(write_text2)

			print(file_name)

			# n+=1