/**
Gegeben sei ein Array mit den Werten 3 9 7 4 1 8 5 2
  - a) Deklarieren und Initialisieren Sie ein solches Array.
  - b) Erzeugen Sie aus den Werten mithilfe des bisher Erlernten ein gleich großes Array, in dem die Werte sortiert sind.
  - c) Prüfen Sie mit Hilfe neuer Werte, ob Ihre Lösung auch für das veränderte Array funktioniert |
  - d) Prüfen Sie mit Hilfe eines Arrays mit mehr Werten, ob Ihre Lösung auch für das längere Array funktioniert
  - e) Benutzen Sie die do-while-Schleife, Zuweisungen und Vergleichsoperatoren. |
*/

// a)
int [] arr1 = {3, 9, 7, 4, 1, 8, 5, 2};

// b) Bubblesort:
int [] sort (int [] arr)
{
	for (int i=0; i < arr.length - 1; ++i)
	{
		for (int j=i+1; j < arr.length; ++j)
		{
			if (arr[i] > arr[j])
			{
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}
	}
	return arr;
}

void showArray (int [] arr)
{
	print ("{");
	for (int i=0; i < arr.length - 1; ++i)
	{
		print (arr[i] + ", ");
	}
	println ("\b\b\b}");
}

showArray (arr1);
arr1 = sort (arr1);
showArray (arr1);

// c)
int [] arr2 = {13, 91, 72, 41, 11, 18, 5, 200};

showArray (arr2);
arr2 = sort (arr2);
showArray (arr2);

// d)
int [] arr3 = {13, 91, 72, 41, 11, 18, 5, 200, -4, 0, -4};

showArray (arr3);
arr3 = sort (arr3);
showArray (arr3);


