boolean feirabend (double value1, double value2) {
	if (value1 > value2) {
		return true;
	}
	else {
		return false;
	}
}


boolean buffetTime (double value2, double value3) {


	if (value2 < value3) {
		return true;
	}
	else {
		return false;
	}
}

if (feirabend(1,2) && buffetTime(2,3)) {
	System.out.println("ende");
} 

else {
	System.out.println("keep working");
}