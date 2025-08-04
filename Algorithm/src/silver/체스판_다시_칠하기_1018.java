package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기_1018 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	}
}
//8*8로 잘라서

//00이 w인 경우
//i+j합 짝수인데 w아닌 경우 + i+j합 홀수인데 b아닌 경우 > count

//00이 b인 경우
//i+j합 홀수인데 w아닌 경우 + i+j합 짝수인데 b아닌 경우 > count

//i,j ~ i+7,j+7 i,j < width-8, height-8까지
//count가 minCount(초기값64)보다 작으면 갱신

//return count