double tempWandeln (double temp, boolean isCelcius) {
    
    
    if (isCelcius) {
        return (5/9 * temp) - 32;
    }
      
    
    else {
        return 1.8 * (temp + 32);
    }
}
tempWandeln(44,true)
tempWandeln(44,false)