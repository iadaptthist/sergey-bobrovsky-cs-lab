package c01_02_toolkit_and_workflow.lesson_10_workingwithfilesdirectories.task01_comment;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Comment {
    public static void main(String[] args) {
        // Создаем объект File, указывающий на текущий каталог.
        File root = new File(".");
        // Создаем динамический массив(список, размер которого может изменяться во время работы программы) с именем expand,
        // который будет хранить объекты File для обработки на текущем уровне вложенности
        ArrayList<File> expand = new ArrayList<File>();
        // Добавляем каталог как начальную точку обхода
        expand.add(root);

        // Цикл для обхода на 10 уровней глубины.
        // depth отслеживает текущий уровень вложенности (0 - корень, 1 - подкаталоги и т.д.)
        for(int depth = 0; depth < 10; depth++) {
            // Копируем текущее содержимое expand в обычный массив expandCopy.
            // Это необходимо, чтобы мы могли итерироваться по элементам текущего уровня,
            // одновременно заполняя expand элементами следующего уровня.
            File[] expandCopy = expand.toArray(new File[expand.size()]);
            // Очищаем expand, чтобы заполнить его каталогами следующего уровня. Это позволит на следующей итерации обходить уже каталоги текущего уровня
            expand.clear();
            // Проходим в цикле по всем элементам (файлам и каталогам) текущего уровня вложенности. Используем for-each цикл
            for (File file : expandCopy) {
                // Выводим текущий уровень глубины и путь к файлу/каталогу. depth показывает глубину вложенности.
                System.out.println(depth + " " + file);
                // Проверяем, является ли объект каталогом, а не обычным файлом.
                if (file.isDirectory()) {
                    // Если это каталог, получаем все файлы и подкаталоги в текущем каталоге.
                    // file.listFiles() возвращает массив всех элементов каталога.
                    // Arrays.asList() преобразует массив в список.
                    // addAll() добавляет все элементы в expand для следующей итерации.
                    expand.addAll(Arrays.asList(file.listFiles()));
                }
            }
        }
    }
}
