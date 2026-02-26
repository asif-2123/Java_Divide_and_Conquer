public class Search {

    public static int search(int arr[],int tar,int si,int ei){
        // Base Case
        if(si>ei){
            return -1;
        }
        int mid = si+(ei-si)/2;
        // Elemnt Search
        if(arr[mid]==tar){
            return mid;
        }
        // Left part sorted
        // Mid on left side of pivot [ L1 ]
        if(arr[si]<=arr[mid]){        
            // Target in left part                
            if(arr[si]<=tar && arr[mid]>=tar){
                return search(arr,tar,si,mid-1);     
            }
            // Target in right part
            else{
                return search(arr,tar,mid+1,ei);
            }
        }
        // Right part sorted
        // Mid on right side of pivot [ L2 ]
        else{
            // Target in right part
            if(arr[mid]<tar && arr[ei]>=tar){
                return search(arr,tar,mid+1,ei);
            }
            // Target in left part
            else{
                return search(arr,tar,si,mid-1);
            }
        }
    }
    public static void main (String args[]){
        int arr[]={4,5,6,7,0,1,2};
        int tar = 0;
        int index = search(arr,tar,0,arr.length-1);
        System.out.println(index);
    }
}