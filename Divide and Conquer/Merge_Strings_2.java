public class Merge_Strings_2 {
    public static String[] mergeStrings(String arr[],int si,int ei){
        // Base case
        if(si==ei){
            String a[] = {arr[si]};
            return a;
        }
        int mid = si+(ei-si)/2;
        // Left Part
        String arr1[]= mergeStrings(arr, si, mid);
        // Right Part
        String arr2[]= mergeStrings(arr, mid+1, ei);
        // Merge
        String arr3[]= merge(arr1,arr2);
        return arr3;
    }
    public static String[] merge(String arr1[], String arr2[]){
        // Merging two sorted string arrays
        String merged[] = new String[arr1.length + arr2.length];
        // Traverse both arrays
        int i = 0; int j = 0; int k = 0;
        // Merge 2 sorted arrays
        while(i<arr1.length && j<arr2.length){
            // Compare and insert into merged array
            if(check(arr1[i],arr2[j])){
                merged[k++] = arr1[i++];
            }
            else{
                merged[k++] = arr2[j++];
            }
        }
        // Copy remaining elements of left array
        while(i<arr1.length){
            merged[k++] = arr1[i++];
        }
        // Copy remaining elements of right array
        while(j<arr2.length){
            merged[k++] = arr2[j++];
        }
        return merged;
    }
    // Compare two strings
    public static boolean check(String str1,String str2){
        if(str1.compareTo(str2)<0){
            return true;
        }
        else{
            return false;
        }
    }
    // Function to print array
    public static void printArray(String arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        String arr[] = {"sun","msrs","earth","merury"};
        String sortedArr[] = mergeStrings(arr, 0, arr.length-1);
        printArray(sortedArr);

    }
}
