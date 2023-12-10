import os
import csv

if __name__ == '__main__':
	directory = "/Volumes/Macintosh_HD2/Github/doweknowenough.github.io/laws-orders/"
	with open('acts.csv', mode ='r') as file:
		csvFile = csv.reader(file)
		n = 1
		for lines in csvFile:
			file_name = str(lines[1]) + "-" + str(lines[2])
			directory2 = directory + file_name

			if n%200==0:
				os.makedirs(directory2)
				file_path = directory2
				file_path+="/index.html"
				write_text = ["<html>\n","\t<head>\n","\t\t<title>",lines[0],",",lines[1],"</title>\n","\t</head>\n","\t<body>\n","\t</body>\n","</html>"]
				with open(file_path, "w") as file1:
				    file1.writelines(write_text)
				
				print(file_name)

			n+=1