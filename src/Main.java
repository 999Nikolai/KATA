      import java.util.Scanner;
      import static java.lang.System.*;
    public class Main {
        static int number1;
        static int number2;
        static int rezult;
        static String Output;
        static String num1;
        static String num2;
        static String operator;
        public static void main(String[] args) throws Exception {
            out.println("Input:");


            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String[] token = input.split(" ");                                    // Разбил на токины по пробелу
            if (input.isBlank())   {out.println("Введите выражение");return;}          // Проверка на пустую строку
            else if (token.length != 3)                                                // Проверка на три токина
            {out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) разделеные_пробелом_");}

            num1 = token[0];
            num2 = token[2];
            operator = token[1];

            calc(input);
            out.println("Output:");
            out.println(calc(input));
        }
        public static String calc(String input) throws Exception {

            String Arab = "1,2,3,4,5,6,7,8,9,10";
            String Roman = "I,II,III,IV,V,VI,VII,VIII,IX,X";

            if (Arab.contains(num1) && Arab.contains(num2)) {
                number1 = Integer.parseInt(num1);
                number2 = Integer.parseInt(num2);
            } else if (Roman.contains(num1) && Roman.contains(num2)) {
                number1 = romanToInt(num1);
                number2 = romanToInt(num2);
            }else return "Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.";


            if (operator.contains("+")) {
                rezult = number1 + number2;
            } else if (operator.contains("-")) {
                rezult = number1 - number2;
            } else if (operator.contains("*")) {
                rezult = number1 * number2;
            } else if (operator.contains("/")) {
                rezult = number1 / number2;
            } else return "Некорректный знак действия (+, -, /, *)";


            if (Arab.contains(num1) && Arab.contains(num2)) {
                Output = String.valueOf(rezult);
            } else if (Roman.contains(num1) && Roman.contains(num2)) {
                Output = intToRoman(rezult);
            }
            return Output;
        }
        static int getArabian(char roman){
            if('I' == roman) return 1;
            else if('V' == roman) return 5;
            else if('X' == roman) return 10;
            return 0;
        }
        static int romanToInt(String s) {
            int end = s.length()-1;
            char[] arr = s.toCharArray();
            int arabian;
            int result = getArabian(arr[end]);
            for (int i = end-1; i >=0; i--) {
                arabian = getArabian(arr[i]);

                if (arabian < getArabian(arr[i + 1])) {
                    result -= arabian;
                } else {
                    result += arabian;
                }
            }return result;
        }
        static String getArabian(int roman) {

            if (100 <= roman) return "C";
            else if (90 <= roman) return "XC";
            else if (50 <= roman) return "L";
            else if (40 <= roman) return "XL";
            else if (10 <= roman) return "X";
            else if (9 <= roman) return "IX";
            else if (5 <= roman) return "V";
            else if (4 <= roman) return "IV";
            else if (1 <= roman) return "I";
            return  "В римской системе нет 0 и отрицательных чисел";
        }
        static int Arabian(int roman) {
            if (100 <= roman) return 100;
            else if (90 <= roman) return 90;
            else if (50 <= roman) return 50;
            else if (40 <= roman) return 40;
            else if (10 <= roman) return 10;
            else if (9 <= roman) return 9;
            else if (5 <= roman) return 5;
            else if (4 <= roman) return 4;
            else if (1 <= roman) return 1;
            return 0;
        }

        public static String intToRoman(int number)
        {

            String roman = "";
            int arabianKey;
            do {
                arabianKey = Arabian(number);
                roman += getArabian(arabianKey);
                number -= arabianKey;
            }
            while (number > 0);

            return roman;
        }
    }