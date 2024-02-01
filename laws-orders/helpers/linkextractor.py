import os
import csv

if __name__ == '__main__':
	
	# act_links.txt is made by copying HTML code of acts in force from Indiacode website. Further
	# edited to remove useless text

	actfile_name = "/Volumes/Macintosh_HD2/Github/doweknowenough.github.io/laws-orders/helpers/act_links.txt"
	actcsvfile_name = "/Volumes/Macintosh_HD2/Github/doweknowenough.github.io/laws-orders/helpers/act_links.csv"
	num_lines = 883

	file = open(actcsvfile_name, 'w')
	writer = csv.writer(file)
   

	f = open(actfile_name, "r")
	for i in range(0,num_lines):
		act_instance = f.readline()
		details = act_instance.split("<td>")
		name = details[3][0:-5]
		link = details[4][0:-7]
		writer.writerow([name,link])
	f.close()
	file.close()