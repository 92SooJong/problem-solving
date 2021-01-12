import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Main {
	
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static ArrayList<Integer> temp = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Integer.valueOf(br.readLine());
		String[] nArray = br.readLine().split(" ");
		for(int i=0; i<nArray.length; i++) {
			numbers.add(Integer.valueOf(nArray[i]));
		}
		
		hap(0);
		bw.write(Collections.max(temp) + "\n");
		
		bw.close();
	}
	
	public static int hap(int n) {
		
		if(numbers.size() == n) {
			return 0;
		}
		else {
			
			temp.add(numbers.get(n));
			int a = hap(n+1) + numbers.get(n); //현재숫자를 더한뒤 넘긴다
			int b = numbers.get(n);
			
			temp.add(a);
			temp.add(b);
			
			if(a>b) return a;
			return b;
			
		}
		
		
	
	}

		
}
