import com.solvd.laba.basics.BubbleSort;
import com.solvd.laba.basics.InsertionSort;
import com.solvd.laba.basics.QuickSort;
import com.solvd.laba.basics.SelectionSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 2) {
            String name = args[0];
            String surname = args[1];
            System.out.println("Hello! Nice to see you " + name + " " + surname + "!\n");
        } else {
            System.out.println("Please enter first and last name as command line arguments.");
        }

        int[] array = generateRandomArray(10);
        System.out.println("Original Array: " + Arrays.toString(array) + "\n");

        // Bubble Sort
        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        BubbleSort.bubbleSort(bubbleSortArray);
        System.out.println("Bubble Sort:    " + Arrays.toString(bubbleSortArray));

        // Selection Sort
        int[] selectionSortArray = Arrays.copyOf(array, array.length);
        SelectionSort.selectionSort(selectionSortArray);
        System.out.println("Selection Sort: " + Arrays.toString(selectionSortArray));

        // Insertion Sort
        int[] insertionSortArray = Arrays.copyOf(array, array.length);
        InsertionSort.insertionSort(insertionSortArray);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSortArray));

        // Quick Sort
        int[] quickSortArray = Arrays.copyOf(array, array.length);
        QuickSort.quickSort(quickSortArray, 0, quickSortArray.length - 1);
        System.out.println("Quick Sort:     " + Arrays.toString(quickSortArray));
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}