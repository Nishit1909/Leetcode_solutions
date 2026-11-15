class Solution {
    public int maxScore(int[] parent, int[] op, int[] score) {
        int n=parent.length;
        List<Integer>[] child=new ArrayList[n];
        for(int i=0;i<n;i++) child[i]=new ArrayList<>();
        for(int i=1;i<n;i++) child[parent[i]].add(i);
        int []order=new int[n];
        int head=0;
        int tail=0;
        order[tail++]=0;
        while(head<tail){
            int v=order[head++];
                for(int c:child[v]) order[tail++]=c;
        }
        int[] best = new int[n];
        for (int k = n - 1; k >= 0; k--) {
            int v = order[k];

            if (child[v].isEmpty()) {          
                best[v] = score[v];
                continue;
            }

            int sum = 0, mn = Integer.MAX_VALUE;
            for (int c : child[v]) {
                sum += best[c];
                mn = Math.min(mn, best[c]);
            }

            int lose = (op[v] == 1) ? mn : Math.min(mn, 0);
            best[v] = score[v] + sum - lose;
        }

        return best[0];
    }
    }
