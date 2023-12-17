import os
import csv

if __name__ == '__main__':
	directory = "/Volumes/Macintosh_HD2/Github/doweknowenough.github.io/laws-orders/"
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
			write_text = ["<html>\n","\t<head>\n","\t\t<title>",lines[0],", ",lines[1],"</title>\n","\t</head>\n","\t<body>\n","\t</body>\n","</html>"]
			write_text2 = ["<li>\n","\t","<a href='./",lines[1],"-",lines[2],"/'>",lines[0],", ",lines[1],"</a>\n","</li>\n"]
			with open(file_path, "w") as file1:
			    file1.writelines(write_text)
			
			with open(helper, "a") as file2:
				file2.writelines(write_text2)

			print(file_name)

			# n+=1