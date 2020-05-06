public String repeat(String s, int copy) {
    if(copy < 0) {
        throw new IllegalArgumentException();
    }
    
    if(copy==0) {
        return "";
    }else if(copy==1){
        return s;
    }
    
    return s + repeat(s, copy-1);
}
