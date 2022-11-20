package leetcode.od.general;

import java.util.Scanner;

public class HJ66 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String[][] arr = new String[6][2];
            arr[0][0]="reset"; arr[0][1]="";
            arr[1][0]="reset"; arr[1][1]="board";
            arr[2][0]="board"; arr[2][1]="add";
            arr[3][0]="board"; arr[3][1]="delete";
            arr[4][0]="reboot"; arr[4][1]="backplane";
            arr[5][0]="backplane"; arr[5][1]="abort";

            String[] res = new String[]{"reset what","board fault","where to add","no board at all","impossible","install first","unknown command"};

            while(in.hasNextLine()){
                String str = in.nextLine();
                if(str.length()>16){
                    System.out.println(res[6]);
                }else{
                    String[] command = str.split(" ");
                    if(command.length==1){
                        if(arr[0][0].startsWith(command[0])){
                            System.out.println(res[0]);
                        }else{
                            System.out.println(res[6]);
                        }
                    }else if(command.length==2){
                        int p = 0; String out = res[6];
                        for(int i=1;i<arr.length;i++){
                            if(arr[i][0].startsWith(command[0]) && arr[i][1].startsWith(command[1])){
                                p++;
                                if(p==1){
                                    out = res[i];
                                }else{
                                    out = res[6];
                                    break;
                                }

                            }
                        }
                        System.out.println(out);
                    }else{
                        System.out.println("unknown command");
                    }
                }

            }
        }
}
