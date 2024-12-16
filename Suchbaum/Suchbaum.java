import java.util.Random;

class Suchbaum {
    private Suchbaum root; 

    private class Intlist {
        int value;
        Intlist l, r, next;

        public Intlist(int value) {
            this.value = value;
            this.l = null;
            this.r = null;
            this.next = null;
        }
    }

    private Intlist rootNode;

    public Suchbaum() {
        rootNode = null;
    }

    public boolean add(int number) {
        if (rootNode == null) {
            rootNode = new Intlist(number);
            return true;
        } else {
            return addRecursive(rootNode, number);
        }
    }

    private boolean addRecursive(Intlist current, int number) {
        if (number < current.value) {
            if (current.l == null) {
                current.l = new Intlist(number);
                return true;
            } else {
                return addRecursive(current.l, number);
            }
        } else if (number > current.value) {
            if (current.r == null) {
                current.r = new Intlist(number);
                return true;
            } else {
                return addRecursive(current.r, number);
            }
        }
        return false;
    }

    public void generateAndAddRandomNumbers() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100);
            System.out.println("Adding number: " + randomNumber);
            add(randomNumber);
        }
    }

    public void printInOrder() {
        printInOrderRecursive(rootNode);
    }

    private void printInOrderRecursive(Intlist node) {
        if (node != null) {
            printInOrderRecursive(node.l);
            System.out.print(node.value + " ");
            printInOrderRecursive(node.r);
        }
    }

    public static void main(String[] args) {
        Suchbaum suchbaum = new Suchbaum();
        suchbaum.generateAndAddRandomNumbers();
        System.out.println("In-order traversal of the search tree:");
        suchbaum.printInOrder();
    }
}
