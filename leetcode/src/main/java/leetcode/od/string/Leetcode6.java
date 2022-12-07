package leetcode.od.string;

import java.util.Arrays;

/**
 * 6. Z 字形变换
 */
public class Leetcode6 {
    public static void main(String[] args) {
        Leetcode6 yb = new Leetcode6();
        System.out.println(yb.convert("PAYPALISHIRING",3));
    }

    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int l = numRows + numRows-2;
        int len = (s.length()/l)*(numRows-1);
        if(s.length()%l>0){
            len = len+(numRows-1);
        }
        char[][] arr=new char[numRows][len];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(arr[i],'*');
        }

        int i = 0;
        int j = 0;
        int idx=0;
        int middle = 0;
        while(idx<s.length()){
            arr[i][j]=s.charAt(idx);
            idx++;
            if(middle==0 && i<numRows){
                if(i==numRows-1){
                    middle=1;
                    i--;
                    j++;
                    continue;
                }
                i++;
            }
            if(middle==1 && i>=0){
                if(i==0){
                    middle=0;
                    i++;
                    continue;
                }
                i--;
                j++;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int ii=0;ii<arr.length;ii++){
            for(int jj=0;jj<arr[0].length;jj++){
                if(arr[ii][jj] !='*'){
                    res.append(arr[ii][jj]);
                }
            }
        }
        return res.toString();
    }
}
