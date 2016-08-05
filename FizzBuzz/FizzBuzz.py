for i in range (1,101):
	fb = ""
	if i % 3 is 0:
		fb += "Fizz"
	if i % 5 is 0:
		fb += "Buzz"
	if fb is "":
		print(i)
	else:
		print(fb)