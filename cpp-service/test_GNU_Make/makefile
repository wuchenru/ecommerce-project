# target: dependencies
# 	command

default: main.o stuff.o
	g++ main.o stuff.o -o out

clean:
	rm out
	rm *.o

main.o: main.cpp

	g++ -c -o main.o main.cpp -O2 -Wall


# g++ -c -o main.o main.cpp

run: 
	./out

stuff.o: stuff.h stuff.cpp
	g++ -c -o stuff.o stuff.cpp -O2 -Wall


# do everything to execute the program
quick-run: main.o stuff.o
	g++ main.o stuff.o -o out
	./out
	rm out
	rm *.o

test: 