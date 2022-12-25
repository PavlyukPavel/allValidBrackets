import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    /*
    Найти валидные круглые скобки. Обязательно счетчик и правильные скобки нужно выводить.
    Пример 1:
                   Ввод: "(()"
                   Вывод: 2 - ()
    Пример 2:
                   Ввод: ")()())"
                   Вывод: 4 - ()()
    Пример 3:
                   Ввод: ")(()())"
                   Вывод: 6 - (()())
    Пример 4:
                   Ввод: ")("
                   Вывод: 0
    Пример 5:
                   Ввод: "())(()())(()"
                   Вывод: 10 - ()(()())()
    */

    public static void allValidBrackets(String sIn) {
        ArrayDeque<Integer> openBrackets = new ArrayDeque<>();
        StringBuilder sOut = new StringBuilder();
        int iFrom = -1;
        int iTo = -1;
        for (int i = 0; i < sIn.length(); i++) {
            if (sIn.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (sIn.charAt(i) == ')') {
                if (!openBrackets.isEmpty()) {
                    int iVal = openBrackets.pop();
                    if ((iFrom < 0) || (iVal < iFrom)) {
                        iFrom = iVal;
                    }
                    iTo = i;
                }
                if (iFrom >= 0 && openBrackets.isEmpty()) {
                    sOut.append(sIn, iFrom, iTo + 1);
                    iFrom = -1;
                    iTo = -1;
                }
            }
        }
        if (iFrom >= 0) {
            sOut.append(sIn, iFrom, iTo + 1);
        }
        if (sOut.length() > 0) {
            System.out.printf("%d - %s\n", sOut.length(), sOut);
        } else {
            System.out.println("0");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        allValidBrackets(s);
    }
}