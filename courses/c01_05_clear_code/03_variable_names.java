// Занятие 3. Имена переменных.
// Язык Java.

7.1
1) digit - isDigit // признак того, является ли символ цифрой
2) valid - isValid // признак корректности введенных данных
3) flag - isAscending // признак того, отсортирован ли массив по возрастанию
4) status - isActive // признак того, активен ли процесс
5) sorted - isSorted // признак того, отсортирован ли массив

7.2
1) flag - done // признак завершения цикла или операции
// Пример: 
boolean done = false;
while (!done) { ... done = true; }
2) result - found // признак того, найдено ли значение
// Пример: 
boolean found = false;
for (int i = 0; i < array.length; i++)
    if (array[i] == target) { found = true; break; }

7.3
// Проверил, в качестве индексов цикла использовал имена i, j, k.
// Случаи, когда вместо i, j, k нагляднее использовать более выразительные имена:
1) i - row, j - column // обход двумерного массива
// Пример: 
for (int row = 0; row < matrix.length; row++) {
    for (int column = 0; column < matrix[row].length; column++) { ... } }
2) i — charIndex // обход строки посимвольно
// Пример: 
for (int charIndex = 0; charIndex < text.length(); charIndex++) { ... }

7.4
1) firstIndex / lastIndex // индекс первого и последнего элемента
2) head / tail // head -- указатель на узел-голову списка, tail -- указатель на завершающий узел
3) prev / next // prev -- указатель на предыдущий элемент в списке, next -- указатель на следующий элемент

7.5
// Надо переименовать:
1) public int compare(T v1, T v2) { //  было
   public int compare(T left, T right) { // стало
2) temp - savedChar // временно сохраняет символ при обмене элементов

// Можно полностью избавиться:
// Проверка наличия элемента.
// Было:
boolean found = list.contains(value);
return found;
// Стало:
return list.contains(value);



