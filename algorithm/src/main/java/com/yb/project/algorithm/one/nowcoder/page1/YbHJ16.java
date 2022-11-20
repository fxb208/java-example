package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * HJ16 购物单
 * @author fxb20
 *
 */
public class YbHJ16 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int price=in.nextInt();
		int length=in.nextInt();
		int[][] nums=new int[length][3];
		
		int[][] master=new int[length][3];
		int[][] slave=new int[length][3];
		
		Good[] arrGood=new Good[length+1];
		for(int i=0;i<length;i++) {
			int v=in.nextInt();
			int p=in.nextInt();
			int q=in.nextInt();
			arrGood[i].v=v;
			arrGood[i].p=p;
			arrGood[i].q=q;
		}

		
	}
	
	public static int hj16(int[][] nums,int price) {
		int[][] dp=new int[nums.length][price];
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<price;j++) {
				int iv=nums[i][0];
				int ip=nums[i][1];
				int iq=nums[i][2];
					
				if(iq==0) {
					if(j-iv>=0) {
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-iv]+iv*ip);
					}else {
						dp[i][j]=dp[i-1][j];
					}
				}else {
					int iqv=nums[iq-1][0];
					int iqp=nums[iq-1][1];
					int iqq=nums[iq-1][2];
					if(j-iv>=0) {
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-iv]+iv*ip);
					}else {
						dp[i][j]=dp[i-1][j];
					}
				} 
				
			}
		}
		return 0;
	}
	
    /**
     * 定义物品类
     */
    private static class Good{
        public int v;  //物品的价格
        public int p;  //物品的重要度
        public int q;  //物品的主附件ID
 
        public int a1=0;   //附件1ID
        public int a2=0;   //附件2ID
 
        Good(){}
        
        public Good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }
 
        public void setA1(int a1) {
            this.a1 = a1;
        }
 
        public void setA2(int a2) {
            this.a2 = a2;
        }

	

		public void setV(int v) {
			this.v = v;
		}



		public void setP(int p) {
			this.p = p;
		}



		public void setQ(int q) {
			this.q = q;
		}
        
    }
}
