import java.util.Scanner;
import java.io.*;

class Aoc02c
{
	static int[] swap (int[] arr, int i, int j)
	{
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;

		return arr;
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

	static int abs (int i) {
		if (i < 0)
			return -i;
		return i;
	}

	public static int getLines (File file) throws IOException
	{
		int zeile = 0;
		Scanner scanner = new Scanner (file);
		while (scanner.hasNext ())
		{
			zeile++;
			String dummy = scanner.nextLine ();
		}
		return zeile;
	}


	public static boolean allUp (int[] arr)
	{
		int vgl = arr[0] -1; // dummy für aufsteigend-Test, immer true
		boolean result;

		for (int skip = 0; skip < arr.length; ++skip)
		{
			if (skip == 0)
				vgl = arr[1] - 1;
			result = true;
			for (int i = 0; i < arr.length; ++i)
			{
				if (i != skip)
				{
					if (arr[i] <= vgl)
						result = false;
					vgl = arr[i];
				}
			}
			if (result)
				return result;
		}
		return false;
	}

	public static boolean allDown (int[] arr)
	{
		int vgl = arr[0] + 1; // dummy für aufsteigend-Test, immer true
		boolean result;

		for (int skip = 0; skip < arr.length; ++skip)
		{
			if (skip == 0)
				vgl = arr[1] + 1;
			result = true;
			for (int i = 0; i < arr.length; ++i)
			{
				if (i != skip)
				{
					if (arr[i] >= vgl)
						result = false;
					vgl = arr[i];
				}
			}
			if (result)
				return result;
		}
		return false;
	}

	public static boolean inRange (int[] arr, int range)
	{
		int vgl = arr[0]; // dummy für Distanztest, immer true

		for (int skip = 0; skip < arr.length; ++skip)
		{
			if (skip == 0)
				vgl = arr[1];

			boolean result = true;
			for (int i = 0; i < arr.length; ++i)
			{
				if (i != skip)
				{
					if (abs (arr[i] - vgl) > range)
						result = false;
					vgl = arr[i];
				}
			}
			if (result)
				return true;
		}
		return false;
	}

	public static void main (String[] args) throws ArrayIndexOutOfBoundsException, IOException
	{
		// File file = new File ("./aoc02a.txt");
		File file = new File ("./aoc02.txt");
		// Answer 1: 365 too low (1st Element, when skipped, lok. Var. vgl muss adjustiert werden)
		// Answer 2: 381 too low
		// Answer 3: 569 too high (neuer Ansatz: x unterschiedliche Arrays per Zeile prüfen)

		int lines = getLines (file);
		int zeile = 0;
		int [][] values = new int [lines][];
		int matches = 0;
		Scanner scanner = new Scanner (file);
		while (scanner.hasNext ())
		{
			zeile++;
			String line = scanner.nextLine ();
			String tokens[] = line.split (" ");
			int len = tokens.length;
			int [] vals = new int [len];
			for (int i = 0; i < len; ++i)
			{
				vals[i] = Integer.parseInt (tokens[i]);
			}
			boolean notfound = true;
			for (int j = 0; j < len && notfound; ++j)
			{
				int [] arr = arrWithout (vals, len, j);
				if ((allUp (arr) || allDown (arr)) && inRange (arr, 3))
				{
					++matches;
					notfound = false;
					System.out.print ("* " + zeile + ": ");
					showArray (arr);
				}
			}
			if (notfound)
			{
				System.out.print ("- " + zeile + ": ");
				showArray (vals);
			}
		}
		System.out.println ("matches: " + matches);
	}

	static int [] arrWithout (int [] arr, int len, int skip)
	{
		int [] ia = new int [len-1];
		for (int i = 0, j = 0; i < len; ++i)
		{
			if (i != skip)
			{
				ia [j] = arr[i];
				++j;
			}
		}
		return ia;
	}
}
