package String;

public class MinimumRemoveToMakeValidParenthesis {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        // Output: "ab(c)d"
        System.out.println(minRemoveToMakeValid(s));
        System.out.println(minRemoveToMakeValid2(s));
    }

    public static String minRemoveToMakeValid2(String s) {
        char []ch = s.toCharArray();

        int count = 0 ;

        // take a look from left to right

        for (int i = 0 ; i < ch.length ; i++){
            if (ch[i] == '('){
                count++;
            }else if (ch[i] == ')'){
                if (count >0){
                    count--;
                }
                else {
                    ch[i] = 0;
                }
            }
        }
        count = 0;

        for (int i = ch.length-1 ; i >= 0 ; i--){
            if (ch[i] == ')'){
                count++;
            }else if (ch[i] == '('){
                if (count >0){
                    count--;
                }
                else {
                    ch[i] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : ch){
            if (c != 0){
                sb.append(c);
            }
        }

        return sb.toString();

    }







    public static String minRemoveToMakeValid(String s) {
        char[] ch=s.toCharArray();

        //left to right
        //)---> (
        int count=0;

        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                count++;
            }
            else if(ch[i]==')'){
                if(count>0){
                    count--;
                }
                else{
                    ch[i]=0;
                }
            }
        }

        //right->left
        // ( ----> )
        count=0;
        for(int i=ch.length-1;i>=0;i--){
            if(ch[i]==')'){
                count++;
            }
            else if(ch[i]=='('){
                if(count>0){
                    count--;
                }
                else{
                    ch[i]=0;
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(char c:ch){
            if(c!=0){
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
