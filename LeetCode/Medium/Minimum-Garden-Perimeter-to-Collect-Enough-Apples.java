class Solution {
    public long minimumPerimeter(long neededApples) {
        long total =0;
        int halfPerimeter =0;
        int factor =0;
        while(true){
            long sum =0;
            if(neededApples <= total) break;

            halfPerimeter++;

            // 0부터 n까지의 합
            sum += factor + halfPerimeter-1;
            factor += halfPerimeter-1;
            // y값
            sum += (long) halfPerimeter * (halfPerimeter-1);
            total += (sum*8) + ((long) halfPerimeter *2*4) + ((long) halfPerimeter*4);

        }
        return halfPerimeter* 8L;
    }
}
