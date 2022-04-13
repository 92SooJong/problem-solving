class Solution {
    public int lastRemaining(int n) {
        
        if(n==1) return 1;

        n = n%2 == 1 ? n-1 : n; // 짝수화
        int max = n;
        n = n/2 + n%2;
        int count = 1;
        boolean startLeft= false;
        while(true){
            if( n <= 1 ) return max;
            if((startLeft && n%2 == 1) || (!startLeft) ){
                max = max - (int) Math.pow(2,count);    
            }
            n = n/2;
            count++;
            startLeft = !startLeft;
        }
    }
}
