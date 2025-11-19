public class check_Valid_String {

    public boolean checkValidString(String s) {
        int n = s.length();
        int maxOpen = 0;
        int minOpen = 0;

        for(char ch : s.toCharArray()){
            if(ch=='('){
                maxOpen++;
                minOpen++;
            }else if(ch==')'){
                maxOpen--;
                minOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }
            if(maxOpen<0){
                return false;
            }
            if(minOpen<0){
                minOpen = 0;
            }
        }

        return minOpen==0;
    }
}
