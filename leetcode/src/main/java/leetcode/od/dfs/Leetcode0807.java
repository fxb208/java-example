package leetcode.od.dfs;

import java.util.HashSet;
import java.util.Set;

public class Leetcode0807 {


    public String[] permutation(String S) {
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[S.length()];
        dfs(res,sb,0,S,visited);
        String[] r=new String[res.size()];
        res.toArray(r);
        return r;
    }

    public void dfs(Set<String> res,StringBuilder sb,int idx,String str,boolean[] visited){
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
            dfs(res,sb,i+1,str,visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;
        }
    }
}
