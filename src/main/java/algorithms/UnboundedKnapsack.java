package algorithms;

public class UnboundedKnapsack
{
    private static int unboundedKnapsack(int capacity, int[] itemsCost, int[] itemsWeight)
    {
        int itemsQuantity = itemsCost.length;
        int summaryValue[] = new int[capacity + 1];
        for(int curCapacity = 0; curCapacity <= capacity; curCapacity++){ // for weight max
            for(int currentItem = 0; currentItem < itemsQuantity; currentItem++){ // for items.length
                if(itemsWeight[currentItem] <= curCapacity){ // if predmet wesit menshe vesa
                    summaryValue[curCapacity] = Math.max(summaryValue[curCapacity], summaryValue[curCapacity - itemsWeight[currentItem]] + itemsCost[currentItem]);
                }
            }
        }
        return summaryValue[capacity];
    }
    public UnboundedKnapsack() {
        int itemCost[] = {5, 8, 16};
        int itemWeight[] = {3, 5, 9};
        System.out.println(unboundedKnapsack(22, itemCost, itemWeight));
    }

}
