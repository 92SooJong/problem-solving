
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		// �Է�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//����
		
		String s = bf.readLine(); //String
		
		
		String[] answer = s.split(" ");
		int result = Integer.valueOf(answer[0]) + Integer.valueOf(answer[1]);
		
		
		
		bw.write(String.valueOf(result)); // 
		bw.flush();//�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();//��Ʈ���� ����
		
		
	}

}
