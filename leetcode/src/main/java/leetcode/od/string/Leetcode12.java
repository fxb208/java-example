package leetcode.od.string;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 */
public class Leetcode12 {
    public static void main(String[] args) {
        Leetcode12 yb = new Leetcode12();
        System.out.println(yb.intToRoman(58));
    }

    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        if(num>1000){
            int temp = num/1000;
            num = num%1000;
            for(int i=0;i<temp;i++){
                sb.append("M");
            }
        }
        if(num>500){
            int temp = num/100;
            num = num%100;
            if(temp-5<4){
                sb.append("D");
                for(int i=0;i<temp-5;i++){
                    sb.append("C");
                }
            }else{
                sb.append("CM");
            }
        }
        if(num>100){
            int temp = num/100;
            num = num%100;
            if(temp<4){
                for(int i=0;i<temp;i++){
                    sb.append("C");
                }
            }else{
                sb.append("CM");
            }
        }
        if(num>50){
            int temp = num/10;
            num = num%10;
            if(temp-5<4){
                sb.append("L");
                for(int i=0;i<temp-5;i++){
                    sb.append("X");
                }
            }else{
                sb.append("XC");
            }
        }
        if(num>10){
            int temp = num/10;
            num = num%10;
            if(temp<4){
                for(int i=0;i<temp;i++){
                    sb.append("X");
                }
            }else{
                sb.append("XL");
            }
        }
        if(num>5){
            int temp = num/1;
            num=0;
            if(temp-5<4){
                sb.append("V");
                for(int i=0;i<temp-5;i++){
                    sb.append("I");
                }
            }else{
                sb.append("IX");
            }
        }
        if(num>0){
            int temp = num/1;
            if(temp<4){
                for(int i=0;i<temp;i++){
                    sb.append("I");
                }
            }else{
                sb.append("IV");
            }
        }
        return sb.toString();
    }
}
