//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Boolean result;
        String s ="kayak";

        s=s.toLowerCase(); //turns to lowercase

        for(int i =0;i<s.length(); i++) {
        if(s.charAt(i)>='0' && s.charAt(i)<='9'||s.charAt(i)>='a' && s.charAt(i) <='z'){
        } // using ASCII to figure out non-alphanumeric characters
        else {
            if(i==0) {
                s=s.substring(i+1);
            }
            else {
                s= s.substring(0,i)+s.substring(i+1);
            }
          }
        }
        String reversed = s;
        new StringBuilder(reversed).reverse().toString(); // reverses the string.

       if (reversed == s) {
           System.out.println(true);
       } else {
           System.out.println(false);
       }

    }
}
