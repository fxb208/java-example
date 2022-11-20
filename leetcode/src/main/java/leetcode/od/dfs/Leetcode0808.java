package leetcode.od.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode
 *  面试题 08.08. 有重复字符串的排列组合
 *
 *  有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 */
public class Leetcode0808 {
    public static void main(String[] args) {
        Leetcode0808 yb = new Leetcode0808();

        String[] res = yb.permutation("qqe");
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public String[] permutation(String S) {
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[S.length()];
        dfs(res,sb,S,visited);
        String[] r=new String[res.size()];
        res.toArray(r);
        return r;
    }

    public void dfs(Set<String> res,StringBuilder sb,String str,boolean[] visited){
        if(sb.length()==str.length()){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<str.length();i++){
            if(visited[i]){
                continue;
            }
            sb.append(str.charAt(i));
            visited[i]=true;
            dfs(res,sb,str,visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;
        }
    }
}
