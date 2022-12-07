package leetcode.od3;


/**
 * 剑指 Offer 46. 把数字翻译成字符串
 */
public class Offer46 {
    public static void main(String[] args) {
        System.out.println( (char)('a'+2));
        Offer46 yb = new Offer46();
        yb.translateNum(25);
    }

    public int translateNum(int num) {
        int[] res = new int[1];
        String str = String.valueOf(num);
        backTRack(res,new StringBuilder(),str,0);
        return res[0];
    }

    public void backTRack(int[] res,StringBuilder count,String num,int idx){
        if(idx==num.length()){
            if(count.length()==num.length()){
                res[0]++;
            }
            return;
        }
        for(int i=idx;i<num.length() ;i++){
            count.append(i);
            backTRack(res,count,num,i+1);
            count.delete(count.length()-1,count.length());
            if(i<num.length()-1 && num.charAt(i) !='0'){
                int len = Integer.valueOf(""+num.charAt(i)+num.charAt(i+1));
                if(len<26){
                    count.append(i).append(i+1);
                    backTRack(res,count,num,i+2);
                    count.delete(count.length()-2,count.length());
                }
            }
        }
    }
}
