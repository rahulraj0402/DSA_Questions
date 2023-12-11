package String;

public class defanginganIpAddressLeetCode1108 {


    public static void main(String[] args) {
        String string = "1.1.1.1.1";
        System.out.println(defangIPaddr(string));
    }
    public static String defangIPaddr(String address) {
        int n = address.length();
        String res = "" ;

        for(int i = 0 ; i < n ; i++){
            char ch = address.charAt(i);

            if(ch!='.'){
                res=res+ch;
            }else{
                res=res+"[.]";
            }
        }
        return res;
    }
}
