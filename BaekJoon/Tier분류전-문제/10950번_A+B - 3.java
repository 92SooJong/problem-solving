import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//����
		
		String testCase = bf.readLine(); //String
		for(int i=0; i<Integer.valueOf(testCase); i++) {
			String[] s = bf.readLine().split(" "); //String
			int ans = Integer.valueOf(s[0]) + Integer.valueOf(s[1]);
			bw.write(ans + "\n");
			
			
		}
		bw.flush();//�����ִ� �����͸� ��� ��½�Ŵ
		
		
		
		bw.close();//��Ʈ���� ����
		
		
		
		
	}
		
}
