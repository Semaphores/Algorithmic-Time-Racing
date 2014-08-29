package sort;

/**
 * Created by Phillip on 8/25/2014.
 */
public class Sort {

    /**
     * A sorting space for demonstration purposes
     */
    /**
     * Bubble Sort Algorithm
     * Following method is specific to Arrays
     */
    public static int[] bubbleSort(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }

    /**
     * Insertion Sort Algorithm
     * Following method is specific to Arrays
     * Referenced Professor Li's original code
     */
    public static int[] insertionSort(int[] a){
        for(int j=1;j< a.length;j++){
            int key = a[j];
            int pos=j;
            // shifting
            while(pos>0 && a[pos-1] > key){
                a[pos] = a[pos-1];
                pos--;
            }
            a[pos] = key;
        }
        return a;
    }

    /**
     * Quick Sort Algorithm
     * Following q-sort is array specific
     * Referenced Professor Li's original code
     */
    public static void quickSort(int data[], int left, int right) {
        int i = partition(data, left, right);
        if (left < i - 1)
            quickSort(data, left, i - 1);
        if (i < right)
            quickSort(data, i, right);
    }

    private static int partition(int data[], int left, int right){
        int i = left, j = right;
        int temp;
        int pivot = data[(left + right) / 2];

        while (i <= j) {
            while (data[i] < pivot)
                i++;
            while (data[j] > pivot)
                j--;
            if (i <= j) {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    /**
     * Selection Sort Algorithm
     * Following method is specific to Arrays
     * Referenced Professor Li's original code
     */
    public static int[] selectionSort(int[] a){
        int min,temp;
        for(int i=0;i<a.length-1;i++){
            min=i;
            for(int j = i;j< a.length;j++)
                if(a[j] < a[min])
                    min=j;

            //Swap
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }
}
