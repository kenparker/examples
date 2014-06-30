package com.maggioni.quicksort.sorting;

import java.util.Arrays;

/*
 ** http://www.dzone.com/links/r/quicksort_algorithm_in_java_code_example.html
 *
 */
public class QuicksortMedianExample {

    private static int[] a;
    private static int[] b;

    public static void main(String[] args) {
        // Get an random generated array
        a = getArray();
        b = cloneArray(a);
        // System.arraycopy(a, 0, b, 0, a.length);

        // prints the given array
        printArray();
        //System.out.println("");
        // sort the array
        Long start1 = System.nanoTime();
        sort();
        Long end1 = System.nanoTime();
        //prints the sorted array
        System.out.println("");
        printArray();
        System.out.println("");
        final long elap1 = (end1 - start1) / 1000;
        System.out.println(" Elapset time Quicksort: " + elap1);

        Long start2 = System.nanoTime();
        Arrays.sort(b);
        Long end2 = System.nanoTime();
        final long elap2 = (end2 - start2) / 1000;
        System.out.println(" Elapset time standard Sort: " + elap2);
        final float verg = (float) elap2 / elap1;
        System.out.printf("Quicksort is : %.03f faster then stadard sort", verg);
        System.out.println("");
    }

    // This method sort an array internally it calls to quickSort 
    public static void sort() {
        int left = 0;
        int right = a.length - 1;

        quickSort(left, right);
    }

    // This method is used to sort the array using quicksort algorithm.
    // It takes left and the right end of the array as two cursors.
    private static void quickSort(int left, int right) {

        // If both cursor scanned the complete array quicksort exits
        if (left >= right) {
            return;
        }

        // Pivot using median of 3 approach
        int pivot = getMedian(left, right);
        // System.out.println("Pivot : " + pivot);
        int partition = partition(left, right, pivot);
        //System.out.println("Partition : " + partition);

        // Recursively, calls the quicksort with the different left and right parameters of the sub-array
        quickSort(0, partition - 1);
        quickSort(partition + 1, right);
    }

    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
    private static int partition(int left, int right, int pivot) {
        int leftCursor = left - 1;
        int rightCursor = right;
        while (leftCursor < rightCursor) {
            while (a[++leftCursor] < pivot) ;
            while (rightCursor > 0 && a[--rightCursor] > pivot) ;
            if (leftCursor >= rightCursor) {
                break;
            } else {
                swap(leftCursor, rightCursor);
            }

        }
        swap(leftCursor, right);
        return leftCursor;
    }

    public static int getMedian(int left, int right) {
        int center = (left + right) / 2;

        if (a[left] > a[center]) {
            swap(left, center);
        }

        if (a[left] > a[right]) {
            swap(left, right);
        }

        if (a[center] > a[right]) {
            swap(center, right);
        }

        swap(center, right);
        return a[right];
    }

    // This method is used to swap the values between the two given index
    public static void swap(int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void printArray() {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static int[] getArray() {
        int size = 10;
        int[] array = new int[size];
        int item = 0;
        for (int i = 0; i < size; i++) {
            item = (int) (Math.random() * 100);
            array[i] = item;
        }
        return array;
    }

    static int[] cloneArray(int original[]) {
        return (int[]) original.clone();
    }
}
