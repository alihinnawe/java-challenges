import java.util.*;

public class CollatzSequence implements Iterator<Integer> {
    private int number;

    public CollatzSequence(int number) {
        this.number = number;
    }

    public Integer next() {
        int newNumber = number;
        number = ((number % 2) == 0) ? number / 2 : 3 * number + 1;
        return newNumber;
    }

	public boolean hasNext() {
		if (number != 1) {
			return true;
		} else {
			return false;
		}
	}

    public static void main(String[] args) {
        int startNumber = 6;
        CollatzSequence collatz = new CollatzSequence(startNumber);

        Iterable<Integer> iterable = new CollatzIterable(collatz);

        for (int num : iterable) {
            System.out.print(num + " ");
        }
    }
}

class CollatzIterable implements Iterable<Integer> {
    private final CollatzSequence collatzSequence;

    public CollatzIterable(CollatzSequence collatzSequence) {
        this.collatzSequence = collatzSequence;
    }

    public Iterator<Integer> iterator() {
        return collatzSequence;
    }
}
