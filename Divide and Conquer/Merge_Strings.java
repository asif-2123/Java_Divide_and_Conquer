public class Merge_Strings {
    public static void mergeSort(String arr[],int si,int ei){
        //Base Case
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr,si,mid);           // Left Part
        mergeSort(arr,mid+1,ei);         // Right Part
        // Merge two sorted parts
        merge(arr,si,mid,ei);
    }
    // Merge Sort for Strings
    public static void merge(String arr[],int si,int mid,int ei){
        String merged[] = new String[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        // Merge 2 sorted arrays
        while(i<=mid && j<=ei){
            // Compare and insert into merged array
            if(arr[i].compareTo(arr[j])<0){
                merged[k++] = arr[i++];
            }
            else{
                merged[k++] = arr[j++];
            }
        }
        // Copy remaining elements of left array
        while(i<=mid){
            merged[k++] = arr[i++];
        }
        // Copy remaining elements of right array
        while(j<=ei){
            merged[k++] = arr[j++];
        }
        // Copy merged to original array
        for(k=0,i=si;k<merged.length;k++,i++){
            arr[i] = merged[k];
        }
    }
    // Function to print array
    public static void printArray(String arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main (String args[]){
        String arr[] ={"sun","msrs","earth","merury"};
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
