// Занятие 11. Время жизни переменных.
// Язык Java.

1) // Переменную current перенес в заголовок for.
// Было:
public ArrayList<Node> findAll(int _value) {
    ArrayList<Node> nodes = new ArrayList<Node>();
    Node current = this.head;
    while (current != null) {
           if (current.value == _value) {
               nodes.add(current);
            }
    current = current.next;
    }
return nodes;
}
// Стало:
public ArrayList<Node> findAll(int _value) {
    ArrayList<Node> nodes = new ArrayList<Node>();
    for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.next) {
        if (currentNode.value == _value) {
            nodes.add(currentNode);
        }
    }
    return nodes;
}

2) // Переменную current перенес в заголовок цикла for.
// Было:
public int count() {
    int count = 0;
    Node current = this.head;
    while (current != null) {
           count++;
           current = current.next;
    }
return count;
}
// Стало:
public int count() {
    int count = 0;
    for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.next) {
        count++;
    }
    return count;
}

3) // Переменные node1, node2 перенес в заголовок цикла for.
// Было:
public static LinkedList sumOfTwo(LinkedList list1, LinkedList list2) {
    LinkedList result = new LinkedList();
    if (list1.count() != list2.count()) {
        return result;
    }
    Node node1 = list1.head;
    Node node2 = list2.head;
    while (node1 != null) {
           result.addInTail(new Node(node1.value + node2.value));
           node1 = node1.next;
           node2 = node2.next;
    }
return result;
}
// Стало:
public static LinkedList sumOfTwo(LinkedList list1, LinkedList list2) {
    LinkedList result = new LinkedList();
    if (list1.count() != list2.count()) {
        return result;
    }
    for (Node n1 = list1.head, n2 = list2.head; n1 != null; n1 = n1.next, n2 = n2.next) {
        result.addInTail(new Node(n1.value + n2.value));
    }
    return result;
}

4) // Объявление переменной oldHead перенес ближе к месту использования.
// Было:
public void reverse() {
    Node oldHead = head;
    for (Node node = head; node != null; ) {
         Node nextNode = node.next;
         node.next = node.prev;
         node.prev = nextNode;
         node = nextNode;
    }
head = tail;
tail = oldHead;
}
// Стало:
public void reverse() {
    for (Node node = head; node != null; ) {
        Node nextNode = node.next;
        node.next = node.prev;
        node.prev = nextNode;
        node = nextNode;
    }
    Node oldHead = head;
    head = tail;
    tail = oldHead;
}

5) // Переменную steps перенес в заголовок цикла for.
// Было:
public void rotate(int n) {
     if (size() <= 1) {
         return;
     }
     if (n <= 0) {
         return;
     }
     int steps = n % size();
     if (steps == 0) {
         return;
     }
     for (int i = 0; i < steps; i++) {
          enqueue(dequeue());
     }
}
// Стало:
public void rotate(int n) {
    if (size() <= 1 || n <= 0) {
        return;
    }
    for (int i = 0, steps = n % size(); i < steps; i++) {
        enqueue(dequeue());
    }
}

6) // Выделил часть кода в отдельные методы.
// Было:
public void put(String key, T value) {
    int index = hashFun(key);
    for (int i = 0; i < size; i++) {
         int currentIndex = (index + i) % size;
         if (slots[currentIndex] != null && slots[currentIndex].equals(key)) {
             values[currentIndex] = value;
             return;
         }
    }
    for (int i = 0; i < size; i++) {
         int currentIndex = (index + i) % size;
         if (slots[currentIndex] == null) {
             slots[currentIndex] = key;
             values[currentIndex] = value;
             return;
         }
     }
     throw new IllegalStateException("Dictionary is full, cannot add key: " + key);
}
// Стало:
public void put(String key, T value) {
    int existingIndex = findKeyIndex(key);
    if (existingIndex != -1) {
        values[existingIndex] = value;
        return;
    }
    int emptySlotIndex = findEmptySlot(key);
    if (emptySlotIndex != -1) {
        slots[emptySlotIndex] = key;
        values[emptySlotIndex] = value;
        return;
    }
    throw new IllegalStateException("Dictionary is full, cannot add key: " + key);
}

private int findKeyIndex(String key) {
    int startIndex = hashFun(key);
    for (int i = 0; i < size; i++) {
        int current = (startIndex + i) % size;
        if (slots[current] != null && slots[current].equals(key)) {
            return current;
        }
    }
    return -1;
}

private int findEmptySlot(String key) {
    int startIndex = hashFun(key);
    for (int i = 0; i < size; i++) {
        int current = (startIndex + i) % size;
        if (slots[current] == null) return current;
    }
    return -1;
}

7) // Сгруппировал условия, перенес переменную.
// Было:
public boolean remove(String value) {
    int h = hash(value);
    if (value == null) return false;
    if (slots[h] == null) {
        return false;
    }
    boolean removed = slots[h].remove(value);
    if (!removed) {
        return false;
    }
    count--;
    return true;
}
// Стало:
public boolean remove(String value) {
    if (value == null || count == 0) {
        return false;
    }
    int h = hash(value);
    if (slots[h] == null || !slots[h].remove(value)) {
        return false;
    }
    count--;
    return true;
}

