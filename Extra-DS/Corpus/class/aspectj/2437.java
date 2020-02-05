package ca.ubc.cs.spl.aspectPatterns.examples.strategy.java;

public class BubbleSort implements SortingStrategy {

    /**
     * Helper method that exchanges two values in an int array
     * 
     * @param numbers the int array
     * @param pos1 the position of the first element
     * @param pos2 the position of the second element
     */
    private void exchange(int[] numbers, int pos1, int pos2) {
        int tmp = numbers[pos1];
        numbers[pos1] = numbers[pos2];
        numbers[pos2] = tmp;
    }

    /**
     * Sorts an int array using basic bubble sort
     * 
     * @param numbers the int array to sort
     */
    public void sort(int[] numbers) {
        System.out.print("Sorting by BubbleSort...");
        for (int end = numbers.length; end > 1; end--) {
            for (int current = 0; current < end - 1; current++) {
                if (numbers[current] > numbers[current + 1]) {
                    exchange(numbers, current, current + 1);
                }
            }
        }
        System.out.println("done.");
    }
}
