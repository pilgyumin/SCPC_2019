package pro_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
	
	static class Obstacle{
		int l;
		int r;
		int h;
		
		public Obstacle(int l, int r, int h) {
			this.l = l;
			this.r = r;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Obstacle [l=" + l + ", r=" + r + ", h=" + h + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			String[] rse = br.readLine().split(" ");
			int r = Integer.parseInt(rse[0]);
			int s = Integer.parseInt(rse[1]);
			int e = Integer.parseInt(rse[2]);
			
			int n = Integer.parseInt(br.readLine());
			
			Obstacle[] ar = new Obstacle[n];
			double ans = 0.0;
			
			for(int i = 0; i < n; i++) {
				String[] lrh = br.readLine().split(" ");
				int le = Integer.parseInt(lrh[0]);
				int ri = Integer.parseInt(lrh[1]);
				int he = Integer.parseInt(lrh[2]);
				ar[i] = new Obstacle(le, ri, he);
			}
			
			for(int i = 0; i < n; i++) {
				if(i == 0) {
					ans += ((ar[i].l - s) - r);
					if(ar[i].h >= r) {
						ans += (ar[i].h - r) * 2;
						ans += r * Math.PI;
					}
					else {
						double acos = ar[i].h / (double)r;
						double oppdegree = Math.toDegrees(Math.acos(acos));
						double degree = 180 - oppdegree;
						double len = 4 * Math.PI * r * (degree / 360);
						ans += len;
					}
					ans += (ar[i].r - ar[i].l);
				}
				else if(i == n-1){
					ans += ((ar[i].l - ar[i-1].r) - (2 * r));
					ans += ((e - ar[i].r) - r);
					if(ar[i].h >= r) {
						ans += (ar[i].h - r) * 2;
						ans += r * Math.PI;
					}
					else {
						double acos = ar[i].h / (double)r;
						double oppdegree = Math.toDegrees(Math.acos(acos));
						double degree = 180 - oppdegree;
						double len = 4 * Math.PI * r * (degree / 360);
						ans += len;
					}
					ans += (ar[i].r - ar[i].l);
				}
				else {
					
					ans += ((ar[i].l - ar[i-1].r) - (2 * r));
					if(ar[i].h >= r) {
						ans += (ar[i].h - r) * 2;
						ans += r * Math.PI;
					}
					else {
						double acos = ar[i].h / (double)r;
						double oppdegree = Math.toDegrees(Math.acos(acos));
						double degree = 180 - oppdegree;
						double len = 4 * Math.PI * r * (degree / 360);
						ans += len;
					}
					ans += (ar[i].r - ar[i].l);
				}
			}
			BigDecimal bd = new BigDecimal(ans);
			bd = bd.setScale(12,RoundingMode.DOWN);
			bw.write("Case #" + t + "\n");
			bw.write(bd.toString() + "\n");
		}
		bw.flush();
	}
}
