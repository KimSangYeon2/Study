package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11053_가장_긴_증가하는_부분_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] dp = new int[N];
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) nums[n] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1; //해당 배열서부터 counting 전 최대길이, 자신만 포함
			for(int j = 0; j < i; j++) { //이전 까지 dp중 최소값 찾기
				if(nums[i] > nums[j])//이전 숫자가 더 작은 경우만
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			count = Math.max(count, dp[i]);
		}
		
		System.out.println(count);
	}
}
