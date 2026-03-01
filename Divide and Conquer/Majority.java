import java.util.* ;

public class Majority {
    public static void countSort(int arr[]){
        int n=arr.length;
        int largest = Integer.MIN_VALUE;
        // Find largest element
        for( int i=0;i<n;i++){
            largest = Math.max(largest,arr[i]);
        }
        // Create count array
        int count[]=new int[largest+1];
        // Store count of each element
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        // Print majority element
        for(int i=0;i<count.length;i++){
            if(count[i]>n/2){
              System.out.println(i);
            }
            else{
                System.out.println("Not exist");
            }
        }
        
    }
    public static void main(String args[]){
        int arr[]={2,2,1,1};
        countSort(arr);
    }
}

// Time complexity = O( n + largest )