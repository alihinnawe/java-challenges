
import java.util.Arrays;
int [] arr1 = {3, 9, 7, 4, 1, 8, 5, 2};


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
				System.out.println(Arrays.toString(arr1));
			}
		}
	}
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

showArray (arr1);
arr1 = sort (arr1);
showArray (arr1);


int [] arr2 = {13, 91, 72, 41, 11, 18, 5, 200};

showArray (arr2);
arr2 = sort (arr2);
showArray (arr2);


int [] arr3 = {13, 91, 72, 41, 11, 18, 5, 200, -4, 0, -4};

showArray (arr3);
arr3 = sort (arr3);
showArray (arr3);


