package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5653_줄기세포배양_시간초과 {

	static int N;
	static int M;
	static int K; 
	static int cnt;
	static int[][][] cells;
	static int[][][] nextCells; // [1]에 timer, timer는 없는 칸 0, 비활성화인 칸 -1로
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			cells = new int[N + 2 * K][M + 2 * K][2];

			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					cells[y + K][x + K][0] = Integer.parseInt(st.nextToken());
					cells[y + K][x + K][1] = 2 * cells[y + K][x + K][0];//같아지면 활성화
				}
			}
			
			bfs();
			
			cnt = 0;
		    for (int y = 0; y < N + 2 * K; y++) {
		        for (int x = 0; x < M + 2 * K; x++) {
		            if (cells[y][x][1] > 0) cnt++;
		        }
		    }
		    
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void bfs() {
		queue = new ArrayDeque<>();
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (cells[y + K][x + K][0] != 0)
					queue.offer(new int[] { y + K, x + K });
			}
		}

		for (int k = 0; k < K; k++) {//시간동안
			nextCells = new int[N + 2 * K][M + 2 * K][2];
			int cellsNum = queue.size();
			for (int n = 0; n < cellsNum; n++) {
				int[] cur = queue.poll();
				int sy = cur[0];
				int sx = cur[1];
				
				if(cells[sy][sx][1] == cells[sy][sx][0]) { 
					for (int i = 0; i < 4; i++) {
						int ny = sy + dy[i];
						int nx = sx + dx[i];
						if(cells[ny][nx][0] != 0) continue; 
						if(nextCells[ny][nx][0] >= cells[sy][sx][0]) continue;
						nextCells[ny][nx][0] = cells[sy][sx][0];
						nextCells[ny][nx][1] = 2 * cells[sy][sx][0];
					}
				}
				cells[sy][sx][1]--; //timer 감소
				if (cells[sy][sx][1] > 0) queue.offer(new int[] { sy, sx });
			}
			for (int y = 0; y < N + 2 * K; y++) {
	            for (int x = 0; x < M + 2 * K; x++) {
	                if (nextCells[y][x][0] > 0 && cells[y][x][0] == 0) {
	                    cells[y][x][0] = nextCells[y][x][0];
	                    cells[y][x][1] = nextCells[y][x][1];
	                    queue.offer(new int[] {y, x});
	                }
	            }
	        }
		}
	}
}