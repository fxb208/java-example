package leetcode.od2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * 906. 超级回文数
 * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
 * 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
 */
public class Leetcode906 {
    public static void main(String[] args) throws IOException {
        //
        //System.out.println((long)Math.sqrt(5));
        Leetcode906 yb = new Leetcode906();
        // System.out.println(yb.superpalindromesInRange("4","1000"));
        // 222200002
        // System.out.println(yb.isPalindromes((long)222200002));
        System.out.println(yb.superpalindromesInRange_write("40000000000000000","50000000000000000"));
    }

    public int superpalindromesInRange(String left,String right){
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(4L);
        set.add(9L);
        set.add(121L);
        set.add(484L);
        set.add(10201L);
        set.add(12321L);
        set.add(14641L);
        set.add(40804L);
        set.add(44944L);
        set.add(1002001L);
        set.add(1234321L);
        set.add(4008004L);
        set.add(100020001L);
        set.add(102030201L);
        set.add(104060401L);
        set.add(121242121L);
        set.add(123454321L);
        set.add(125686521L);
        set.add(400080004L);
        set.add(404090404L);
        set.add(10000200001L);
        set.add(10221412201L);
        set.add(12102420121L);
        set.add(12345654321L);
        set.add(40000800004L);
        set.add(1000002000001L);
        set.add(1002003002001L);
        set.add(1004006004001L);
        set.add(1020304030201L);
        set.add(1022325232201L);
        set.add(1024348434201L);
        set.add(1210024200121L);
        set.add(1212225222121L);
        set.add(1214428244121L);
        set.add(1232346432321L);
        set.add(1234567654321L);
        set.add(4000008000004L);
        set.add(4004009004004L);
        set.add(100000020000001L);
        set.add(100220141022001L);
        set.add(102012040210201L);
        set.add(102234363432201L);
        set.add(121000242000121L);
        set.add(121242363242121L);
        set.add(123212464212321L);
        set.add(123456787654321L);
        set.add(400000080000004L);
        set.add(10000000200000001L);
        set.add(10002000300020001L);
        set.add(10004000600040001L);
        set.add(10020210401202001L);
        set.add(10022212521222001L);
        set.add(10024214841242001L);
        set.add(10201020402010201L);
        set.add(10203040504030201L);
        set.add(10205060806050201L);
        set.add(10221432623412201L);
        set.add(10223454745432201L);
        set.add(12100002420000121L);
        set.add(12102202520220121L);
        set.add(12104402820440121L);
        set.add(12122232623222121L);
        set.add(12124434743442121L);
        set.add(12321024642012321L);
        set.add(12323244744232321L);
        set.add(12343456865434321L);
        set.add(12345678987654321L);
        set.add(40000000800000004L);
        set.add(40004000900040004L);
        long l=Long.valueOf(left);
        long r=Long.valueOf(right);
        int res = 0;
        for(Long ll : set){
            if(ll>=l && ll<=r){
                res++;
            }
        }
        return res;
    }

    // System.out.println(yb.superpalindromesInRange_write("1","999999999999999999"));
    public int superpalindromesInRange_write(String left, String right) throws IOException {
        File file = new File("/home/fangxingbang/code/1.txt");
        FileOutputStream out = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
        long l=Long.valueOf(left);
        long r=Long.valueOf(right);
        long begin = (long)Math.sqrt(l);
        if(begin*begin < l){
            begin++;
        }
        long end = (long)Math.sqrt(r);
        int res = 0;
        for(long i=begin;i<=end;i++){
            if(isPalindromes(i) && isPalindromes(i*i)){
                res++;
                StringBuffer sb = new StringBuffer();
                bufferedWriter.write(sb.append("set.add(").append(i*i).append("L);").toString());
                bufferedWriter.newLine();
                System.out.println(i*i);
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        return res;
    }

    public boolean isPalindromes(Long val){
        String str = String.valueOf(val);
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) !=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
