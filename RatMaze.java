public class Main
{
    static int path_row[]={0,0,1,-1};
	static int path_col[]={1,-1,0,0};
	public static void main(String[] args) {
	   	int maze[][]={{1,1,0,1},
		              {0,1,1,1},
		              {0,1,0,1},
		              {0,1,1,1}};
		int visit[][]={{0,0,0,0},
		              {0,0,0,0},
		              {0,0,0,0},
		              {0,0,0,0}};
	 
		findpath(maze,visit,0,0,3,3,0);
		
	}
	static void findpath(int maze[][],int visit[][],int row,int col,int desrow,int descol,int move)
	{
	    if((row==desrow)&&(col==descol))
	    {
	        for(int i=0;i<4;i++){
	            for(int j=0;j<4;j++){
	                System.out.print(visit[i][j]+" ");
	            }
	            System.out.println();
	        }
	        System.out.println("////////////////////////////////////////");
	    }
	    else
	    {
	      for(int i=0;i<path_row.length;i++)
	      {
	          int rowN=row+path_row[i];
	          int colN=col+path_col[i];
	          if(canMove(maze,visit,rowN,colN))
	          {
	              move++;
	              visit[rowN][colN]=move;
	              findpath(maze,visit,rowN,colN,desrow,descol,move);
	              move--;
	              visit[rowN][colN]=0;
	          }
	          
	      }
	    }
	       
	      
	}
	static boolean canMove(int[][] maze,int[][] visit,int rowN,int colN)
	{
	    if((rowN>=0)&&(rowN<4)&&(colN>=0)&&(colN<4)&&(maze[rowN][colN]==1)&&(visit[rowN][colN]==0))
	    {
	      return true;
	     
	    }
	    return false;
	}
}

/*
output:
0 1 0 0 
0 2 3 4 
0 0 0 5 
0 0 0 6 
////////////////////////////////////////
0 1 0 0 
0 2 0 0 
0 3 0 0 
0 4 5 6 
////////////////////////////////////////
*/
