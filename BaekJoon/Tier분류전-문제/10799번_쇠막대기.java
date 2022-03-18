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
		
		Stack<String> stack = new Stack<String>();
		

		String t =bf.readLine();
		String[] text = t.split("");
		int sticks = 0;
		String before = ""; // 레이저의 )인지 Stick의 끝인 )인지 구분
		
		for(String s : text) {
			
			if(s.equals(")")) {
				stack.pop();
				if(before.equals(")")) sticks += 1; //
				else sticks += stack.size();
				before = s;
			}
			else {
				stack.push(s);
				before = s;
			}
		}
		
		bw.write(String.valueOf(sticks));
		
		bw.flush();
		bw.close();
	}
		
}
