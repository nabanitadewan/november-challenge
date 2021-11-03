import java.util.LinkedList;
import java.util.Queue;

public class FirstNovember {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i< board[0].length; i++) {
            if(board[0][i] == 'O')
                queue.add(new int[]{0,i});
            if(board[board.length - 1][i] == 'O')
                queue.add(new int[]{board.length-1, i});
        }
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O')
                queue.add(new int[]{i,0});
            if(board[i][board[0].length - 1] == 'O')
                queue.add(new int[]{i, board[0].length -1 });
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] a = queue.poll();
                visited[a[0]][a[1]] = true;
                for(int[] p: d ) {
                    int x = a[0]+p[0];
                    int y = a[1]+p[1];
                    if(isValid(board,x,y) && board[x][y] == 'O' && !visited[x][y]){
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if(!visited[x][y])
                    board[x][y] = 'X';
            }
        }

    }
    private boolean isValid(char[][] board,int row,int col){
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length);
    }
}
