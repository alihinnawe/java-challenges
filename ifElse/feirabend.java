boolean feirabend (double jetzt, double fazeit) {
	if (jetzt > fazeit) {
		return true;
	}
	else {
		println ("kein fa"); 
		return false;
	}
}

boolean buffetTime (double jetzt, double buffetzeit) {
	if (buffetzeit < jetzt) {
		return true;
	}
	else {
		println ("keine Buffetzeit"); 
		return false;
	}
}

// if (feirabend(1,2) && buffetTime(2,3)) {
// if (feirabend(9,16) && buffetTime(9,12)) { 
if (feirabend(16,15) && buffetTime(16,12)) {
	System.out.println("ende");
} else {
	println ("kombi"); 
	System.out.println("keep working");
}