8) // Выделил часть кода в отдельные методы.
// Было:
public void put(String key, T value) {
    int index = hashFun(key);
    for (int i = 0; i < size; i++) {
         int currentIndex = (index + i) % size;
         if (slots[currentIndex] != null && slots[currentIndex].equals(key)) {
             values[currentIndex] = value;
             hits[currentIndex]++;
             return;
         }
     }
     for (int i = 0; i < size; i++) {
          int currentIndex = (index + i) % size;
          if (slots[currentIndex] == null) {
              slots[currentIndex] = key;
              values[currentIndex] = value;
              hits[currentIndex] = 0;
              return;
          }
      }
      int minHits = hits[0];
      int minIndex = 0;
      for (int i = 1; i < size; i++) {
           if (hits[i] < minHits) {
               minHits = hits[i];
               minIndex = i;
           }
       }
       slots[minIndex] = null;
       values[minIndex] = null;
       hits[minIndex] = 0;
       for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] == null) {
                slots[currentIndex] = key;
                values[currentIndex] = value;
                hits[currentIndex] = 0;
                return;
            }
       }
}
// Стало:
public void put(String key, T value) {
    int existingIndex = findKeyIndex(key);
    if (existingIndex != -1) {
        values[existingIndex] = value;
        hits[existingIndex]++; 
        return;
    }
    int slotIndex = findEmptySlot(key); 
    if (slotIndex == -1) {
        slotIndex = findLeastUsedIndex();
        clearSlot(slotIndex);
    }
    slots[slotIndex] = key;
    values[slotIndex] = value;
    hits[slotIndex] = 0; 
}

private int findKeyIndex(String key) {
    int startIndex = hashFun(key);
    for (int i = 0; i < size; i++) {
        int current = (startIndex + i) % size;

        if (slots[current] != null && slots[current].equals(key)) {
            return current;
        }
    }
    return -1;
}

private int findEmptySlot(String key) {
    int startIndex = hashFun(key);
    for (int i = 0; i < size; i++) {
        int current = (startIndex + i) % size;
        if (slots[current] == null) {
            return current;
        }
    }
    return -1;
}

private int findLeastUsedIndex() {
    int minIndex = 0;
    for (int i = 1; i < size; i++) {
        if (hits[i] < hits[minIndex]) {
            minIndex = i;
        }
    }
    return minIndex;
}

private void clearSlot(int index) {
    slots[index] = null;
    values[index] = null;
    hits[index] = 0;
}

9) // Поля класса PowerSet из public в private.
class PowerSet {
    private int capacity;
    private List<String>[] slots;
    private int count;
}

10) // Часть кода выделил в отдельный метод.
// Было:
public void removeAll(int _value) {
    for (Node node = head; node != null; ) {
         Node nextNode = node.next;
         if (node.value != _value) {
             node = nextNode;
             continue;
         }
         if (node.prev != null) {
             node.prev.next = node.next;
         }
         if (node.prev == null) {
             head = node.next;
         }
         if (node.next != null) {
             node.next.prev = node.prev;
         }
         if (node.next == null) {
             tail = node.prev;
         }
         node.next = null;
         node.prev = null;
         node = nextNode;
    }
}
// Стало:
public void removeAll(int value) {
    for (Node node = head; node != null; ) {
        Node nextNode = node.next;
        if (node.value == value) {
            removeNode(node);
        }
        node = nextNode;
    }
}

private void removeNode(Node node) {
    if (node.prev != null) {
        node.prev.next = node.next;
    }
    if (node.prev == null) {
        head = node.next;
    }
    if (node.next != null) {
        node.next.prev = node.prev;
    }
    if (node.next == null) {
        tail = node.prev;
    }
    node.next = null;
    node.prev = null;
}

