package algorithms;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;



public class Knapsack {
    public Knapsack() {

        Item[] items = {

//                new Item("Камень", 1, 12),
//                new Item("Монитор", 6, 3),
//                new Item("Гитара", 5, 4),
//                new Item("TV", 10, 5),

                new Item("Ноутбук", 16, 9),
                new Item("Планшет", 8, 5),
                new Item("Телефон", 5, 3)};

        Knapsack knapsack = new Knapsack(items, 22);
        knapsack.display();
        Algorithm algorithm = knapsack.solveWithUnlimitedItems();
        Algorithm algorithm1 = knapsack.solve();
        algorithm1.display();
        algorithm.display();
    }
    class Item {

        private String name;
        private int value;
        private int weight;

        public Item(String name, int value, int weight) {
            this.name = name;
            this.value = value;
            this.weight = weight;
        }

        public String str() {
            return name + " (стоимость: " + value + ", вес = " + weight + ")";
        }

    }
    private Item[] items;
    private int capacity;
    public Knapsack(Item[] items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }
    public void display() {
        if (items != null  &&  items.length > 0) {
            System.out.println("Задача о рюкзаке");
            System.out.println("Емкость рюкзака : " + capacity);
            System.out.println("Предметы :");

            for (Item item : items) {
                System.out.println(item.str());
            }
        }
    }
    class Algorithm {
        private List<Item> items;
        private int value;

        public Algorithm(List<Item> items, int value) {
            this.items = items;
            this.value = value;
        }
        public void display() {
            if (items != null  &&  !items.isEmpty()){
                System.out.println("\nРюкзак");
                System.out.println("Сумма = " + value);
                System.out.println("Предметы :");

                for (Item item : items) {
                    System.out.println(item.str());
                }
            }
        }
    }

    private Algorithm solve() {
        int itemsQuantity = items.length;
        int[][] matrix = new int[itemsQuantity + 1][capacity + 1];
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        for (int i = 1; i <= itemsQuantity; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].weight > j)
                    matrix[i][j] = matrix[i-1][j];
                else
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - items[i-1].weight] + items[i-1].value);
                System.out.printf(" m[%d][%d] = %d,",i,j,matrix[i][j]);
            }
            System.out.println("");
        }
        int res = matrix[itemsQuantity][capacity];
        int w = capacity;
        List<Item> itemsSolution = new ArrayList<>();

        for (int i = itemsQuantity; i > 0  &&  res > 0; i--) {
            System.out.println("res = " + res + ", matrix[i-1][w] = " + matrix[i-1][w]);
            if (res != matrix[i-1][w]) {
                itemsSolution.add(items[i-1]);

                res -= items[i-1].value;
                w -= items[i-1].weight;
            }
        }
        return new Algorithm(itemsSolution, matrix[itemsQuantity][capacity]);
    }

    private Algorithm solveWithUnlimitedItems() {
        int itemsQuantity = items.length;

        int value_sum[] = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j < itemsQuantity; j++) {
                if (items[j].weight <= i) {
                    value_sum[i]=Math.max(value_sum[i],value_sum[i-items[j].weight] + items[j].value);
                    System.out.println(Arrays.toString(value_sum));
                }
            }
        }
        int res = value_sum[capacity];
        int w = capacity;
        List<Item> itemsSolution = new ArrayList<>();

        while (res != 0)
        {
            for (int i = 0; i < 3; i++) {
                if ((w - items[i].weight) >= 0) {
                    if ((res - items[i].value) == value_sum[w - items[i].weight]) {
                        itemsSolution.add(items[i]);
                        res -= items[i].value;
                        w -= items[i].weight;
                        break;
                    }
                }
            }
        }
        System.out.println("Оставшееся место = " + w);
        return new Algorithm(itemsSolution, value_sum[capacity]);
    }

}