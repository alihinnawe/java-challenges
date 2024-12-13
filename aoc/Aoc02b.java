import java.util.Scanner;
import java.io.*;

class Aoc02b
{
	static int[] swap (int[] arr, int i, int j)
	{
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;

		return arr;
	}

	/* b) Bubblesort:
	static void sort (int [] arr)
	{
		// for-loop war noch nicht dran, daher mit while
		// for (int i=0; i < arr.length - 1; ++i)
		{
			int i = 0;
			while (i < arr.length - 1)
			{
				int j = i + 1;
				while (j < arr.length)
				// for (int j=i+1; ++j)
				{
					// ++vergleiche;
					if (arr[i] > arr[j])
					{
						arr = swap (arr, i, j);
						// ++swaps;
					}
					++j;
				}
				i++;
			}
		}
		// println ("Vergleiche: " + vergleiche + "\tSwaps: " + swaps);
		// return arr;
	}
	*/

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
		// Answer: 365 too low

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
			int [] vals = new int [tokens.length];
			for (int i = 0; i < tokens.length; ++i)
			{
				vals[i] = Integer.parseInt (tokens[i]);
			}
			if ((allUp (vals) || allDown (vals)) && inRange (vals, 3))
				++matches;
			else
			{
				System.out.print (zeile + ": ");
				showArray (vals);
			}
		}
		System.out.println ("matches: " + matches);
	}
}
