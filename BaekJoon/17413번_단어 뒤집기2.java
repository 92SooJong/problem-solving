import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		
		Stack<String> stack = new Stack<String>();
		Queue<String> que = new LinkedList<String>();
		
		
		String t =bf.readLine();
		String[] text = t.split("");


		for(String s : text) {
			if(s.equals("<")) { // 태그열기
				int stackSize = stack.size();
				for(int i=0; i<stackSize; i++) {
					bw.write(stack.pop());
				}
				que.add(s); 
			}
			else if(s.equals(">")) { // 태그 닫기
				int queSize = que.size();
				for(int i=0; i<queSize; i++)
					bw.write(que.poll());
				bw.write(">");
			}
			else if(!que.isEmpty())que.add(s); // 태그내 문자
			else if(!s.equals(" ") && que.isEmpty() )stack.push(s); // 태그밖 문자
			else if(s.equals(" ") && que.isEmpty()) { // 태그밖 띄워쓰기
				int stackSize = stack.size();
				for(int i=0; i<stackSize; i++) {
					bw.write(stack.pop());
				}
				bw.write(" ");
			}
		}
		
		// stack에 남아있는 데이터 출력
		int stackSize = stack.size();
		for(int i=0; i<stackSize; i++) {
			bw.write(stack.pop());
		}
		
		
		//bw.write(deq.toString());
		
		
		
		bw.flush();
		bw.close();
	}
		
}
