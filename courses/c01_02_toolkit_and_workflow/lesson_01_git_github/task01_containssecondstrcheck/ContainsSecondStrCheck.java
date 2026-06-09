package c01_02_toolkit_and_workflow.lesson_01_git_github.task01_containssecondstrcheck;

/**
 * Напишите функцию с двумя параметрами-строками.
 * Функция возвращает булево значение true если вторая строка содержится в первой строке как подстрока,
 * и false в противном случае.
 * Например,
 * f("12345", "234") = true
 * f("12345", "235") = false
 * <p>
 * Для решения стандартные возможности Java вроде indexOf или equals использовать нельзя, только условиями и циклами.
 */

public class ContainsSecondStrCheck {
    static boolean containsSecondString(String s1, String s2) {
        int s1Length = s1.length(), s2Length = s2.length();

        for(int i = 0; i <= s1Length - s2Length; i++) {
            int j;
            for(j = 0; j < s2Length; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }

            if(j == s2Length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsSecondString("12345", "234"));
        System.out.println(containsSecondString("12345", "235"));
    }
}
