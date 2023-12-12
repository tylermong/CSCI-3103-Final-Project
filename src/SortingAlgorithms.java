public class SortingAlgorithms
{
    /**
     * Sorts an array using the bubble sort algorithm
     * @param array the array to sort
     */
    public static void bubbleSort(int[] array)
    {
        int temp;
        boolean swap = true;
        while (swap)
        {
            swap = false;
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i] > array[i + 1])
                {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
        }
    }

    /**
     * Sorts an array using the selection sort algorithm
     * @param array the array to sort
     */
    public static void selectionSort(int[] array)
    {
        int oldFrontHolder;
        for (int i = 0; i < array.length; i++)
        {
            int minValue = array[i];
            int minValueIndex = i;
            for (int j = 0; j < array.length; j++)
            {
                if (array[j] < minValue && j >= i)
                {
                    minValue = array[j];
                    minValueIndex = j;
                }
            }
            oldFrontHolder = array[i];
            array[i] = minValue;
            array[minValueIndex] = oldFrontHolder;
        }
    }

    /**
     * Sorts an array using the insertion sort algorithm
     * @param array the array to sort
     */
    public static void insertionSort(int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            int key = array[i];
            int compareIndex = i - 1;

            while (compareIndex >= 0 && array[compareIndex] > key)
            {
                array[compareIndex + 1] = array[compareIndex];
                compareIndex--;
            }
            array[compareIndex + 1] = key;
        }
    }

    /**
     * Sorts an array using the merge sort algorithm
     * My merge sort was not working, so I referenced this video as a refresher: youtu.be/4VqmGXwpLqc
     * @param array the array to sort
     */
    public static void mergeSort(int[] array)
    {
        // base case
        if (array.length == 1)
            return;

        // split array into two halves
        int[] left = new int[array.length / 2];
        int[] right = new int[array.length - left.length];

        // copy data into each half
        for (int i = 0; i < left.length; i++)
            left[i] = array[i];
        for (int i = 0; i < right.length; i++)
            right[i] = array[i + left.length];

        // recursively call mergeSort on each half
        mergeSort(left);
        mergeSort(right);

        // merge everything back together
        merge(left, right, array);
    }

    /**
     * Merges two arrays into one array
     * @param left the left array
     * @param right the right array
     * @param result the end result array
     */
    public static void merge(int[] left, int[] right, int[] result)
    {
        int i = 0, j = 0, k = 0;

        // while there are still elements in both arrays
        while (i < left.length && j < right.length)
        {
            // if the left element is smaller than the right element, add it to the result array, and increment the left index
            if (left[i] < right[j])
            {
                result[k] = left[i];
                i++;
            }
            // otherwise, add the right element to the result array, and increment the right index
            else
            {
                result[k] = right[j];
                j++;
            }
            // increment the result index
            k++;
        }

        // if there are any elements left in the left array, add them to the result array
        while (i < left.length)
        {
            result[k] = left[i];
            i++;
            k++;
        }

        // if there are any elements left in the right array, add them to the result array
        while (j < right.length)
        {
            result[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * Sorts an array using the shell sort algorithm
     * reference: blackboard source & youtu.be/SHcPqUe2GZM
     * @param array the array to sort
     */
    public static void shellSort(int[] array)
    {
        for (int gap = array.length / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < array.length; i++)
            {
                int temp = array[i];
                int j;

                for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                    array[j] = array[j - gap];

                array[j] = temp;
            }
        }
    }

    /**
     * Public method for quickSort
     * @param array the array to sort
     */
    public static void quickSort(int[] array)
    {
        privateQuickSort(array, 0, array.length - 1);
    }

    /**
     * Sorts an array using the quick sort algorithm
     * reference: youtu.be/Vtckgz38QHs
     * @param array the array to sort
     * @param low the first index
     * @param high the last index
     */
    private static void privateQuickSort(int[] array, int low, int high)
    {
        // base case
        if (low >= high)
            return;

        // partitions the array and recursively calls quickSort on each half
        int pivot = partition(array, low, high);
        privateQuickSort(array, low, pivot - 1);
        privateQuickSort(array, pivot + 1, high);
    }
    
    /**
     * Helper method for quickSort, partitions an array
     * @param array the array to partition
     * @param low the first index
     * @param high the last index
     * @return the pivot index
     */
    private static int partition(int[] array, int low, int high)
    {
        // sets the pivot to the last element in the array and sets i to one less than the first index
        int pivot = array[high];
        int i = low - 1;

        // loops through the array, swapping elements if they are less than the pivot
        for (int j = low; j < high; j++)
        {
            if (array[j] < pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // iterates i and swaps the pivot with the element at i, then returns i
        i++;
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        return i;
    }

    public static void heapSort(int[] array)
    {

    }

    /**
     * Prints an array
     * @param array the array to print
     */
    public static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
            if (i != array.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}