# dynamicProgrammingList
A java based dynamic program that creates the optimum problem list for the given number of problems and time frame.

Purpose
=======
Build a skip list data structure to support the traversal, searching, addition, and deletion of
integers from a skip list. This implementation will support building a skip list to support
some number of occurrences of integers in the range of 1 to 1000. The objective of this
assignment requires the reading of an input file which contains commands and data to build,
search, modify, and print a skip list containing integers.

Functions
==================
Input 
Read input file passed as the first command line argument with one line each for
the following:

	- Number of problems - an integer between 1 and 10
	- Number of hours for the contest - an integer between 1 and 12
	- Number of hours for the problem following by the number of points for this
	  problem. For example: 4 10 would be a four hour problem worth ten points.

Schedule 
This function will determine the problem set to be attempted to maximize the
contest score.


Print list 
This function will print the optimum problem set as determined by the Schedule
function described above.


Compile/Run
===========
1. Open your terminal and go to the directory of the file.

2. Type in: java dynamicProgramming [text file]
	Example: java dynamicProgramming contestA.in
