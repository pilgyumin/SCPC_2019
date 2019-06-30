package pro_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test = Integer.parseInt(br.readLine());
		int[] cache = new int[1000001];
		cache[1] = 0;

		for (int i = 2; i <= 1000000; i++) {
			if(cache[i] == 0) {
				int count = 0;
				int play = i;
				while (cache[play] == 0 && play > 1) {
					if (play % 2 == 0) {
						play /= 2;
						count++;
					} else {
						play += 1;
						count++;
					}
				}
				count += cache[play];
				cache[i] = count;
				for(int j = i+i; j <= 1000000; j *= 2) {
					if(cache[j] == 0) {
						cache[j] = cache[j/2] + 1;
					}
				}
			}
		}
		
		int[] ar = new int[1000001];
		
		int add = 0;
		for(int i = 1; i <= 1000000; i++) {
			add += cache[i];
			ar[i] = add;
		}
		
		for (int t = 1; t <= test; t++) {
			String[] s = br.readLine().split(" ");
			int n1 = Integer.parseInt(s[0]);
			int n2 = Integer.parseInt(s[1]);
			
			bw.write("Case #" + t + "\n");
			bw.write(ar[n2] - ar[n1-1] + "\n");
		}
		bw.flush();
	}
}
