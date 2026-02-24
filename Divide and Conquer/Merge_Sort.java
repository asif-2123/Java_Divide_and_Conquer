public class Merge_Sort {
    public static void mergeSort(int arr[], int si ,int ei){
        // Base Case
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;
        // Left Part
        mergeSort(arr,si,mid);
        // Right Part
        mergeSort(arr,mid+1,ei);
        // Merge
        merge(arr,si,mid,ei);

    }
    public static void merge (int arr[],int si , int mid , int ei){
        int temp[] = new int[ei-si+1];             // Temporary array to store sorted elements
        int i = si;                                // Left part starting index
        int j = mid+1;                             // Right part starting index
        int k = 0;                                 // Temp array index
        // Merge 2 sorted arrays
        while(i<=mid && j<=ei) {
            // Compare and insert into temp array
            if (arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            } 
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;        // Increment k after each insertion
        }
        // Copy remaining elements of left array
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        // Copy remaining elements of right array
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        // Copy temp to original array
        for (k=0 , i=si ; k<temp.length ; k++ , i++){
            arr[i]=temp[k];
        }
    }

    
    public static void printArray(int arr[]) {
        for (int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main (String args[]) {
        int arr[]={6,3,9,5,2,8};
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
        }    
}
