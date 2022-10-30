
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    static Scanner scan = new Scanner(System.in);
    static String[] arab = new String[]{"","1","2","3","4","5","6","7","8","9","10"};
    static String[] rome = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX","X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };
    static String[] numbers;
    static int a=0;
    static String fst="";
    static String prim=scan.next();
    static char[] operation = new char[10];

    public static void main (String[] args) {
        if(prim.length()<=5) {
            char oper = operationType();
            String fst = numbers();
            String scnd = numbers();

            String typeF = arabOrRome(fst);
            int fcnt = counter;
            String typeS = arabOrRome(scnd);
            int scnt = counter;

            if (typeF.equals(typeS)) {
                String allType = typeF;
                Calculation(oper, allType, fcnt, scnt);
            }
            else {
                System.out.println("используются одновременно разные системы счисления");
            }
        }
        else {
            System.out.println("Не больше двух операндов и одного оператора");

        }


    }

    public static void Calculation(char oper,String allType,int fcnt,int scnt){
        int result=0;
        switch (oper) {
            case '+':
                result=fcnt+scnt;
                break;
            case '-':
                if(scnt<fcnt||allType=="arab") {
                    result = fcnt - scnt;
                    break;
                }
                else
                {
                    System.out.println("в римской системе нет отрицательных чисел");
                    break;
                }
            case '*':
                result=fcnt*scnt;
                break;
            case '/':
                result=fcnt/scnt;
                break;
        }
        if(allType=="arab"){
            System.out.println(result);
        }
        else {
            System.out.println(rome[result]);
        }

    }




    public static char operationType(){

        char oper='h';
        for (int i = 0; i < prim.length(); i++) {
            operation[i] = prim.charAt(i);
            if (operation[i] == '+') {
                oper = '+';
            }
            if (operation[i] == '-') {
                oper = '-';
            }
            if (operation[i] == '*') {
                oper = '*';
            }
            if (operation[i] == '/') {
                oper = '/';
            }
        }
        if(oper=='h')
        {
            System.out.println("Неправильный тип операции,попробуйте снова");
            prim=scan.next();
            oper=operationType();
        }
        return oper;
    }


    public static String numbers(){
            numbers = prim.split("[+-/*]");
            fst = numbers[a];
            a += 1;
            return fst;
    }

    static int counter=0;
    public static String arabOrRome(String num){

        String type="";
        for(int i=1;i<=10;i++)
        {
            counter=i;
            if(num.equals(arab[i]))
            {
                type="arab";
              break;
            }
            if(num.equals(rome[i])){
                type="rome";
                break;
            }

        }

        if(type=="")
        {
            type="none";
        }
        return type;

    }

}

