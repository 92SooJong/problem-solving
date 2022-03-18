import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<Integer>();
		int k = Integer.valueOf(bf.readLine()); 
		

		
		for(int i=0; i<k; i++) {
			int num = Integer.valueOf(bf.readLine());
			if(num == 0) stack.pop();
			else {
				stack.push(num);
			}
		}
		
		int stackSize = stack.size();
		int sum = 0;
		for(int i=0; i<stackSize; i++) {
			sum += stack.pop();
		}
		
		
		
		bw.write(sum +"\n");
		bw.flush();//남아있는 데이터를 모두 출력시킴
		bw.close();//스트림을 닫음
		
		
	}

}
