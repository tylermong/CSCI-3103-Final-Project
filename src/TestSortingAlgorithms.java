public class TestSortingAlgorithms
{
    public static void main(String[] args)
    {
        int[] array1 = { 5, 3, 1, 2, 4 },
                array2 = { 5, 3, 1, 2, 4 },
                array3 = { 5, 3, 1, 2, 4 },
                array4 = { 5, 3, 1, 2, 4 },
                array5 = { 5, 3, 1, 2, 4 },
                array6 = { 5, 3, 1, 2, 4 },
                array7 = { 5, 3, 1, 2, 4 };

        SortingAlgorithms.bubbleSort(array1);
        SortingAlgorithms.selectionSort(array2);
        SortingAlgorithms.insertionSort(array3);
        SortingAlgorithms.mergeSort(array4);
        SortingAlgorithms.shellSort(array5);
        SortingAlgorithms.quickSort(array6);
        SortingAlgorithms.heapSort(array7);

        SortingAlgorithms.printArray(array1);
        SortingAlgorithms.printArray(array2);
        SortingAlgorithms.printArray(array3);
        SortingAlgorithms.printArray(array4);
        SortingAlgorithms.printArray(array5);
        SortingAlgorithms.printArray(array6);
        SortingAlgorithms.printArray(array7);
    }
}