import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ex1Main {
    public static void main(String[] args) {
        String s="",s2="";
        int value=0,value2=0,value3=0 , base1=0;
        String base="";
        Scanner consle = new Scanner(System.in);
        boolean check2 =true;
        while(!(Ex1.equals(s,"quit"))) {
            boolean check =true ,flag=false , flag2=false;

            while (flag!=check) {
                System.out.println("Ex1 class solution ");
                System.out.println("Enter a String as a number#1 or enter quit to end the program");
                s = consle.nextLine();
                if (s.equals("quit")) {
                    break;
                }
                flag = Ex1.isNumber(s);
                System.out.println("num1=" + s + " is number: " + flag + " , value:" + Ex1.number2Int(s));
            }while(flag2!=check) {
                System.out.println("Ex1 class solution ");
                System.out.println("Enter a String as a number#2 or enter quit to end the program");
                s2 = consle.nextLine();
                if (Ex1.equals(s2, "quit")) {
                    break;
                }
                flag2 = Ex1.isNumber(s2);
                System.out.println("num1=" + s2 + " is number: " + flag2 + " , value:" + Ex1.number2Int(s2));
            }
            while (check2) {
                System.out.println( " enter a base");

                base = consle.nextLine();
                if (base.matches("[A-G]")) { // אם הבסיס הוא אות
                    base1 = 10 + (base.charAt(0) - 'A'); // המרה מ-A ל-10, B ל-11 וכו'
                } else { // אם הבסיס הוא מספר
                    base1 = Integer.parseInt(base);
                }
                if (!(base1 >= 2&& base1 <= 16)) {
                    System.out.println("ERR: wrong base, should be [2,16], got " + base);
                } else {
                    check2 = false;
                }
            }

            String[] array= {String.valueOf(Ex1.number2Int(s)),String.valueOf(Ex1.number2Int(s2)),Ex1.add(s,s2,base1),(Ex1.multiply(s,s2,base1))};
            System.out.println(Ex1.number2Int(s)+"+"+ Ex1.number2Int(s2)+"="+Ex1.add(s,s2,base1));
            System.out.println(Ex1.number2Int(s)+"*"+ Ex1.number2Int(s2)+"="+Ex1.multiply(s,s2,base1));
            System.out.println("Max number over"+Arrays.toString(array)+" "+Ex1.int2Number(Ex1.maxIndex(array),base1));
        }

    }
}
