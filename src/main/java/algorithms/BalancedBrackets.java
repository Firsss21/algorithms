package algorithms;

// Алгоритм проверки баланса скобок в введенном выражении.

import java.util.*;

public class BalancedBrackets {

    public BalancedBrackets(String expression) {
        if (algorithm(expression))
            System.out.println("The entered expression is BALANCED.");
        else
            System.out.println("The expression entered is NOT BALANCED.");
    }
    

    private static boolean algorithm(String inputExpression)
    {
        // Возвращает булеву тру, если скобки в выражении балансны
        
       // инициализация коллекции.
        Deque<Character> stack = new ArrayDeque<>();

        // Перебираем всю строку.
        for (int i = 0; i < inputExpression.length(); i++)
        {
            char charAtI = inputExpression.charAt(i);
            // Если это открывающая скобка, то мы запихиваем его в очередь и переходим к следующему элементу
            if (charAtI == '(' || charAtI == '[' || charAtI == '{')
            {
                stack.push(charAtI);
                continue;
            }

            if (stack.isEmpty()) return false; // если алгоритм прошел мимо континью и пустой - то баланса нет.

            if (charAtI == ']' || charAtI == '}' || charAtI == ')') {
                char firstQueElemOfStack;
                firstQueElemOfStack = stack.pop(); // первый элемент очереди стека ( то есть последний элемент. LIFO ) смотрим и удаляем.
                if (charAtI == ')') {
                    if (firstQueElemOfStack == '{' || firstQueElemOfStack == '[') return false; // но если там другая скобка - ошибка
                }
                if (charAtI == ']') {
                    if (firstQueElemOfStack == '(' || firstQueElemOfStack == '{') return false;
                }
                if (charAtI == '}') {
                    if (firstQueElemOfStack == '(' || firstQueElemOfStack == '[') return false;
                }
            }

        }
        // Если пустой, то значит баланс есть и все закрывающие скобки удалили открывающие.
        return (stack.isEmpty());
    }
}
