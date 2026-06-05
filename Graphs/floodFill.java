class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old_c=image[sr][sc];


        if(color==image[sr][sc]){
            return image;
        }

        dfs(sr,sc,image,old_c,color);

        return image;
    }

    private void dfs(int row,int column,int[][] image,int old_c,int new_c){

        image [row][column]=new_c;

        int [] dr={-1,1,0,0};
        int [] dc={0,0,-1,1};

        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=column+dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==old_c){
                dfs(nr,nc,image,old_c,new_c);
            }
        }
    }


}
