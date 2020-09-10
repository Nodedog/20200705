import java.util.Arrays;

public class Test {
    //归并排序
    public static void mergeSort(int[] array){
        //[0,length)
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1){
            return;
        }
        //针对[针对left，right)区间，分成对等的两个区间
        int mid = (left + right) / 2;
        //两个区间
        //[left,mid)
        //[mid,right)
        mergeSortHelper(array,left,mid);
        mergeSortHelper(array,mid,right);
        //通过上面的递归，认为这两个区间都被排好序了，接下来进行合并
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right - left];
        int outputIndex = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            } else {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }
        }
        while (cur1 < mid ){
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;
        }
        while (cur2 < right){
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
        for (int i = 0; i < right - left; i++) {
            array[left + i] = output[i];
        }
    }


    public static void main(String[] args) {
        int[] array = {9,2,5,4,3,11};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
