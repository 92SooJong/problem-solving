import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
	
	static LinkedHashMap<String,String> nodes = new LinkedHashMap<String,String>();

		
	public static void main(String[] args) throws IOException{
		
		
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		nodes.put("a","");
		nodes.put("b","a");
		nodes.put("c","b");
		nodes.put("d","b"); 
		nodes.put("e","a");
		nodes.put("f","e");
		nodes.put("g","f");
		nodes.put("h","e");
		nodes.put("a1","");
		nodes.put("b1","a1");
		nodes.put("c1","b1");
		nodes.put("d1","b1");
		nodes.put("e1","a1");
		nodes.put("f1","e1");
		nodes.put("g1","f1");
		nodes.put("h1","e1");
		
		r("a1");
		System.out.println("====================="); 
		r("a");

		
		
		
		bw.flush();
		bw.close();
	}
	
	public static void r(String node) {
		
		if(!nodes.containsValue(node)){//자식이 없으면 종료
			
			System.out.println("말단 "+node);
			
			return;
		}
		else { //만약 자식이 있으면 출력
			ArrayList<String> keys = new ArrayList<String>();
			
			 
			// node를 부모로 가지는 노드 가져오기
			for(String key : nodes.keySet()) {
				if(nodes.get(key).equals(node)) keys.add(key);
			}
			
			System.out.println(node); // 내꺼 출력
			for(String k : keys) {
				r(k);
			}
			return;
			
		}
	
	}

		
}
