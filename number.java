package dynamicProgramming;
//we are given an array of numbers and a number
//we are asked if there is any option we can combine the numbers from the array to the given number
//we do not have to use all the numbers and we're allowed to use the same number more than once

//the recursive way:
public class number {
	public static boolean num(int num,int[]arr,int i) {
		if(i>=arr.length) return false;
		if(num==0) return true;
		if(num<0) return false;
		return num(num-arr[i],arr,i+1)|| num(num-arr[i],arr,i)||num(num,arr,i+1);
		
	}
//the dynamic way:
	public static boolean dynamicNum(int num,int arr[]) {
		boolean []arrB=new boolean [num+1];
		arrB[0]=true;
		for(int i=0;i<arrB.length;i++) {
			if(arrB[i]) {
				for(int j=0;j<arr.length;j++) {
					if(arr[j]+i<=num) arrB[arr[j]+i]=true;
				}
			}
		}
		//printing an option
		if(arrB[num]) {
			int i=num;
			for(int j=i-1;j>=0;j--)
				if(arrB[j]) 
					for(int k=0;k<arr.length;k++)
						if(arr[k]==i-j) {
							System.out.print((i-j)+", ");
							i-=(i-j);
						}
		}
		return arrB[num];
	}

	public static void main(String[] args) {
		int[]arr= {7,2};
		System.out.println(dynamicNum(11,arr));
	}

}
