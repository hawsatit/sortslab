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
     * @param left
     * @param right
     * @param mid
     */
    public static <T extends Comparable<? super T>> void merge(T[] arr, int left, int right, int mid) {
//        if(left == right){
//            return;
//        }
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

//            T[] newArr;Arrays.copyOfRange(arr, left, mid + 1)
        T[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i].compareTo(rightArr[j]) < 0) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }

    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {

        if (arr.length > 0) {
            mergeSortHelper(arr, 0, arr.length - 1);
        }
    }
//

    public static <T extends Comparable<? super T>> void mergeSortHelper(T[] arr, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            //sort left
            mergeSortHelper(arr, left, mid);

            //sort right
            mergeSortHelper(arr, mid + 1, right);

            //merge
            merge(arr, left, right, mid); //merge right
        }
//
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
        quickie(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<? super T>> void quickie(T[] arr, int left, int right) {
        //call on left and right
        if (left < right) {
            int pivot = quicky(arr, left, right);

            //right side
            quickie(arr, pivot + 1, right);

            //left side
            quickie(arr, left, pivot - 1);
        }
    }

    public static <T extends Comparable<? super T>> int quicky(T[] arr, int left, int right) {

        int pivot = right;
        int head = left;
        int tail = left - 1;

        while (head <= right - 1) {
            if (arr[head].compareTo(arr[pivot]) < 0) {
                tail++;

                swap(arr, head, tail);

            }
            head++;
        }
        //do final swap with pivot and tail + 1
        swap(arr, tail + 1, pivot);

        return tail + 1;
    }
}
