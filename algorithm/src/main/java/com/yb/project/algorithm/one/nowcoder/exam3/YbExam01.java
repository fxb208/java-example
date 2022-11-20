package com.yb.project.algorithm.one.nowcoder.exam3;

/**
 * 
 * @author fxb20
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。 
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class YbExam01 {
	
	public static void main(String[] args) {
		YbExam01 yb=new YbExam01();
		yb.getLessIndex(new int[] {1,2,3});
	}
	
    public int getLessIndex(int[] arr) {
    	if(arr.length==0 || arr==null){
            return -1;
        }
        if(arr.length==1){
            return 0;
        }
    	int j=-1;
    	for(int i=0;i<arr.length;i++) {
    		if(i==0 && arr[i]<arr[i+1]) {
    			j=i;
    			break;
    		}
    		if(i>0 && i<arr.length-1 && arr[i]<arr[i-1] && arr[i]<arr[i+1]) {
    			j=i;
    			break;
    		}
    		if(i==arr.length-1 && arr[i]<arr[i-1]) {
    			j=i;
    			break;
    		}

    	}
    	return j;
    }
}
