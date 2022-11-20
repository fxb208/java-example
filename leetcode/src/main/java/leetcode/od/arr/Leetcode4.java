package leetcode.od.arr;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class Leetcode4 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{3,4};
        Leetcode4 yb = new Leetcode4();
        System.out.println(yb.findMedianSortedArrays(num1,num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];
        int index = 0;
        while(index<m+n){
            if(i<=m-1 && j<=n-1){
                if(nums1[i]<nums2[j]){
                    arr[index]=nums1[i];
                    i++;
                }else{
                    arr[index]=nums2[j];
                    j++;
                }
            }else if(i==m){
                arr[index]=nums2[j];
                j++;
            }else{
                arr[index]=nums1[i];
                i++;
            }
            index++;
        }
        int l=(m+n)/2;
        if((m+n)%2==0){
            double a = arr[l];
            double b = arr[l-1];
            return (a+b)/(double)2;
        }else{
            return (double)arr[l];
        }
    }
}
