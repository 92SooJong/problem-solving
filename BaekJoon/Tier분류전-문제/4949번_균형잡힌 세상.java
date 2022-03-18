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
		
		Stack<String> stack = new Stack<String>();
		 
		
		while(true) {
			
			String sentence = bf.readLine();
			String ans = "yes";
			if(sentence.equals(".")) break;
			else {
				String[] sentenceArray = sentence.split("");
				stack.clear();
				for(String s : sentenceArray ) {
					if(s.equals("(") || s.equals("[")) stack.push(s);
					else if(s.equals(")") || s.equals("]")) {
						
						if(stack.isEmpty()) {
							ans ="no";
							break;
						}
						else if(s.equals(")") && stack.peek().equals("(")) {
							stack.pop();
							ans = "yes";
						}
						else if(s.equals("]") && stack.peek().equals("[")) {
							stack.pop();
							ans = "yes";
						}
						else {
							ans ="no";
							break;
						}
						
					}
					else if(s.equals(".")) break;
				}
				
				if(!stack.isEmpty()) ans ="no";
				

			}
			bw.write(ans +"\n");
			
		}
		
		
		bw.flush();//남아있는 데이터를 모두 출력시킴
		bw.close();//스트림을 닫음
		
		
	}

}
