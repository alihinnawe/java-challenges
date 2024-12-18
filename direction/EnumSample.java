public enum JZ { FRUEHLING, SOMMER, HERBST, WINTER;
    public String toEng () {
       switch (this) {
         case FRUEHLING: return  "spring"; 
         case SOMMER: return "summer";
         case HERBST: return "fall"; 
         default: return "winter";
        }
    }
}
JZ jz2 = JZ.WINTER;
jz2.toEng ()
