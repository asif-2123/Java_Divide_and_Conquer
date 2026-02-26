public class Quick_Sort {
    public static void quickSort(int arr[],int si,int ei){
        //Base Case
        if(si>=ei){
            return;
        }
        // Partitioning
        int pIdx=partition(arr,si,ei);
        quickSort(arr,si,pIdx-1);           // Left Part
        quickSort(arr,pIdx+1,ei);           // Right Part
    }
    // Partition Function
    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];                // Choosing last element as pivot
        int i =si-1;                        // Smaller element index
        // Traverse through all elements
        for (int j=si ;j<ei;j++){
            if(arr[j]<=pivot){
                i++;                        // Increment smaller element index to make space
                // Swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;                                // Place pivot at correct position
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    // Function to print array
    public static void printArray(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main (String args[]){
        int arr[]={6,3,9,8,2,5};
        quickSort(arr,0,arr.length-1);
        printArray(arr);
    }
}
