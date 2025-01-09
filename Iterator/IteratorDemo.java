import java.util.Iterator;

class MyCollection implements Iterable<String> {
    private String[] items;
    private int size;

    public MyCollection(String[] items) {
        this.items = items;
        this.size = items.length;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public String next() {
            return items[index++];
        }
    }
}

public class IteratorDemo {
    public static void main(String[] args) {
        String[] data = { "Apple", "Banana", "Cherry", "Date" };
        MyCollection collection = new MyCollection(data);

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String item : collection) {
            System.out.println(item);
        }
    }
}
