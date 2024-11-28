boolean feirabend (double jetzt, double fazeit) {
	if (jetzt < fazeit) {
		return false;
	}
	else {
		println ("fa"); 
		return true;
	}
}

boolean buffetTime (double jetzt, double buffetzeit) {
	if ( jetzt < buffetzeit) {
		return false;
	}
	else {
		println ("Buffetzeit"); 
		return true;
	}
}


String test (double jetzt, double feirabenzeit, double buffetzeit) {
	if (feirabend(jetzt,feirabenzeit) && buffetTime(jetzt,buffetzeit)) { 
		return "ende"; 
	}
	else if (feirabend(jetzt,feirabenzeit) || buffetTime(jetzt,buffetzeit)) {
		return "kein buffezeit"; 
	}
	else {
		println ("kombi"); 
		return "keep working";
	}
}
test(16,15,9);
test(14,16,9);
test(14,15,15);