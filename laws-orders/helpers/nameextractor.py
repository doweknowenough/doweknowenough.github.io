import os
import csv

def extract_link(data_point):
	link_v1 = data_point.split("href=")[1]
	link_v2 = link_v1.split("></a>")[0]
	link_v3 = link_v2[1:-1]
	link = "https://www.indiacode.nic.in" + link_v3
	link_v4 = link_v3.split("/")[3]
	link_v5 = link_v4[1:-4]
	link_v6 = link_v5.split("-")
	if len(link_v6)==2:
		year = link_v6[0]
		act_number = link_v6[1]
	else:
		year = link_v5
		act_number = link_v5
	return [link, act_number, year]

def extract_name(data_point):
	name_v1 = data_point.split("(Rep.,")
	act_name = data_point
	repealed_by = data_point
	if len(name_v1)!=2:
		print(data_point)
	else:
		act_name = name_v1[0]
		repealed_by = name_v1[1]
	return act_name, repealed_by

if __name__ == '__main__':
	
	# repealed.txt is made by copying HTML code of repealed act section 
	# from Indiacode website. Further edited to remove useless text

	actfile_name = "/Volumes/Macintosh_HD2/Github/doweknowenough.github.io/laws-orders/helpers/repealed.txt"
	actcsvfile_name = "/Volumes/Macintosh_HD2/Github/doweknowenough.github.io/laws-orders/helpers/repealedactstest.csv"
	num_lines = 15315

	file = open(actcsvfile_name, 'w')
	writer = csv.writer(file)
   

	f = open(actfile_name, "r")
	for i in range(0,num_lines,4):
		act_instance = ""
		for j in range(4):
			act_instance+=f.readline()
		details = act_instance.split("<td>")
		
		link, act_number, act_year = extract_link(details[3][:-2])
		act_name, repealed_by = extract_name(details[1][:-2])
		year = details[2][:-1]
		writer.writerow([act_name,repealed_by,year,act_number,act_year,link])
	f.close()
	file.close()