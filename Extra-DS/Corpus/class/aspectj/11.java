package ca.ubc.cs.spl.aspectPatterns.examples.strategy.java;

public class Sorter {

    public  Sorter(SortingStrategy sort, int[] numbers) {
        System.out.println("\nPreparing sort...");
        System.out.println("original: " + show(numbers));
        sort.sort(numbers);
        System.out.println("sorted:   " + show(numbers));
        System.out.println("Done sorting.");
    }

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
}
