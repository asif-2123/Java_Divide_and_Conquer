public class Majority_optimised {
    public static int countingInRange(int nums[],int num,int si,int ei){
        int count=0;
        // Traverse through array
        for(int i=si;i<ei;i++){
            // Compare and count
            if(nums[i]==num){
                count++;                   // Increment count
            }
        }
        return count;
    }
    public static int majorityElement(int nums[],int si,int ei){
        // Base Case
        if(si==ei){
            return nums[si];
        }
        int mid = si+(ei-si)/2;
        // Left Part
        int left = majorityElement(nums,si,mid);
        // Right
        int right = majorityElement(nums,mid+1,ei);
        // Compare
        if(left==right){
            return left;
        }
        // Count left and right
        int leftCount = countingInRange(nums,left,si,ei);
        int rightCount = countingInRange(nums,right,si,ei);
        // Return majority element
        return leftCount > rightCount ? left : right;
    }
    public static void main(String args[]){
        int nums[]={2,2,1,1,1,2,3};
        int ans = majorityElement(nums,0,nums.length-1);
        System.out.println(ans);
    }
}
