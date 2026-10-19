// Занятие 14. Комментарии.
// Язык Java.

3.1.
1) public void put(String key, T value) {
       // ... поиск свободного места

       // Если свободных слотов нет, находим элемент с минимальным количеством обращений - hits и удаляем его.
       int minHits = hits[0];
       int minIndex = 0;

       for (int i = 1; i < size; i++) {
           if (hits[i] < minHits) {
               minHits = hits[i];
               minIndex = i;
           }
       }
       // ... удаление и вставка нового
   }

2) public void enqueue(T item) {
       if (isFull()) {
           throw new IllegalStateException("Queue is full");
       }

       elements[tail] = item;
       // Циклический сдвиг: при достижении конца массива индекс обнуляется
       tail = (tail + 1) % capacity;
       countElements++;
   }

3) public boolean hasCycle() {
       if (head == null) {
           return false;
       }
       // Если цикл есть, fast догонит slow: за каждый шаг разрыв между ними сокращается на 1.
       for (Node slow = head, fast = head.next; fast != null && fast.next != null; slow = slow.next, fast = fast.next.next) {
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

4) public void removeAll(int _value) {
       // ...

       // Старый хвост мог быть удален, а current после цикла всегда указывает на последний узел.
       this.tail = current;
   }

5) public LinkedList2_2() {
       dummyHead = new DummyNode(0);
       dummyTail = new DummyNode(0);

       // Фиктивные границы позволяют вставлять и удалять узлы без отдельных случаев для первого и последнего элемента.
       dummyHead.next = dummyTail;
       dummyTail.prev = dummyHead;
   }

6) public void remove(int index) {
       // ...
       // Уменьшаем если массив заполнен менее чем на 50% до ~2/3 емкости: запас нужен,
       // чтобы add/remove на границе не вызывали копирование массива каждый раз.
       if (count * 2 < capacity) {
           makeArray(capacity * 2 / 3);
       }
   }

7) public void moveInputToOutput() {
       // Переносим элементы из input в output только когда output опустел.
       // Это сохраняет порядок FIFO и обеспечивает амортизированную сложность O(1) на операцию dequeue.
       if (!outputStack.isEmpty()) {
           return;
       }

       int itemsToMove = inputStack.size();
       for (int i = 0; i < itemsToMove; i++) {
            outputStack.push(inputStack.pop());
       }
   }

3.2.
1) В конструкторе Deque удалил комментарий "инициализация внутреннего хранилища",
потому что строка создания массива сама показывает, что происходит.
2) В методе addFront удалил комментарий "добавление в голову",
потому что имя метода уже описывает это действие.
3) В методе put удалил комментарий "записываем значение value по ключу key",
потому что он полностью дублирует сигнатуру метода put(String key, T value).
4) В методе removeFront удалил комментарий "удаление из головы",
потому что действие понятно из имени метода.
5) В методе isKey удалил комментарий "возвращает true если ключ имеется, иначе false",
потому что действие понятно из имени метода.

  
