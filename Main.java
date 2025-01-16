import java.util.Objects;
import java.util.Scanner;  //билиотека со сканером строк

public class Main {
   public static void main (String[] args) throws Exception {
       //while(true) {
           Scanner str = new Scanner(System.in);//получаем строку от пользователя из терминала
           System.out.println("Введите арифметическое выражение вида: 1 + 2:");
           String strIn = str.nextLine();

           String[] strPath = strIn.split(" ");
           if (!(strPath.length == 3)) throw new Exception("введите 2 числа и оператор с пробелами между ними");
           int num1, num2;
           try {
               num1 = Integer.parseInt(strPath[0]);
               num2 = Integer.parseInt(strPath[2]);
           } catch (Exception e) {
               throw new Exception("необходимо ввести числа");
           }
           if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) throw new Exception("введите числа от 1 до 10");

           if (!(Objects.equals(strPath[1], "+")) && !(Objects.equals(strPath[1], "-")) && !(Objects.equals(strPath[1], "*")) && !(Objects.equals(strPath[1], "/")))
               throw new Exception();
           int result = -100;
           switch (strPath[1]) {
               case "+":
                   result = num1 + num2;
                   break;
               case "-":
                   result = num1 - num2;
                   break;
               case "*":
                   result = num1 * num2;
                   break;
               case "/":
                   result = num1 / num2;
                   break;
               default:
                   System.out.println("что то пошло не так...");
           }

           System.out.println(result);
       //}
    }
}