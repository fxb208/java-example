package leetcode.od2.arr;

/**
 * 36. 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
public class Leetcode36 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf('.'));
        System.out.println(Character.isDigit('.'));
        System.out.println(Integer.valueOf('5'));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(Character.isDigit(board[i][j])){
                    int num = Integer.valueOf(board[i][j]+"");
                    int count = i/3*3+j/3;
                    row[i][num]++;
                    col[j][num]++;
                    box[count][num]++;
                    if (row[i][num] > 1 || col[j][num] > 1 || box[count][num]>1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
