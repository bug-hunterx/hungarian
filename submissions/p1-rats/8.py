def f(input, n, width) :
	str = input
	str = str.replace(" ", ".")
	
	column = n
	tagging = width
	
	my_list = []
	
	def printme():
		y = "."
		for x in range(1, tagging):
			y += "."
		return y;
		
	def drawOneline(lineNum, array, rowparam):
		line = ""
		for x in range(0, column):
			line += (array[lineNum]);
			lineNum += rowparam
			if x < column-1:
				line += "|"
		return line
	
	for x in range(0, column*column):
	    my_list.append(str[x*tagging:x*tagging+tagging])
	my_list = [x for x in my_list if x != '']
	
	y = len(my_list[-1])
	for x in range(y, tagging):
		my_list[-1] = my_list[-1] + "."
	
	row = len(my_list) / column
	row = int(row)
	leftover = len(my_list) % column
	
	if(leftover != 0):
		row += 1
		
	for x in range(len(my_list), column*row):
			my_list.append(printme())
	
	for x in range(0, row):
		print(drawOneline(x, my_list, row))

	return