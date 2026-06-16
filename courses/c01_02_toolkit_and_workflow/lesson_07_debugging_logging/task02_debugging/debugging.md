# Отладка в IntelliJ IDEA.

## 1. Установка точки прерывания.
Установил точку прерывания на строке 16(отмечена красным кружком).

![Breakpoint](screenshots/debugging_1.png)

## 2. Запуск в режиме отладки.
Нажал **Shift + F9** — программа остановилась на точке прерывания. Строка подсвечена синим.

![Debug Start](screenshots/debugging_2.png)

## 3. Пошаговое выполнение.
Нажал несколько раз **F8** (Step Over) — курсор перешел на следующие строки.
![Step Over](screenshots/debugging_3.png)

## 4. Изменил условие цикла.
Изменил условие цикла, чтобы спровоцировать ошибку.

![Step Into](screenshots/debugging_4.png)

## 5. Assert сработал.
Assert перехватил выход за границы.
![Assertion Error](screenshots/debugging_result.png)

