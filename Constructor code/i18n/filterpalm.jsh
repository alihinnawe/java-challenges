import java.io.*;
import java.util.*;

void check (String muster, String ... worte) {
	println ("Muster: " + muster);
	for (String s : worte) 
	    println (s + "\t" + s.matches (muster));
}

void filter (String pattern) throws IOException {
     Scanner sc = new Scanner (new File ("./palmstroem.txt"));
     while (sc.hasNext ())
     {
         String line = sc.nextLine ();
         if (line.matches (pattern))
             println (line);
     }
}

void filterTn (String pattern) throws IOException {
     Scanner sc = new Scanner (new File ("./teilnehmer.txt"));
     while (sc.hasNext ())
     {
         String line = sc.nextLine ();
         if (line.matches (pattern))
             println (line);
     }
}
