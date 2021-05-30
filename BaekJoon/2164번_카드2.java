import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
 
public class Main {
    
    public static void main(String[] args) throws IOException{
        
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String in = br.readLine();
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(var i=1; i<Integer.valueOf(in)+1; i++) {
            numbers.add(i);
        }
        
        int ans = solve( numbers ); 
        
        bw.write(ans + "\n");
        
        bw.flush();
        bw.close();
    }
    
    public static int solve(ArrayList<Integer> current) {
        
        // 현재상태 영역에 카드가 1개뿐이라면 작업을 종료한다.
        if(current.size() == 1 ) {
            return current.get(0);
        }else {
            // 보존영역을 하나 만든다.
            ArrayList<Integer> keep = new ArrayList<>();
            for(var i=0; i<current.size(); i++) {
                
                // 홀수번째는 버리고 짝수번째만 보존영역에 담는다. 
                if( (i+1) % 2 == 0) keep.add(current.get(i));
            }
            
            // 현재상태 영역에 있던 카드의 갯수가 홀수개였으면 추가작업을 진행한다. 
            if(current.size() % 2 == 1 ) {
                int poll = keep.remove(0);
                keep.add(poll);
            }
            
            // keep에 있는 카드를 현재상태 영역으로 보내고 다시 작업을 시작한다.
            return solve(keep);
        }
    }
}
