package dynamicProgramming;


//An ordered integer is an integer whose digits form a non-descending serie 
//(the units<=the tens, the tens<=the hundreds, and so on) and does not
//contain the digit 0 .
//6654211 is an ordered number but 8765843 and 980 are not.
//write a function that will calculate the number of ordered integers
//with n digits. the running time should be O(n)
public class orderedInteger 
{
	public static int rec(int n,int d) {
		if(d==1) return 1;
		if(n==1) return d;
		return rec(n-1,d)+rec(n,d-1);
	}
	
	
	public static int dynamic(int n) {
		
		int [][]mat=new int[9][n+1];
		//there is one option to make number in any size using the 1 digit 
		for(int i=1;i<mat[0].length;i++)
			mat[0][i]=1;
		
		for(int i=0;i<mat.length;i++)
			mat[i][1]=i+1;
		
		for(int i=1;i<9;i++) 
			for(int j=2;j<mat[i].length;j++)
				mat[i][j]=mat[i-1][j]+mat[i][j-1];
		return mat[8][n];	
		/*
		  0 1 2 =n
		1 0,1,1
		2 0,2,3
		3 0,3,6
		4 0,4,10
		5 0,5,15
		6 0,6,21
		7 0,7,28
		8 0,8,36
		9 0,9,45
		d */
	}

	public static void main(String[] args)
	{
		
		System.out.println(rec(2,9));
		System.out.println(dynamic(2)); //output:45
	}

}
