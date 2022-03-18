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
		
		String t =bf.readLine();
		String[] text = t.split("");
		int counts = Integer.valueOf(bf.readLine()); 
		Stack<String> leftStack = new Stack<>();
		Stack<String> rightStack = new Stack<>();
		
		for(String s : text) {
			leftStack.push(s);
		}
		
		
		for(int i=0; i<counts; i++) {
			String c = bf.readLine();
			String[] commands = c.split(" ");
			if(commands[0].equals("L")) {
				if(!leftStack.empty()) {
					rightStack.push(leftStack.pop());
				}
			}
			else if(commands[0].equals("D")) {
				if(!rightStack.empty()) {
					leftStack.push(rightStack.pop());
				}
			}
			else if(commands[0].equals("B")) {
				if(!leftStack.empty()) {
					leftStack.pop();
				}
			}
			else if(commands[0].equals("P")) {
				leftStack.push(commands[1]);
				
			}
		}
		
		int leftStackSize = leftStack.size();
		for(int i=0; i<leftStackSize; i++) {	
			rightStack.push(leftStack.pop());
		}
		
		int rightStackSize = rightStack.size();
		for(int i=0; i<rightStackSize; i++) {	
			bw.write(rightStack.pop());
		}
		
		bw.flush();
		bw.close();
	}
		
}
