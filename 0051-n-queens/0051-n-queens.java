class Solution {
    public List<List<String>> solveNQueens(int n) {
        int col=0;
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] row:board) Arrays.fill(row,'.');
        solve(0,res,board,n);
        return res;
    }
    public void solve(int col,List<List<String>> res,char[][] board,int n){
        if(col==n){
            List<String> snap = new ArrayList<>();
            for (char[] row : board) snap.add(new String(row));
            res.add(snap);
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                solve(col+1,res,board,n);
                board[row][col]='.';
            }
        }

    }
    public boolean isSafe(int row,int col,char[][] board,int n){
        int dr=row;
        int dc=col;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        row=dr;
        col=dc;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        row=dr;
        col=dc;
        while(col>=0 && row<n){
            if(board[row][col]=='Q') return false;
            col--;
            row++;
        }
        return true;

    }
}