11) // Выделилил повторяющийся код в отдельный метод.
// Было:
public static LinkedList2 sortAndMergeLists(LinkedList2 firstList, LinkedList2 secondList) {
    LinkedList2 firstListCopy = new LinkedList2();
    Node startFirstList = null;
    if (firstList != null) {
        startFirstList = firstList.head;
    }
    for (Node current = startFirstList; current != null; current = current.next) {
         firstListCopy.addInTail(new Node(current.value));
    }
    LinkedList2 secondListCopy = new LinkedList2();
    Node startSecondList = null;
    if (secondList != null) {
        startSecondList = secondList.head;
    }
    for (Node current = startSecondList; current != null; current = current.next) {
         secondListCopy.addInTail(new Node(current.value));
    }
    if (firstListCopy.head != null) {
        firstListCopy.sortInAscendingOrder();
    }
    if (secondListCopy.head != null) {
        secondListCopy.sortInAscendingOrder();
    }
    LinkedList2 result = new LinkedList2();
    Node nodeFromFirstList = firstListCopy.head;
    Node nodeFromSecondList = secondListCopy.head;
    for (; nodeFromFirstList != null && nodeFromSecondList != null; ) {
         if (nodeFromFirstList.value <= nodeFromSecondList.value) {
             result.addInTail(new Node(nodeFromFirstList.value));
             nodeFromFirstList = nodeFromFirstList.next;
             continue;
         }
         result.addInTail(new Node(nodeFromSecondList.value));
         nodeFromSecondList = nodeFromSecondList.next;
     }
     for (; nodeFromFirstList != null; nodeFromFirstList = nodeFromFirstList.next) {
          result.addInTail(new Node(nodeFromFirstList.value));
     }
     for (; nodeFromSecondList != null; nodeFromSecondList = nodeFromSecondList.next) {
          result.addInTail(new Node(nodeFromSecondList.value));
     }
     return result;
}
// Стало:
public static LinkedList2 sortAndMergeLists(LinkedList2 firstList, LinkedList2 secondList) {
    LinkedList2 firstListCopy = copyOf(firstList);
    LinkedList2 secondListCopy = copyOf(secondList);
    if (firstListCopy.head != null) {
        firstListCopy.sortInAscendingOrder();
    }
    if (secondListCopy.head != null) {
        secondListCopy.sortInAscendingOrder();
    }
    LinkedList2 result = new LinkedList2();
    Node nodeFromFirstList = firstListCopy.head;
    Node nodeFromSecondList = secondListCopy.head;
    for (; nodeFromFirstList != null && nodeFromSecondList != null; ) {
        if (nodeFromFirstList.value <= nodeFromSecondList.value) {
            result.addInTail(new Node(nodeFromFirstList.value));
            nodeFromFirstList = nodeFromFirstList.next;
            continue;
        }
        result.addInTail(new Node(nodeFromSecondList.value));
        nodeFromSecondList = nodeFromSecondList.next;
    }
    for (; nodeFromFirstList != null; nodeFromFirstList = nodeFromFirstList.next) {
        result.addInTail(new Node(nodeFromFirstList.value));
    }
    for (; nodeFromSecondList != null; nodeFromSecondList = nodeFromSecondList.next) {
        result.addInTail(new Node(nodeFromSecondList.value));
    }
    return result;
}

private static LinkedList2 copyOf(LinkedList2 source) {
    LinkedList2 copy = new LinkedList2();
    if (source == null) {
        return copy;
    }
    for (Node node = source.head; node != null; node = node.next) {
        copy.addInTail(new Node(node.value));
    }
    return copy;
}

12) // Обращение к переменной count сгруппировал в одной строке.
// Было:
public void append(T itm) {
    if (count == capacity) {
        makeArray(capacity * 2);
    }
    array[count] = itm;
    count++;
}
// Стало:
public void append(T item) {
    if (count == capacity) {
        makeArray(capacity * 2);
    }
    array[count++] = item;
}

13) // Переменную node перенес в заголовок for.
// Было:
ArrayList<Node<T>> getAll() {
     ArrayList<Node<T>> r = new ArrayList<Node<T>>();
     Node<T> node = head;
     while(node != null) {
           r.add(node);
           node = node.next;
     }
return r;
}
// Стало:
ArrayList<Node<T>> getAll() {
    ArrayList<Node<T>> result = new ArrayList<>();
    for (Node<T> node = head; node != null; node = node.next) {
        result.add(node);
    }
    return result;
}

14) // Сократил количество используемых переменных.
// Было:
public PowerSet_2 cartesianProduct(PowerSet_2 set2) {
    PowerSet_2 res = new PowerSet_2();
    List<String> elements1 = this.getElements();
    List<String> elements2 = set2.getElements();
    int size1 = elements1.size();
    int size2 = elements2.size();
    if (size1 == 0 || size2 == 0) {
        return res;
    }
    int totalCombinations = size1 * size2;
    for (int i = 0; i < totalCombinations; i++) {
         int index1 = i / size2;
         int index2 = i % size2;

         String val1 = elements1.get(index1);
         String val2 = elements2.get(index2);

         res.put(val1 + ", " + val2 + ", ");
     }
     return res;
}
// Стало:
public PowerSet_2 calculCartesianProduct(PowerSet_2 set2) {
    PowerSet_2 result = new PowerSet_2();
    List<String> firstElements = getElements();
    List<String> secondElements = set2.getElements();
    for (int i = 0; i < firstElements.size(); i++) {
        String first = firstElements.get(i);
        for (int j = 0; j < secondElements.size(); j++) {
            String second = secondElements.get(j);
            result.put(first + ", " + second + ", ");
        }
    }
    return result;
}

15) // Переменную operationsCount перенес в заголовок цикла.
// Было:
int operationsCount = inputStack.size();
for (int i = 0; i < operationsCount; i++) {
    ...
}
// Стало:
for (int i = 0, n = inputStack.size(); i < n; i++) {
    ...
}

