class Solution {
    public boolean exist(char[][] board, String word) {
        char []w=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==w[0] && fun(board,i,j,w,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean fun(char[][] board,int i,int j,char[] w,int idx){
        if(idx==w.length) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=w[idx]) return false;
        
        char ch=board[i][j];
        board[i][j]='*';
        boolean res=fun(board,i+1,j,w,idx+1) || fun(board,i-1,j,w,idx+1) || fun(board,i,j+1,w,idx+1) || fun(board,i,j-1,w,idx+1);
        board[i][j]=ch;
        return res;
    }
}