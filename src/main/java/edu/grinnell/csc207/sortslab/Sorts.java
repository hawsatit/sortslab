package edu.grinnell.csc207.sortslab;

import java.util.Arrays;

/**
 * A collection of sorting algorithms over generic arrays.
 */
public class Sorts {

    public static <T extends Comparable<? super T>> int binarySearch(T value, T[] arr, int lo, int hi) {
        if ((value.compareTo(arr[hi]) > 0) || (value.compareTo(arr[lo]) < 0)) {
            return -1;
        } else {
            int mid = lo + (hi - lo) / 2;
            if (value.compareTo(arr[mid]) == 0) {
                return mid;
            } else if (value.compareTo(arr[mid]) > 0) {
                binarySearch(value, arr, mid + 1, hi);
            } else {
                binarySearch(value, arr, lo, mid);
            }
        }
        return -1;
    }

    /**
     * Swaps indices <code>i</code> and <code>j</code> of array
     * <code>arr</code>.
     *
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i the first index to swap
     * @param j the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        // TODO: fill me in!
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Sorts the array according to the merge sort algorithm:
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        // TODO: fill me in!
        T[] sorted = merge(arr, 0, arr.length);
        arr = sorted;

    }

    public static <T extends Comparable<? super T>> T[] merge(T[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        
        if (lo == hi){
            T[] newArr = Arrays.copyOf(arr, 1);
            newArr[0] = arr[lo];
            return newArr;
            
        } else {
            T[] left = merge(arr, lo, mid);
            T[] right = merge(arr, mid + 1, hi);
            T[] merged = Arrays.copyOf(arr, left.length + right.length);
            
            for (int i = 0; i < left.length; i++){
                merged[i] = left[i];
            }
            
            for (int i = 0; i < right.length; i++){
                merged[i = left.length] = right[i];
            }
            
            return merged;
        }
        
    }

    /**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     *
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        // TODO: fill me in!

    }
}
