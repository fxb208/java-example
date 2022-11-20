package leetcode.od.other;

import java.util.Arrays;

/**
 * JZ61 扑克牌顺子
 */
public class JZ61 {
    public boolean IsContinuous(int [] numbers) {
        Arrays.sort(numbers);
        boolean res = true;
        int count=0;
        for(int i=0;i+1<numbers.length;i++){
            if(numbers[i]==0){
                count++;
            }else{
                if(numbers[i+1]-numbers[i]==1){
                    continue;
                }else if(numbers[i+1]-numbers[i]==0 || numbers[i+1]-numbers[i]>count+1){
                    res=false;
                    break;
                }else{
                    count=count-(numbers[i+1]-numbers[i]-1);
                }

            }
        }
        return res;
    }
}
