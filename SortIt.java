import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

interface SortComparator{
    boolean compare(int a, int b);
}

class Main {
    public static void main(String[] args) {
        CommandPromptIO commandPromptIO = new CommandPromptIO(args);
        SortIt sortIt = new SortIt(commandPromptIO.getParameter());
    }
}

class CommandPromptIO {
    private String[] input;
    private final String[] parameters = new String[3];

    public String[] getParameter() {
        return parameters;
    }

    public CommandPromptIO(){}

    public CommandPromptIO(String[] inputTerm) {
        this.input = inputTerm;
        cutParameters();
    }

    public void printResult(String asc, int[] sortedArray, String typeOfSort, long exec, int swaps, int comparison){
        System.out.println("Sorted Type: " + typeOfSort);
        System.out.println("Sorted by: " + asc);
        System.out.println("Execution time: " + exec + " ns");
        System.out.println("Execution time: " + exec/1000000 + " ms");
        System.out.println("Comparison: " + comparison);
        System.out.println("Swaps: " + swaps);
        System.out.println(Arrays.toString(sortedArray));
    }

    private void cutParameters() {
        if(input.length == 0) {
            System.out.println("There isn`t any parameters!");
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("(asc|desc)+\\s+([\\-\\d,]+)+\\s+(qs|ms|hs)");

        String tempLine = "";
        for (int i = 0; i < input.length; i++) {
            tempLine += input[i] + " ";
        }

        Matcher matcher = pattern.matcher(tempLine);

        if (matcher.find()) {
            parameters[0]=matcher.group(1);
            parameters[1]=matcher.group(2);
            parameters[2]=matcher.group(3);
        } else {
            System.out.println("Not Valid format!All parameters in one line!");
            System.out.println("First asc or desc");
            System.out.println("Second values dividing by comma \",\"");
            System.out.println("Third type of sort \n QuickSort - qs \n MergeSort - ms \n HeapSort - hs");
            System.out.println("Example \"desc 1,2,56,45,-9,78,11 qs\"");
            System.exit(0);
        }

    }
}

class SortIt {
    private String typeOfSort;
    private Long execTime = 0L;
    private int[] inputArray;
    public int[] sortedArray;
    private int comparison = 0;
    private int swaps = 0;
    private String sortBy;

    public SortIt() {}

    public SortIt(String[] param) {
        sortBy = param[0];
        typeOfSort = param[2];
        makeIntArrayOfString(param[1]);
        getTypeOfSort();
        printSorted();
    }
    
    private void makeIntArrayOfString(String numbers) {
        String[] arrayTemp = numbers.split(",");
        try{
            inputArray = Stream.of(arrayTemp).mapToInt(Integer::parseInt).toArray();
        }catch (NumberFormatException e){
            System.out.println("input data cannot be expressions");
            System.exit(0);
        }

        sortedArray = inputArray;
    }

    private void printSorted() {
        CommandPromptIO cp = new CommandPromptIO();
        cp.printResult(sortBy,sortedArray,typeOfSort,execTime,swaps,comparison);
    }

    private void startQuickSort(int start,int end) {
        QuickSort quickSort = new QuickSort();
        if(sortBy.equals("desc")){
            getTimeExec(() -> quickSort.sort(sortedArray, start, end,(int a , int b) -> a >= b));
        }else {
            getTimeExec(() -> quickSort.sort(sortedArray, start, end,(int a , int b) -> a <= b));
        }
        typeOfSort = "QuickSort";
        swaps = quickSort.getSwaps();
        comparison = quickSort.getComparison();
    }

    private void startMergeSort(int start,int end) {
        MergeSort mergeSort = new MergeSort();
        if(sortBy.equals("desc")){
            getTimeExec(() -> mergeSort.sort(sortedArray, start, end,(int a , int b) -> a >= b));
        }else {
            getTimeExec(() -> mergeSort.sort(sortedArray, start, end,(int a , int b) -> a <= b));
        }
        typeOfSort = "MergeSort";
        swaps = mergeSort.getSwaps();
        comparison = mergeSort.getComparison();
    }

    private void startHeapSort() {
        HeapSort heapSort = new HeapSort();
        if(sortBy.equals("desc")){
            getTimeExec(() -> heapSort.sort(sortedArray, (int a , int b) -> a < b));
        }else {
            getTimeExec(() -> heapSort.sort(sortedArray, (int a , int b) ->  a > b));
        }
        typeOfSort = "HeapSort";
        swaps = heapSort.getSwaps();
        comparison = heapSort.getComparison();
    }

    public void getTypeOfSort() {
        switch (typeOfSort) {
            case "qs" -> startQuickSort(0, inputArray.length - 1);
            case "ms" -> startMergeSort(0, inputArray.length - 1);
            case "hs" -> startHeapSort();
        }
    }

