
## Метод Эрроу-Гурвица

Задача о нелинейной программировании градиентными методами

Программа, решающая задачи нелинейного программирования методом Эрроу-Гурвица с точностью 0.0001
В качестве лямбды значения 0.001

Пример работы:

![](https://i.imgur.com/FFkqoJR.png)

## Двойственный симплекс-метод

Двойственный симплекс-метод позволяет решать задачи линейного программирования, системы ограничений которых при положительном базисе содержат свободные члены любого знака. Этот метод позволяет уменьшить количество преобразований системы ограничений, а также размера симплексной таблицы.

 - [Видео](https://www.youtube.com/watch?v=XwORAaG3ZmI), которое хорошо поясняет на примере. 
 
Дополнительно к методу были созданы дроби для точных вычислений
 
 Пример работы:
 
 ![](https://i.imgur.com/8DXUHZW.png)


## Метод Жордана-Гаусса

 Метод, который используется для решения квадратных систем линейных алгебраических уравнений, нахождения обратной матрицы, нахождения координат вектора в заданном базисе или отыскания ранга матрицы. (Метод прямоугольников)

Программа, решающая систему линейных уравнений
методом Жордана-Гаусса с выбором главного элемента в таблице
 
 - [Видео](https://www.youtube.com/watch?v=npWJWEz4gW8), которое хорошо поясняет на примере. 
 
 Пример работы:
 
 ![](https://i.imgur.com/EFMsNKK.png)

 ![](https://i.imgur.com/T3tBEhQ.png)
 

## Матричные игры

Матричной игрой в математической теории игр называется игра двух лиц с нулевой суммой, в которой в распоряжении каждого из них имеется конечное множество стратегий. Правила матричной игры определяет платёжная матрица, элементы которой - выигрыши первого игрока, которые являются также проигрышами второго игрока.

Матричная игра является антагонистической игрой. Первый игрок получает максимальный гарантированный (не зависящий от поведения второго игрока) выигрыш, равный цене игры, аналогично, второй игрок добивается минимального гарантированного проигрыша.

Под стратегией понимается совокупность правил (принципов), определяющих выбор варианта действий при каждом личном ходе игрока в зависимости от сложившейся ситуации.

 Пример работы:
 
 ![](https://i.imgur.com/9dP7uw0.png)

 ![](https://i.imgur.com/oyLo8Lf.png)
 

## Задача о рюкзаке:

Задача о рюкзаке) — дано N предметов, каждый предмет имеет массу и стоимость. Необходимо выбрать из этих предметов такой набор, чтобы суммарная масса не превосходила заданной величины (вместимость рюкзака), а суммарная стоимость была максимальна.

Неплохое пояснение https://habr.com/ru/post/561120/

Задача:

![](https://i.imgur.com/V3aNyqf.png)

- Ограниченный рюкзак

любой предмет может быть выбран ограниченное количество раз.

Решение:
      
![image](https://user-images.githubusercontent.com/47852430/132793948-fbe65202-146f-4c46-a605-5a1204c44158.png)

- Неограниченный рюкзак

 Любой предмет может быть выбран любое количество раз.
      
 Решение:
 
 ![](https://i.imgur.com/TJR59n6.png)

## Графы:

+ ### Алгоритм Дейкстры

Этот алгоритм находит кратчайшие пути между всеми вершинами графа и их длину. Недостаток данного алгоритма в том, что он будет некорректно работать если граф имеет дуги отрицательного веса.

Неплохое пояснение https://habr.com/ru/post/111361/

Пример работы:

![image](https://user-images.githubusercontent.com/47852430/132794709-35d81f1d-d926-44f8-8d86-29c14c81c0c8.png)

    
+ ### Алгоритм Флойда

Алгоритм нахождения длин кратчайших путей между всеми парами вершин во взвешенном ориентированном графе. Работает корректно, если в графе нет циклов отрицательной величины, а в случае, когда такой цикл есть, позволяет найти хотя бы один такой цикл.
    
Неплохое пояснение https://habr.com/ru/post/105825/

Пример работы:

![image](https://user-images.githubusercontent.com/47852430/132795999-daae5eea-2ed9-4713-8a82-27115190e167.png)

+ ### Алгоритм Крускала

Эффективный алгоритм построения минимального остовного дерева взвешенного связного неориентированного графа. Также алгоритм используется для нахождения некоторых приближений для задачи Штейнера

Неплохое пояснение https://www.youtube.com/watch?v=mPObw3cJoTs

Пример работы:

![image](https://user-images.githubusercontent.com/47852430/132796160-c4792301-87af-49e9-98d6-4a77960cd3ca.png)


## Сортировки:

+ ### Пузырьковая сортировка

 Пузырьковая сортировка - это сравнение соседних элементов и смена чисел местами, если оно больше/меньше.
    После одного прохода по массиву последний элемент прохода по массиву(не массива) отсекается.
    О(n) - идеал. O(n*n) - среднее и худшее время.
    
      public int[] sort(int[] array) {
          int[] arrayToSort = array.clone();
          boolean swap_elements;
              for(int i = 0; i < arrayToSort.length - 1; i++) {
                  swap_elements = false;
                  for(int y = 0; y < (arrayToSort.length - i - 1); y++) {
                      if (arrayToSort[y] > arrayToSort[y+1]) {
                          swapElements(arrayToSort ,  y, y+1);
                          swap_elements = true;
                      }
                  }
                  if (!swap_elements) break;
              }
          return arrayToSort;
      }
 
+ ### Сортировка выбором

 Ищем минимальный элемент/максимальный элемент и ставим первым/последним.
    O(n*n) худшее, среднее и лучшее.
    
    public int[] sort(int[] array) {
        int[] arrayToSort = array.clone();
        int minElementIndex;
        for (int y = 0; y < arrayToSort.length; y++) {
            minElementIndex = y;
            for (int i = y + 1; i < arrayToSort.length; i++) {
                if (arrayToSort[minElementIndex] > arrayToSort[i]) {
                    minElementIndex = i;
                }
            }
            if (minElementIndex != y) swapElements(arrayToSort, minElementIndex, y);
        }
        return arrayToSort;
    }
    
+ ### Быстрая сортировка

Алгоритм быстрой сортировки — это один из самых быстрых существующих алгоритмов сортировки, который является примером стратегии «разделяй и властвуй». Большинство готовых библиотек и методов по сортировке используют quick sort алгоритм как основу. Сложность: в худшем случае O(n^2), среднее O(n×log2n)

- В начале выбирается “опорный” элемент массива. Это может быть любое число, но от выбора этого элемента сильно зависит эффективность алгоритма. Если нам известна медиана, то лучше выбирать элемент, который как можно ближе к медиане. 

- Элементы в массиве делятся на две части: слева те кто меньше опорного элемента, справа те кто больше. Таким образом опорный элемент занимает свое место и больше никуда не двигается.

- Для левого и правого массива действия повторяются рекурсивно.


       void sort(int arr[], int low, int high) {
           if (low < high) {
               int pi = partition(arr, low, high);
               sort(arr, low, pi - 1);
               sort(arr, pi + 1, high);
           }
       }

       int partition(int arr[], int low, int high) {
           int pivot = arr[high];
           int i = (low - 1);

           for (int j = low; j < high; j++) {
               if (arr[j] < pivot) {
                   i++;
                   swapElements(arr, j, i);
               }
           }
           swapElements(arr, i + 1, high);
           return i + 1;
       }
    
+ ### Сортировка слияением

Сортировка слиянием — алгоритм сортировки, использующий O(n) дополнительной памяти и работающий за O(nlog(n)) времени.

- Если в рассматриваемом массиве один элемент, то он уже отсортирован — алгоритм завершает работу.

- Иначе массив разбивается на две части, которые сортируются рекурсивно.

- После сортировки двух частей массива к ним применяется процедура слияния, которая по двум отсортированным частям получает исходный отсортированный массив.

Функция сортирует подотрезок массива с индексами в полуинтервале [left;right). 

     public void sortUnsorted(int[] a, int low, int high) {
         if (high <= low)
             return;

         int mid = low + (high - low) / 2;
         sortUnsorted(a, low, mid);
         sortUnsorted(a, mid + 1, high);

         int[] buf = Arrays.copyOf(a, a.length);

         for (int k = low; k <= high; k++)
             buf[k] = a[k];

         int i = low, j = mid + 1;
         for (int k = low; k <= high; k++) {

             if (i > mid) {
                 a[k] = buf[j];
                 j++;
             } else if (j > high) {
                 a[k] = buf[i];
                 i++;
             } else if (buf[j] < buf[i]) {
                 a[k] = buf[j];
                 j++;
             } else {
                 a[k] = buf[i];
                 i++;
             }
         }
     }
    
+ ### Сортировка слиянием без рекурсии
    
При итеративном алгоритме используется на O(logn) меньше памяти, которая раньше тратилась на рекурсивные вызовы. 

    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        int length = arr.length;
        int i, j, k;
        int left_left, left_right, right_left, right_right;


        for(int step = 1; step < length; step *= 2 ) {
            left_left = 0;
            k = 0;

            while (left_left + step < length) {
                left_right = left_left + step - 1;
                right_left = left_right + 1;
                right_right = right_left + step - 1;

                if (right_right >= length) right_right = length - 1;

                i = left_left;
                j = right_left;

                while (i <= left_right && j <= right_right) {
                    if (arr[i] <= arr[j])
                        temp[k++] = arr[i++];
                    else
                        temp[k++] = arr[j++];
                }

                while (i <= left_right) temp[k++] = arr[i++];
                while (j <= right_right) temp[k++] = arr[j++];

                left_left = right_right + 1;


            }

            for (i = left_left; k < length; i++) temp[k++] = arr[i];
            for (i = 0; i < length; i++) arr[i] = temp[i];
            System.out.println("step " + step);
            printArray(arr, step);

            System.out.println(" ");
        }
    }

+ ### Бинарный поиск

```java
 public int binarySearch(int[] arr, int key) {
    int left = 0;
    int right = arr.length - 1;

    int mid = (left + right) / 2;
    while (left <= right) {
        if (arr[mid] < key) {
            left = mid + 1;
        } else if (arr[mid] > key) {
            right = mid - 1;
        } else {
            return arr[mid];
        }
        mid = (left + right) / 2;
    }
    return -1;
 }
```

+ ### Inorder traversal

Traverse the left subtree

Visit the root

Traverse the right subtree

+ ### Preorder traversal

Traverse the left subtree

Visit the root

Traverse the right subtree

+ ### Postorder traversal

Traverse the left subtree

Traverse the right subtree

Visit the root

+ ### Reverse list

```java
public ListNode reverseList(ListNode head) {
    ListNode first = head;
    while (head!= null && head.next != null) {
        ListNode temp = head.next.next;
        ListNode next = head.next;
        head.next.next = first;
        first = next;
        head.next = temp;
    }
    return first;
}
```

v2

```java
public ListNode reverseList(ListNode head) {
      if(head == null){
        return head;
    }
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = curr.next;
    while(curr != null){
        curr.next = prev;
        prev = curr;
        curr = next;
        if(next != null){
            next = next.next;
        }
    }
  head = prev;
  return head;

}
```
