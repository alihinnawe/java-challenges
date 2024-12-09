class Bruch {
    private int nenner;
    private int zaeler;

    public Bruch(int nenner, int zaeler) {
        this.nenner = nenner;
        this.zaeler = zaeler;
    }

    public Bruch(int nenner) {
        this.nenner = nenner;
        this.zaeler = 1;
    }

    public Bruch mul(Bruch multiplication) {
        int newZaeler = this.zaeler * multiplication.zaeler;
        int newNenner = this.nenner * multiplication.nenner;
        return new Bruch(newNenner, newZaeler);
    }

    public void print() {
        System.out.println(this.zaeler + "/" + this.nenner);
    }
}

public class Main {
    public static void main(String[] args) {
        Bruch br1 = new Bruch(2, 3);
        Bruch br2 = new Bruch(4, 5);
        Bruch result = br1.mul(br2);
        result.print();
    }
}
