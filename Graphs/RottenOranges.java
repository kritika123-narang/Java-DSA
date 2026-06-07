class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q=new LinkedList<>();

        int fresh=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]==2){
                    q.offer(new int [] {i,j});
                }

                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;

        int [] dr={-1,1,0,0};
        int [] dc={0,0,-1,1};

        int minutes=0;

        while(!q.isEmpty()){
            int size=q.size();

           boolean rotted=false;

           for(int i=0;i<size;i++){
             int []curr=q.poll();

             int row=curr[0];
             int col=curr[1];

             for(int d=0;d<4;d++){
                int nr=dr[d]+row;
                int nc=dc[d]+col;

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;

                    q.offer(new int [] {nr,nc});
                    fresh--;

                    rotted=true;
                }
             }
        }

           if(rotted){
            minutes++;
           }

        }

        return fresh==0 ? minutes : -1;
    }
}
