package ca.ubc.cs.spl.aspectPatterns.examples.strategy.java;

public class Main {

    /**
     * Implements the driver for the strategy example. If called with more
     * than zero arguments, bubblesort is used to sort the array of ten
     * numbers; otherwise linear sort is used. 
     */
    public static void main(String[] args) {
        int[] numbers = { 3, 2, 9, 8, 1, 5, 6, 4, 7, 0 };
        SortingStrategy sort1 = new LinearSort();
        SortingStrategy sort2 = new BubbleSort();
        Sorter sorter;
        if (args.length == 0) {
            sorter = new Sorter(sort1, numbers);
        } else {
            sorter = new Sorter(sort2, numbers);
        }
    }
}
