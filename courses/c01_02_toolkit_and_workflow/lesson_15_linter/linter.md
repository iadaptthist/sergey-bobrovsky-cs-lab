## Ошибки и подозрительные места выявленные линтером.

### 1. Неиспользуемый импорт.

* **Рекомендация линтера:** Удалить неиспользуемый импорт import java.util.Arrays;
* **Исправление:** Неиспользуемый импорт был удален.

### 2. Использование конкретных реализаций вместо интерфейсов.

* **Рекомендация линтера:** Программировать через интерфейсы (Map вместо HashMap, List вместо ArrayList).
* **Пример изменения:**
    * **Было:**

      ```java
      HashMap<Integer, String> dictionary = new HashMap<>();
      ArrayList<Integer> result = new ArrayList<>();
      ```
    * **Стало:**
      ```java
      Map<Integer, String> dictionary = new HashMap<>();
      List<Integer> result = new ArrayList<>();
      ```

### 3. Использование оберток вместо методов парсинга.

* **Рекомендация линтера:** Использовать более эффективные методы parseInt() и parseDouble(), возвращающие примитивные типы.
* **Пример изменения:**
    * **Было:**
      ```java
      double weight = Double.valueOf(parts[1]);
      int purrFrequency = Integer.valueOf(parts[2]);
      ```
    * **Стало:**
      ```java
      double weight = Double.parseDouble(parts[1]);
      int purrFrequency = Integer.parseInt(parts[2]);
      ```

### 4. Использование индексного цикла вместо foreach.

* **Рекомендация линтера:** Использовать цикл foreach для повышения лаконичности кода.
* **Пример изменения:**
    * **Было:**
      ```java
      for (int i = 0; i < cats.size(); i++) {
          Cat currentCat = cats.get(i);
          currentCat.printInfo();
      }
      ```
    * **Стало:**
      ```java
      for (Cat cat : cats) {
          cat.printInfo();
      }
      ```

### 5. Отсутствие аннотации @Override при переопределении метода.

* **Рекомендация линтера:** Использовать аннотацию @Override для методов, которые переопределяют методы суперкласса.
* **Пример изменения:**
    * **Было:**
      ```java
      public void printInfo() {
      System.out.println("Оружие " + getName() + ", тип: " + getWeaponType() + ", урон: " + getDamage() + ", вес: " + getWeight() + ", материал: " + getMaterial() + ", прочность: " + getDurability());
      }
      ```

    * **Стало:**
      ```java
      @Override
      public void printInfo() {
      System.out.println("Оружие " + getName() + ", тип: " + getWeaponType() + ", урон: " + getDamage() + ", вес: " + getWeight() + ", материал: " + getMaterial() + ", прочность: " + getDurability());
      }
      ```

### 6. Несоблюдение соглашения об именовании переменных.

* **Рекомендация линтера:** Соблюдать соглашение об именовании (Naming Conventions). Переменные должны именоваться в стиле camelCase.
* **Пример изменения:**
    * **Было:**
      ```java
      int[] EmptyArray = {};
      ```
    * **Стало:**
      ```java
      int[] emptyArray = {};
      ```