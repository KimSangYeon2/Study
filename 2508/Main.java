package solvedAc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		String ssafyStr = "SSAFY";

		char[] ssafyArray = new char[ssafyStr.length()];

		for (int i = 0; i < ssafyArray.length; i++) {
			ssafyArray[i] = ssafyStr.charAt(i);
		}

		System.out.println("그냥 출력 : "+ new String(ssafyArray));
			for (int i = 0; i < ssafyArray.length; i++) {
			  System.out.print(ssafyArray[i]);
		}
	}
}


// 알파벳이 짝수일 경우
// 각 알파벳이 짝수개이면
// 펠린드롬이 간능
// 아니면 불가능
// 알파벳이 홀수일 경우
// 가운데 알파벳 제외하고
// 각 알파벳이 짝수개이면
// 펠린드롬이 간능
// 아니면 불가능