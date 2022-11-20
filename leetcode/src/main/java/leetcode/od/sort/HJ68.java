package leetcode.od.sort;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * HJ68.成绩排序
 */
public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int sort = in.nextInt();
        List<Person> lst = new ArrayList<>();
        for(int i=0;i<len;i++){
            String name = in.next();
            int sorce = in.nextInt();
            lst.add(new Person(name,sorce));
        }
        if(sort == 0){
            Collections.sort(lst,(o1, o2) -> {return o2.sorce-o1.sorce;});
        }else{
            Collections.sort(lst,(o1, o2) -> {return o1.sorce-o2.sorce;});
        }
        for(Person person : lst){
            System.out.println(person.name + " " + person.sorce);
        }
    }

    static class Person{
        String name;
        int sorce;
        Person(String name,int sorce){
            this.name=name;
            this.sorce=sorce;
        }
    }
}
