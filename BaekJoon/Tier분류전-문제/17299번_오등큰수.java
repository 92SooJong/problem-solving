import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// 입출력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] fList = new int[1000001]; //  최대수열길이 1000001 선언, 0으로 초기화
		
		bf.readLine();
		String t2 =bf.readLine();
		int[] n = Arrays.stream(t2.split(" ")).mapToInt(Integer::parseInt).toArray();
		int ans[] = new int[n.length];
		
		for(int i=0; i<n.length; i++) {
			fList[n[i]] +=1;
		}
		
		stack.push(0);
		for(int i=1; i<n.length; i++) {
			
			if(stack.isEmpty()) stack.push(i);
			else {
				while(!stack.isEmpty() && fList[n[stack.peek()]] < fList[n[i]]) {
					ans[stack.peek()] = n[i];
					stack.pop();
				}
				stack.push(i);
			}
		}
		
		for(int i=0; i<ans.length; i++)
			if(ans[i] == 0 ) bw.write("-1" + " ");
			else bw.write(ans[i] + " ");
		
		bw.write("\n");
		bw.flush();
		bw.close();
	}
		
}
