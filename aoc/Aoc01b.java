/**
This time, you'll need to figure out exactly how often each number from the left list appears in the right list. Calculate a total similarity score by adding up each number in the left list after multiplying it by the number of times that number appears in the right list.

Here are the same example lists again:

3   4
4   3
2   5
1   3
3   9
3   3

For these example lists, here is the process of finding the similarity score:

    The first number in the left list is 3. It appears in the right list three times, so the similarity score increases by 3 * 3 = 9.
    The second number in the left list is 4. It appears in the right list once, so the similarity score increases by 4 * 1 = 4.
    The third number in the left list is 2. It does not appear in the right list, so the similarity score does not increase (2 * 0 = 0).
    The fourth number, 1, also does not appear in the right list.
    The fifth number, 3, appears in the right list three times; the similarity score increases by 9.
    The last number, 3, appears in the right list three times; the similarity score again increases by 9.

So, for these example lists, the similarity score at the end of this process is 31 (9 + 4 + 0 + 0 + 9 + 9).
*/
import java.util.Scanner;
import java.io.*;

class Aoc01b
{
	static int getSize (Scanner sc)
	{
		int line = 0;
		while (sc.hasNext ())
		{
			sc.nextLine ();
			++line;
		}
		return line;
	}

	public static void main (String[] args) throws IOException
	{
		File f = new File ("./aoc01.txt");
		Scanner sc = new Scanner (f);
		int len = getSize (sc);
		int [] ar1 = new int [len];
		int [] ar2 = new int [len];

		sc = new Scanner (f);
		int line = 0;

		while (sc.hasNext ())
		{
			ar1[line] = sc.nextInt ();
			ar2[line] = sc.nextInt ();
			++line;
		}
		showArray (ar1);
		showArray (ar2);

		int [] counts = new int [len];

		findMatches (ar1, ar2, counts);
		int result = score (ar1, counts);
		System.out.println (result);
	}

	/*	YAGNI, premature optimization is the root of all evil

		i	ar1 ar2	counts (ar1[i] in ar[2])
		0	3   4	3
		1	4   3	1
		2	2   5	0
		3	1   3	0
		4	3   9	3
		5	3   3	3
	*/
	static void findMatches (int [] ar1, int [] ar2, int [] counts)
	{
		int counter = 0;
		for (int v1 : ar1)
		{
			// eigentlich überflüssig, da Array of int eh mit Nullen initialisiert wird:
			counts[counter] = 0;

			for (int v2: ar2)
			{
				if (v2 == v1)
				{
					++counts[counter];
					System.out.print (".");
				}
				System.out.println ();
			}
			++counter;
		}
	}

	static void showArray (int [] arr)
	{
		System.out.print ("{");
		for (int i=0; i < arr.length; ++i)
		{
			System.out.print (arr[i] + ", ");
		}
		System.out.println ("\b\b}");
	}

	static int score (int [] ar1, int [] counts)
	{
		int sum = 0;

		for (int i = 0; i < ar1.length; ++i)
		{
				int product = ar1[i] * counts[i];
				System.out.println ("pr: " + product);
				sum += product;
		}
		return sum;
	}
}
