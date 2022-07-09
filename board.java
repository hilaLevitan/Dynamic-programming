package dynamicProgramming;
//there is a matrix full of numbers and the program needs to choose
//the way that will score the highest score to reach from 0,0 to len-1,len-1 
//(it can move to the right-next column,down -next row and diagonally-next column and next row) 


//The recursive way
public class board {
	public static int board(int[][]mat,int i,int j) {
		if(i==mat.length-1&&j==mat[i].length-1)
			return mat[i][j];//if the program reached the last cell, it's content will be returned
		if(i>=mat.length || j>=mat[i].length) 
			return 0;
		return Math.max(board(mat,i+1,j),Math.max(board(mat,i,j+1),board(mat,i+1,j+1)))+mat[i][j];
	}
//the dynamic way	
	public static int dynamicBoard(int [][]mat) {
		//the function will create a matrix that every cell will contain the highest score that can be scored 
		//from this cell and on.
		int[][]score=new int [mat.length][mat[0].length];
		score[mat.length-1][mat.length-1]=mat[mat.length-1][mat.length-1];
		int op1=0,op2=0,op3=0;
		//explanation to the variables names:
		//op1-the maximum score scored by choosing to move to the next row
		//op2-the maximum score scored by choosing to move to the next column
		//op3-the maximum score scored by choosing to move to the next row and the next column
		for(int i=mat.length-1;i>=0;i--) 
			for(int j=mat[i].length-1;j>=0;j--) {
				if(i==mat.length-1&&j==mat.length-1) continue;
				op1=0;op2=0;op3=0;
				if(i<mat.length-1) op1=score[i+1][j];
				if(j<mat[i].length-1) op2=score[i][j+1];
				if(j<mat[i].length-1&&i<mat.length-1) op3=score[i+1][j+1];
				score[i][j]=Math.max(op1,Math.max(op2,op3))+mat[i][j];
			}
		//printing all the used cells:
		int i=0,j=0;
		System.out.println("[0,0]");
		while(i!=mat.length-1||j!=mat[i].length-1) {
				op1=0;op2=0;op3=0;
				if(i<mat.length-1) op1=score[i+1][j];
				if(j<mat[i].length-1) op2=score[i][j+1];
				if(j<mat[i].length-1&&i<mat.length-1) op3=score[i+1][j+1];
				if(op1==Math.max(op1,Math.max(op2,op3))) 
					System.out.println("["+(++i)+","+j+"]");
				else if(op2==Math.max(op1,Math.max(op2,op3))) 
					System.out.println("["+(i)+","+(++j)+"]");
				else 
					System.out.println("["+(++i)+","+(++j)+"]");
			}
		return score[0][0];
	}
	public static void main(String[] args) {
		int[][]mat= {{2,0,100,2},
			     {20,0,30,32},
			     {39,0,0,10}};
		
		System.out.println(board(mat,0,0));
		System.out.println(dynamicBoard(mat));//returned value: 174

	}

}
