// 속도 느림 개선 필요.
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        ArrayList<Integer> horizontalCutList = new ArrayList<>();
        horizontalCutList.add(0);
        for (int horizontalCut : horizontalCuts) horizontalCutList.add(horizontalCut);
        horizontalCutList.add(h);
        Collections.sort(horizontalCutList);

        ArrayList<Integer> verticalCutList = new ArrayList<>();
        verticalCutList.add(0);
        for (int verticalCut : verticalCuts) verticalCutList.add(verticalCut);
        verticalCutList.add(w);
        Collections.sort(verticalCutList);
        
        
        long hMaxGap = 0;
        for(int i=0; i<horizontalCutList.size()-1; i++){
            int hGap = horizontalCutList.get(i+1) - horizontalCutList.get(i);
            hMaxGap = Math.max(hMaxGap , hGap );
        }

        long wMaxGap = 0;
        for(int i=0; i<verticalCutList.size()-1; i++){
            int wGap = verticalCutList.get(i+1) - verticalCutList.get(i);
            wMaxGap = Math.max(wMaxGap , wGap );
        }


        long answer = 0;
        int modulo = (int)Math.pow(10,9) + 7;
        for(int i=0; i<verticalCutList.size()-1; i++){
            long wGap = verticalCutList.get(i+1) - verticalCutList.get(i);
            long area = wGap * hMaxGap;
            answer = Math.max(answer , area );
        }

        for(int i=0; i<horizontalCutList.size()-1; i++){
            long hGap = horizontalCutList.get(i+1) - horizontalCutList.get(i);
            long area = hGap * wMaxGap;
            answer = Math.max(answer , area);
        }

        return (int)(answer%modulo);
    }
}
