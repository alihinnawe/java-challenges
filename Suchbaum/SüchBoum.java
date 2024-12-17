import java.util.Random;

class SüchBoum {

    private int wert;
    private SüchBoum l = null;
    private SüchBoum r = null;

    public SüchBoum(int i) {
        wert = i;
    }

    public boolean add(int i) {
        if (i < wert) {
            if (l == null) {
                l = new SüchBoum(i);
                return true;
            } else {
                return l.add(i);
            }
        } else if (i > wert) {
            if (r == null) {
                r = new SüchBoum(i);
                return true;
            } else {
                return r.add(i);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String left = (l == null) ? "null" : l.toString();
        String right = (r == null) ? "null" : r.toString();
        return "Node(" + wert + ", L:" + left + ", R:" + right + ")";
    }
    
     public static void main(String[] args) {
        Random rr = new Random();
        SüchBoum root = new SüchBoum(rr.nextInt(200) + 1);
        for (int i = 0; i < 100; i++) {
            root.add(rr.nextInt(200) + 1);
        }
        System.out.println(root);
    }
}


   

