import java.util.Random;

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
                // if the current element is greater than the next element, swap them and set swap to true
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
            // sets the minimum value to the current element and the minimum value index to the current index
            int minValue = array[i];
            int minValueIndex = i;

            // loops through the array, finding the smallest element
            for (int j = 0; j < array.length; j++)
            {
                if (array[j] < minValue && j >= i)
                {
                    minValue = array[j];
                    minValueIndex = j;
                }
            }
            // swaps the smallest element with the current element
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
            // sets the key to the current element and the compareIndex to the element before the current element
            int key = array[i];
            int compareIndex = i - 1;

            // shifts elements over until the correct position is found
            while (compareIndex >= 0 && array[compareIndex] > key)
            {
                array[compareIndex + 1] = array[compareIndex];
                compareIndex--;
            }
            // inserts the element into the correct position
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
    private static void merge(int[] left, int[] right, int[] result)
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
                // sets temp to the current element
                int temp = array[i];
                int j;

                // shifts elements over until the correct position is found
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                    array[j] = array[j - gap];

                // inserts the element into the correct position
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

    /**
     * Sorts an array using the heap sort algorithm
     * reference: youtu.be/MtQL_ll5KhQ
     * @param array the array to sort
     */
    public static void heapSort(int[] array)
    {
        // heapify the array
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        // swap the root with the last element and heapify the array
        for (int i = array.length - 1; i >= 0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    /**
     * Helper method for heapSort, heapifies an array
     * @param array the array to heapify
     * @param size the size of the array
     * @param i the index
     */
    private static void heapify(int[] array, int size, int i)
    {
        // sets the largest element to the root, 2i + 1 to the left, and 2i + 2 to the right
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // if the left element is larger than the root, set the largest element to the left
        if (left < size && array[left] > array[largest])
            largest = left;

        // if the right element is larger than the root, set the largest element to the right
        if (right < size && array[right] > array[largest])
            largest = right;

        // if the largest element is not the root, swap the root with the largest element and recursively call heapify
        if (largest != i)
        {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, size, largest);
        }
    }

    /**
     * Tests all the algorithms at various array sizes.
     * Outputs the time it takes for each algorithm to sort an array of a given size.
     */
    public static void testAlgorithms()
    {
        // array sizes to test
        int[] sizesToTest = { 10000, 20000, 30000, 40000, 50000, 100000, 200000 };
        long startTime, endTime, elapsedTime;

        // validate that all the algorithms work
        validate();

        // test each algorithm at each array size
        for (int i = 0; i < sizesToTest.length; i++)
        {
            int[] testArray = new int[sizesToTest[i]];

            System.out.println("[" + sizesToTest[i] + " elements]");

            randomizeArray(testArray);
            startTime = System.nanoTime();
            bubbleSort(testArray);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1000000;
            System.out.println("Bubble Sort: " + elapsedTime + " milliseconds");

            randomizeArray(testArray);
            startTime = System.nanoTime();
            selectionSort(testArray);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1000000;
            System.out.println("Selection Sort: " + elapsedTime + " milliseconds");

            randomizeArray(testArray);
            startTime = System.nanoTime();
            insertionSort(testArray);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1000000;
            System.out.println("Insertion Sort: " + elapsedTime + " milliseconds");

            randomizeArray(testArray);
            startTime = System.nanoTime();
            mergeSort(testArray);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1000000;
            System.out.println("Merge Sort: " + elapsedTime + " milliseconds");

            randomizeArray(testArray);
            startTime = System.nanoTime();
            shellSort(testArray);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1000000;
            System.out.println("Shell Sort: " + elapsedTime + " milliseconds");

            randomizeArray(testArray);
            startTime = System.nanoTime();
            quickSort(testArray);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1000000;
            System.out.println("Quick Sort: " + elapsedTime + " milliseconds");

            randomizeArray(testArray);
            startTime = System.nanoTime();
            heapSort(testArray);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1000000;
            System.out.println("Heap Sort: " + elapsedTime + " milliseconds");

            System.out.println();
        }
    }

    /**
     * Randomizes an array
     * @param array the array to randomize
     */
    private static void randomizeArray(int[] array)
    {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(array.length);
    }

    /**
     * Validates that all the algorithms work
     */
    private static void validate()
    {
        int[] testArray = new int[5];
        System.out.println("Validating algorithms...");

        randomizeArray(testArray);
        bubbleSort(testArray);
        if (!isSorted(testArray))
            System.out.println("\tBubble Sort failed");
        else
            System.out.println("\tBubble Sort passed");

        randomizeArray(testArray);
        selectionSort(testArray);
        if (!isSorted(testArray))
            System.out.println("\tSelection Sort failed");
        else
            System.out.println("\tSelection Sort passed");

        randomizeArray(testArray);
        insertionSort(testArray);
        if (!isSorted(testArray))
            System.out.println("\tInsertion Sort failed");
        else
            System.out.println("\tInsertion Sort passed");

        randomizeArray(testArray);
        mergeSort(testArray);
        if (!isSorted(testArray))
            System.out.println("\tMerge Sort failed");
        else
            System.out.println("\tMerge Sort passed");

        randomizeArray(testArray);
        shellSort(testArray);
        if (!isSorted(testArray))
            System.out.println("\tShell Sort failed");
        else
            System.out.println("\tShell Sort passed");

        randomizeArray(testArray);
        quickSort(testArray);
        if (!isSorted(testArray))
            System.out.println("\tQuick Sort failed");
        else
            System.out.println("\tQuick Sort passed");

        randomizeArray(testArray);
        heapSort(testArray);
        if (!isSorted(testArray))
            System.out.println("\tHeap Sort failed");
        else
            System.out.println("\tHeap Sort passed");

        System.out.println("Validation complete\n");
    }

    /**
     * Checks if an array is sorted
     * @param array the array to check
     * @return true if the array is sorted, false otherwise
     */
    private static boolean isSorted(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return false;
        return true;
    }
}