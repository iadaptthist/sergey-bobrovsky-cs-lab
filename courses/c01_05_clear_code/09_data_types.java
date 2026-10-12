// Занятие 9. Типы данных.
// Язык Java.

1) В класс LinkedList добавил логические переменные:
public boolean remove(int value) {
    if (this.head == null) {
        return false;
    }

    boolean isHeadMatch = (this.head.value == value); // добавил
    boolean isSingleElementList = (this.head.next == null); // добавил

    if (isHeadMatch && isSingleElementList) {
        this.head = null;
        this.tail = null;
        return true;
     }

     if (isHeadMatch) {
         this.head = this.head.next;
         return true;
      }
}

2) В классе Stack_2 заменил int на long:
Stack<Long> resultStack = new Stack<>();
if (element.equals("+")) {
    long a = resultStack.pop(); // было int
    long b = resultStack.pop(); // было int
    resultStack.push(a + b);
    continue;
}

3) В класс OrderedList добавил булевые переменные:
int compareResult = compare(current.value, value);

boolean isBeforeAsc = ascending && compareResult >= 0;
boolean isBeforeDesc = !ascending && compareResult <= 0;
boolean isBeforeNode = isBeforeAsc || isBeforeDesc;

if (isBeforeNode) {
    
}

4) В класс Queue_2 добавил проверку:
if (size() == 0) {
    return;
}

int steps = n % size();

5) В классе BloomFilter устранил скрытое переполнение типа int:
Было:
public int hash1(String str1) {
int result = 0;
for (int i = 0; i < str1.length(); i++) {
     int code = (int) str1.charAt(i);
     result = result * 17 + code;
}
return Math.floorMod(result, filter_len);
}

Стало:
public int hash1(String str1) {
long result = 0;
for (int i = 0; i < str1.length(); i++) {
     int code = str1.charAt(i);
     result = (result * 17 + code) % filter_len;
}
return (int)result;
}

6) В конструкторе класса CircularQueue добавил проверку на ноль:
if (capacity <= 0) {
    throw new IllegalArgumentException("Capacity must be greater than 0");
}

7) В классе DynArray_2 устранил неявное приведение вещественного к целому:
Было:
if (count * 2 < capacity) {
    makeArray((int)(capacity / 1.5));
}
Стало:
if (count * 2 < capacity) {
    makeArray(capacity * 2 / 3);
}

8) Добавил проверку на ноль:
if (minSalaryRub <= 0) {
    throw new IllegalArgumentException("Minimum salary must be greater than zero");
}
double ratioSalary = (double) maxSalaryRub / minSalaryRub;

9) В классе Stack_2 заменил int на long:
Stack<Long> resultStack = new Stack<>();
if (element.equals("*")) {
    long a = resultStack.pop(); // было int
    long b = resultStack.pop(); // было int
    resultStack.push(a * b);
    continue;
}

10) В класс OrderedList_2 добавил булевые переменные:
boolean isBeforeHeadAsc = ascending && compareHead >= 0;
boolean isBeforeHeadDesc = !ascending && compareHead <= 0;
boolean isBeforeHead = isBeforeHeadAsc || isBeforeHeadDesc;

if (isBeforeHead) {
    return false;
}

11) В классе OrderedList_2 устранил скрытое переполнение типа int:
Было:
int mid = (left + right) / 2;
Стало:
int mid = left + (right - left) / 2;

12) В конструктор класса HashTable_2 добавил проверки:
public HashTable_2(int sz, int stp) {
    if (sz <= 0) {
        throw new IllegalArgumentException("Hash table size must be greater than 0, got: " + sz);
    }
    if (stp <= 0) {
        throw new IllegalArgumentException("Hash step must be greater than 0, got: " + stp);
    }
    size = sz;
    step = stp;
}

