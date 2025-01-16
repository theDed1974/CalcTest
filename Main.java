import java.util.Scanner;  //билиотека со сканером строк
public class Main {
    public static String calc(String strIn) {
        String[] strParts;
        try {
            // Разделяем строку на части по пробелам
            strParts = strIn.trim().split("\\s+");
            if (strParts.length != 3) {
                throw new Exception("//т.к. строка не является математической операцией");
            }

            int num1 = Integer.parseInt(strParts[0]);
            int num2 = Integer.parseInt(strParts[2]);

            // Проверяем, что числа находятся в диапазоне от 1 до 10
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new Exception("Числа должны быть от 1 до 10");
            }

            int result;
            switch (strParts[1]) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> result = num1 / num2;
                default -> throw new Exception("Неверный оператор. Доступные операторы: +, -, *, /");
            }

            return Integer.toString(result);
        } catch (Exception e) {
            return "Ошибка: " +e.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение вида: 1 + 2:");
        String strIn = scanner.nextLine();
        String result;
        try {
            result = calc(strIn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
}
