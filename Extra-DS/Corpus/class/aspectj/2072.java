package ca.ubc.cs.spl.aspectPatterns.examples.strategy.aspectj;

public class Main {

    /**
     * Returns the content of the int array in a string
     * 
     * @param numbers the int array to display
     * @returns a string with all the ints from the array
     */
    private static String show(int[] numbers) {
        String out = "";
        for (int i = 0; i < numbers.length; i++) {
            out += (numbers[i] + " ");
        }
        return out;
    }

    /**
     * Implements the driver for the strategy example. If called with more
     * than zero arguments, bubblesort is used to sort the array of ten
     * numbers; otherwise linear sort. 
     */
    public static void main(String[] args) {
        int[] numbers = { 3, 2, 9, 8, 1, 5, 6, 4, 7, 0 };
        LinearSort sort1 = new LinearSort();
        BubbleSort sort2 = new BubbleSort();
        Sorter sorter = new Sorter();
        if (args.length == 0) {
            SortingStrategy.aspectOf().setConcreteStrategy(sorter, sort1);
        } else {
            SortingStrategy.aspectOf().setConcreteStrategy(sorter, sort2);
        }
        System.out.println("\nPreparing sort...");
        System.out.println("original: " + show(numbers));
        numbers = sorter.sort(numbers);
        System.out.println("sorted:   " + show(numbers));
    }
}
