package com.yb.project.algorithm.one.divideandconquer;

/**
 * leecode 53. 最大子数组和
 * @author fxb20
 * 
 * 分治法
 *
 */
public class YbMaximumSubarray {
	
	public static void main(String[] args) {

		YbMaximumSubarray maximumSubarray=new YbMaximumSubarray();
		int[] nums=new int[]{5,4,-1,7,8};
		//int[] nums=new int[]{5,4};
		Result resul=maximumSubarray.findMaximumSubarray(nums,0,nums.length-1);
		System.out.println(resul.sum);
		System.out.println(resul.low);
		System.out.println(resul.hight);
	}

	Result findMaximumSubarray(int[] arr,int low, int high){
		if(high==low) {
			return new Result(low,high,arr[high]);
		}else {
			int mid=(high+low)/2;
			Result left=findMaximumSubarray(arr,low, mid);
			Result right=findMaximumSubarray(arr,mid+1, high);
			Result cross=findMaxCrossingSubarray(arr,low,mid, high);
			if(left.sum>=right.sum && left.sum>=cross.sum) {
				return left;
			}else if(right.sum>=left.sum && right.sum>=cross.sum) {
				return right;
			}else{
				return cross;
			}
		}
	}
	
	Result findMaxCrossingSubarray(int[] arr,int low,int mid, int high) {
		int sumLeft=Integer.MIN_VALUE;
		int sumRight=Integer.MIN_VALUE;
		int maxLeft=0;
		int maxRight=0;
		int sum=0;
		for(int i=mid;i>=low;i--) {
			sum=sum+arr[i];
			if(sum>sumLeft) {
				sumLeft=sum;
				maxLeft=i;
			}
		}
		sum=0;
		for(int i=mid+1;i<=high;i++) {
			sum=sum+arr[i];
			if(sum>sumRight) {
				sumRight=sum;
				maxRight=i;
			}
		}
		return new Result(maxLeft,maxRight,sumLeft+sumRight);
	}
	
	class Result{
		int low;
		int hight;
		int sum;
		public Result(int low, int hight, int sum) {
			super();
			this.low = low;
			this.hight = hight;
			this.sum = sum;
		}
	}
}
