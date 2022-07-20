package dynamicProgramming;
//Given two positive numbers, the task is to calculate 
//the number of ways we can sum numbers in that range
//and get the higher number
//example: input: n=2,m=6  output: 4
//(2+2+2,2+4,3+3,6)

public class range {
	
	public static int rec(int n,int m) {
		if(m==0) return 1;
		if(n>m||m<0) return 0;
		return rec(n,m-n)+rec(n+1,m);
	}
	
	
	public static int dynamic(int n,int m) {
		
		//the rows will represent the n and the column the m
		int [][]mat=new int [m-n+2][m+1];
		
		//in order to get 0 we there is one option (use no number at all) 
		for(int i=0,j=0;i<mat.length;mat[i++][j]++);
		
		for(int i=1;i<mat.length;i++) 
			for(int j=1;j<mat[i].length;j++) {
				mat[i][j]=mat[i-1][j];
				if((i+n-1)<=j)
					mat[i][j]+=mat[i][j-(i+n-1)];
			}
		//   0 1 2 3 4 5 6 =m
		// {{1,0,0,0,0,0,0},
		//2 {1,0,1,0,1,0,1},
		//3 {1,0,1,1,1,1,2},
		//4 {1,0,1,1,2,1,3},
		//5 {1,0,1,1,2,2,3},
		//6 {1,0,1,1,2,2,4}}
		//=n
		
		return mat[m-n+1][m];
	}

	public static void main(String[] args) {
		System.out.println(rec(2,6));//output:4
		System.out.println(dynamic(1,6));//output:11

	}

}
