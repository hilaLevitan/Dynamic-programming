package dynamicProgramming;

//Write a function that calculates the number of n-bit sequences
//that do not contain a sequence of k (1<k<n) zeros
//for example: for n=4, k=2 there are 8 sequences (0101, 0110,0111,1010,1011,1101,1110,1111)


public class sequences {
	
public static int rec(int n,int k) {		
	if (n<k)return (int)(Math.pow(2, n));
	if(n==k)
		return (int)(Math.pow(2, n))-1;
	int sum=0;
	for(int i=n-1;i>=n-k;i--) 
		sum+=rec(i,k);
	return sum;
	/*
	1001
	1010
	1011
	1100
	1101
	1110
	1111
	0100
	0101
	0110
	0111
	0010
	0011	
	*/
	
}
	public static int dynamic(int n,int k) {
		int []arr=new int [n+1];
		arr[0]=0;
		for(int i=1;i<=n;i++) {
			if(i<k) arr[i]=  (int)(Math.pow(2, i));
			else
				if(i==k) arr[i]=(int)(Math.pow(2, i))-1;
				else
					for(int j=i-1;j>=i-k;j--) 
						arr[i]+=arr[j];
		}
		return arr[n];
	}


	public static void main(String[] args) {
		System.out.println(rec(4,3 ));
		System.out.println(dynamic(4,3 ));

	}

}
