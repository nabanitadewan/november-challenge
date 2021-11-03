public class SecondNovember {
    public int uniquePathsIII(int[][] grid) {
        int x=0;
        int y=0;
        int empty = 0;
        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if(grid[i][j] == 0) empty++;
            }
        }
        return  dfs(grid, x, y, empty);
    }

    public int dfs(int[][] grid, int x, int y, int count){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==-1) return 0;
        if(grid[x][y]==2) {
            return count == -1 ? 1 : 0;
        }
        count--;

        grid[x][y] = -1;
        int total =  dfs(grid, x+1, y, count)+
                dfs(grid, x-1, y, count)+
                dfs(grid, x, y+1, count)+
                dfs(grid, x, y-1, count);
        grid[x][y] = 0;

        return total;

    }

}
