public class Inversion_Count {
     public static int mergeSort(int arr[],int si,int ei){
        int invCount = 0;
        // Base Case
        if(si<ei){
            int mid = si+(ei-si)/2;
            // Left Part
            invCount = mergeSort(arr, si, mid);
            // Right Part
            invCount += mergeSort(arr, mid+1, ei);
            // Merge
            invCount += merge(arr, si, mid, ei);
        }
        return invCount;
    }
    // Merge Sort
    public static int merge(int arr[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1];         // Temporary array to store sorted elements
        int i=si , j=mid+1 , k=0;              // 
        int invCount = 0;                      // Inversion count
        // Merge 2 sorted arrays
        while (i<=mid && j<=ei){
            // Compare and insert into temp array
            if(arr[i]<=arr[j]){                // If left element is smaller (Le < Re)
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];          // Le > Re
                // Inversion count +1 because the left element is greater than right element
                invCount += (mid-i+1);         
            }
        }
        // Copy remaining elements of left array
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        // Copy remaining elements of right array
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        // Copy temp to original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i] = temp[k];
        }
        // Return inversion count
        return invCount;
    }
    public static void main(String args[]){
        int arr[]={2,4,1,3,5};
        int ans = mergeSort(arr,0,arr.length-1);
        System.out.println(ans);
    }
}