    private void getTimeExec(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        execTime = System.nanoTime() - startTime;
    }

}

class QuickSort {
    private int comparison = 0;
    private int swaps = 0;

    public int getComparison() {
        return comparison;
    }

    public int getSwaps() {
        return swaps;
    }

    public void sort(int[] arr, int start, int end, SortComparator comparator){
        if (start < end) {
            int middlePoint = partition(arr, start, end, comparator);
            sort(arr, start, middlePoint - 1, comparator);
            sort(arr, middlePoint + 1, end, comparator);
        }
    }

    private int partition(int[] arr, int start, int end,SortComparator comparator){
        int pivot = arr[end];
        int point = start-1;

        for (int i = start; i < end; i++) {
            if (comparator.compare(arr[i],pivot)){
                comparison++;
                point++;
                if(arr[i] != arr[point]){
                    swap(arr,i,point);
                }

            }
        }
        if(arr[point+1] != arr[end]){
            swap(arr, point+1, end);
        }
        return point+1;
    }

    private void swap(int[] arr, int index1, int index2) {
        swaps++;
        int tmp  = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}

class MergeSort {
    private int comparison = 0;
    private int swaps = 0;

    public int getComparison() {
        return comparison;
    }

    public int getSwaps() {
        return swaps;
    }

    public void sort(int[] arr, int start, int end, SortComparator comparator){
        if(start < end){
            int middlePoint = (start + end) / 2;
            sort(arr, start, middlePoint, comparator);
            sort(arr, middlePoint + 1, end, comparator);
            merge(arr, start, middlePoint, end, comparator);
        }
    }

    private void merge(int[] arr, int start, int middlePoint, int end, SortComparator comparator){
        int lengthLeft = middlePoint - start + 1;
        int lengthRight = end - middlePoint;

        int[] leftTemp = new int[lengthLeft + 1];
        int[] rightTemp = new int[lengthRight + 1];

        for (int i = 0; i < lengthLeft; i++) {
            leftTemp[i] = arr[start + i];
        }
        for (int j = 0; j < lengthRight; j++) {
            rightTemp[j] = arr[middlePoint + j + 1];
        }

        int i = 0, j = 0, k = start;
        while (i < lengthLeft && j < lengthRight) {
            if (comparator.compare(leftTemp[i],rightTemp[j])) {
                arr[k] = leftTemp[i];
                i++;
                swaps++;
            } else {
                arr[k] = rightTemp[j];
                j++;
                swaps++;
            }
            comparison++;
            k++;
        }

        while (i < lengthLeft) {
            arr[k] = leftTemp[i];
            swaps++;
            i++;
            k++;
        }

        while (j < lengthRight) {
            arr[k] = rightTemp[j];
            swaps++;
            j++;
            k++;
        }
        
    }
}

class HeapSort {
    private int comparison = 0;
    private int swaps = 0;

    public int getComparison() {
        return comparison;
    }

    public int getSwaps() {
        return swaps;
    }

    public void sort(int[] arr, SortComparator comparator) {
        int arrLength = arr.length;

        for (int i = 0; i < arrLength / 2 - 1; i++) {
            swap(arr, i, i+1);
        }

        buildMaxHeap(arr, arrLength, comparator);

        for (int i = arrLength - 1; i > 0; i--) {
            if(comparator.compare(arr[0],arr[i])){
                swap(arr, 0, i);
            }
            heapify(arr, i, 0, comparator);
        }

    }

    private void buildMaxHeap(int[] arr, int length, SortComparator comparator) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i, comparator);
        }
    }

    public void heapify(int[] arr, int arrLength, int i, SortComparator comparator) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxAsRoot = i;

        if(left < arrLength && comparator.compare(arr[left], arr[maxAsRoot]) ) {
            comparison++;
            maxAsRoot = left;
        }

        if(right < arrLength && comparator.compare(arr[right], arr[maxAsRoot]) ) {
            comparison++;
            maxAsRoot = right;
        }

        if(maxAsRoot != i) {
            comparison++;
            swap(arr, maxAsRoot, i);
            heapify(arr, arrLength , maxAsRoot, comparator);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        swaps++;
        int tmp  = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}


// desc 1,2,56,45,-9,78,11,1,24,43434,535,55,35,5,3,8,7,5,3,2,-3,-4 qs
// desc 43434,535,78,56,55,45,35,24,11,8,7,5,5,3,3,2,2,1,1,-3,-4,-9 qs
// desc -9,-4,-3,1,1,2,2,3,3,5,5,7,8,11,24,35,45,55,56,78,535,43434 qs
// asc -9,-4,-3,1,1,2,2,3,3,5,5,7,8,11,24,35,45,55,56,78,535,43434 qs
