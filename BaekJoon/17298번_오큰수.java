import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		
		Stack<Integer> stack = new Stack<Integer>();
		
		
		bf.readLine();
		String t2 =bf.readLine();
		String[] n = t2.split(" ");
		int ans[] = new int[n.length];
		
		stack.push(0);
		
		for(int i=1; i<n.length; i++) {
			
			if(stack.empty()) stack.push(i);
			
			while(!stack.empty() && Integer.valueOf(n[stack.peek()]) < Integer.valueOf(n[i])) {
				ans[stack.peek()] = Integer.valueOf(n[i]);
				stack.pop();
			}
			stack.push(i);
		}
		
		while(!stack.empty()) {
			ans[stack.peek()] = -1;
			stack.pop();
		}
		
		
		for(int i=0; i<ans.length; i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		
		
		////////////출력 이렇게 작성하면 시간초과!!!//////////////
		//String answer = "";
		//for(int i=0; i<ans.length; i++) {
		//	int oks = ans[i];
		//	if(oks == 0 ) oks = -1;
		//	answer += oks + " ";
		//}
		//bw.write(answer.substring(0,answer.length()-1));
		///////////////////////////////////////////////
		
		
		bw.flush();
		bw.close();
	}
		
}
