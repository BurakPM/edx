public void pigLatin(Scanner file) {
    String pigified = "";
    
    while(file.hasNextLine()) {
        String line = file.nextLine();
        String lowerCase = line.toLowerCase();
        Scanner sc = new Scanner(lowerCase);
        while(sc.hasNext()) {
            String token = sc.next();
            if(token.startsWith("a") || token.startsWith("e") || token.startsWith("i") ||
               token.startsWith("o") || token.startsWith("u")) {
                token += "yay";
            }else{
                String firstLetter = token.substring(0,1);
                pigified = token.substring(1, token.length());
                token = pigified + firstLetter + "ay";
                
            }
            System.out.print(token +  " ");
        }
     System.out.println();   
    }
}
