/**
Gegeben sei ein Array mit den Werten 3 9 7 4 1 8 5 2
  - a) Deklarieren und Initialisieren Sie ein solches Array.
  - b) Erzeugen Sie aus den Werten mithilfe des bisher Erlernten ein gleich großes Array, in dem die Werte sortiert sind.
  - c) Prüfen Sie mit Hilfe neuer Werte, ob Ihre Lösung auch für das veränderte Array funktioniert |
  - d) Prüfen Sie mit Hilfe eines Arrays mit mehr Werten, ob Ihre Lösung auch für das längere Array funktioniert
  - e) Benutzen Sie die do-while-Schleife, Zuweisungen und Vergleichsoperatoren. |
*/

// a)
int [][] arr = {{3, 9, 7, 4, 1, 8, 5, 2}, {111, 91, 72, 41, 11, 18, 5, 2}, {13, 91, 72, 41, 11, 18, 5, 200, -4, 0, -4}, {}};


int[] swap (int[] arr, int i, int j)
{
	int tmp = arr[j];
	arr[j] = arr[i];
	arr[i] = tmp;

	return arr; 
}

// b) Bubblesort:
int [] sort (int [] arr)
{
	int vergleiche = 0;
	int swaps = 0; 
	
	// for (int i=0; i < arr.length - 1; ++i)
	{
		int i = 0; 
		while (i < arr.length - 1)
		{
			// Vorschlag Ali: 
			// for (int j=i+1; j < arr.length - i; ++j)
			int j = i + 1;
			while (j < arr.length)
			// for (int j=i+1; ++j)
			{
				++vergleiche;
				if (arr[i] > arr[j])
				{
					arr = swap (arr, i, j); 
					++swaps; 
				}			
				++j; 
			}
			i++;
		}
	}
	println ("Vergleiche: " + vergleiche + "\tSwaps: " + swaps);
	return arr;
}

void showArray (int [] arr)
{
	print ("{");
	for (int i=0; i < arr.length; ++i)
	{
		print (arr[i] + ", ");
	}
	println ("\b\b}");
}

for (int arrindex = 0; arrindex < arr.length; ++arrindex) 
{
	showArray (arr[arrindex]);
	arr[arrindex] = sort (arr[arrindex]);
	showArray (arr[arrindex]);
}


