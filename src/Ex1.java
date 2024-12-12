import java.util.ArrayList;

public class Ex1 {

    public static boolean isNumber(String s) {
        char[] charsToCheck = {'A', 'B', 'C' , 'D', 'F' ,'G'}; // התווים לבדיקה
        char[] inNumberPart = new char[6];
        if ( s== null || s.isEmpty())
            return false;
        String regex = "^-?\\d+$";
        if (s.matches(regex)){
            return true;
        }
//        if (!(s.indexOf(ch) != -1)) {
//            if (s.matches("[A-G]")) { // אם הבסיס הוא אות
//               return  true;}}

        // פיצול הקלט לפי "b"
        String[] parts = s.split("b");
        if (parts.length != 2) return false; // חייבת להיות בדיוק "b" אחת

        String numberPart = parts[0]; // חלק המספר
        String basePart = parts[1];   // חלק הבסיס
if ((!parts[0].matches("^[0-9A-G]+$"))||(equals(parts[0],parts[1]))){
    return false;
}

        // בדיקה אם הבסיס הוא אות A-F או מספר 2-16
        int base;
        try {
            if (basePart.matches("[A-G]")) { // אם הבסיס הוא אות
                base = 10 + (basePart.charAt(0) - 'A'); // המרה מ-A ל-10, B ל-11 וכו'
                for (int i=0; i< charsToCheck.length; i++){
                    if(numberPart.indexOf(charsToCheck[i])!=-1){
                        inNumberPart[i]=charsToCheck[i];
                    }
                }
                for (int i=0; i< charsToCheck.length; i++){
                    if(basePart.indexOf(inNumberPart[i])!=-1){
                        return false;
                    }
                }
            } else { // אם הבסיס הוא מספר
                base = Integer.parseInt(basePart);
            }
            // הבסיס חייב להיות בטווח 2-16
            if (base < 2 || base > 16) return false;
        } catch (NumberFormatException e) {
            return false; // הבסיס לא תקין
        }
        return true;

        // בדיקת תקינות המספר
//        try {
//            // המרת המספר לערך עשרוני לפי הבסיס
//            int number = Integer.parseInt(numberPart, base);
//            // בדיקה אם המספר גדול או שווה ל-16
//            return ;
//        } catch (NumberFormatException e) {
//            return false; // המספר לא תקין עבור הבסיס
//        }
    }




//    public static boolean isDecimalNumber(String s) {
//        if ( s== null || s.isEmpty()) return false;
//
//        String regex = "^-?\\d+$";
//        return s.matches(regex);
//    }

    public static int number2Int(String s ) {
        int value=0 , temp = 0 ,temp2=0 , ans=0;
        char ch = 'b';
        if(!isNumber(s)){
             return  ans=-1;
        }
        if (!(s.indexOf(ch) != -1)) {
            if (s.matches("[A-G]")) { // אם הבסיס הוא אות
                ans = 10 + (s.charAt(0) - 'A'); // המרה מ-A ל-10, B ל-11 וכו'
                return ans;

        } else {
                return ans = Integer.parseInt(s);
            }}


        String[] parts = s.split("b");
        String numberPart = parts[0]; // חלק המספר
        String basePart = parts[1];   // חלק הבסיס
        int base;
        if (basePart.matches("[A-G]")) { // אם הבסיס הוא אות
            base = 10 + (basePart.charAt(0) - 'A'); // המרה מ-A ל-10, B ל-11 וכו'
        } else { // אם הבסיס הוא מספר
            base = Integer.parseInt(basePart);
        }
        ans= Integer.parseInt(numberPart, base);
  ; //char [] digits = parts[0].toCharArray();

//        for ( int i =0 ;i< digits.length; i++){
//            if (String.valueOf(digits[i]).matches("[A-F]")) { // אם הבסיס הוא אות
//                temp += ((10 + (basePart.charAt(0) - 'A'))+temp*10); // המרה מ-A ל-10, B ל-11 וכו'
//            } else { // אם הבסיס הוא מספר
//                temp += (Integer.parseInt(String.valueOf(digits[i]))+temp*10);
//            }
//        }
        return ans;





    }
public static String add(String s, String s2, int base1){
    int sum = 0;
    sum = number2Int(s) + number2Int(s2);
    String sum2= int2Number(sum,base1);
    return sum2;
}
public static String multiply(String s, String s2,int base1) {
        int mult = 0;
        mult = number2Int(s) * number2Int(s2);
         String mult2= int2Number(mult,base1);
        return mult2;
    }
public static int maxIndex(String[] arr) {
    int ans = 0;
    for(int i =0; i< arr.length; i++){
        ans=Math.max(ans,number2Int(arr[i]));
    }

    return ans;
}
//    public static String int2Number(int number, int base){
//        String ans="";
//
//        StringBuilder result = new StringBuilder();
//        int quotient = number;
//        while (quotient > 0) {
//            int remainder = quotient % base;
//            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
//            result.insert(0, digit);
//            quotient /= base;
//        }
//        ans= result.toString();
//        if(number<0||base<2||base>16){
//            ans="";}
//
//
//        return ans=ans+"b"+base;
//
//    }
public static String int2Number(int number, int base) {
    // בדיקת תוקף הקלט
    if (number < 0 || base < 2 || base > 16) {
        return ""; // קלט לא תקין
    }

    // טיפול במקרה של 0
    if (number == 0) {
        return "0b" + base;
    }

    StringBuilder result = new StringBuilder();
    int quotient = number;

    // ביצוע ההמרה
    while (quotient > 0) {
        int remainder = quotient % base;
        char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
        result.insert(0, digit); // מוסיפים את הספרה לתוצאה
        quotient /= base;
    }

    // הוספת הבסיס לפורמט הסופי
    return result.toString() + "b" + base;
}

    public static boolean equals (String a, String b) {
        if(a==null||b==null){
            return false;
        }
        if(isNumber(a)&&isNumber(b)){
            int c=number2Int(a),d=number2Int(b);
            if(c==d){
                return  true;
            }
            else{ return false;
            }
        }
        boolean ans = true;
        if(a.length() != b.length()){
            ans = false;
            return ans;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                ans = false;
        }
        return ans;
    }


}

