package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17103_골드바흐파티션 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int max = 1000000;
		
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) isPrime[i] = true;
        for (int i = 2; i * i <= max; i++)
            if (isPrime[i])
                for (int j = i * i; j <= max; j += i) 
                    isPrime[j] = false;
		
		for(int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			
			for(int i = 2; i <= N / 2; i++){//짝수이므로 2는 포함 x, 중복 방지로 N/2까지만
				if(isPrime[i] && isPrime[N - i]) count++;
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
