/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */

				
package Graph;

public class DFS2DGrid {

	static int ROW =5,COLUMN =5;
	
	static boolean isSafe(int[][] M,int row,int column,boolean[][] isVisited){
		return (row>=0) && (column>=0) && (row<ROW) && (column<COLUMN) && (M[row][column]==1 && !isVisited[row][column]);
	}
	
	void DFS(int[][] M,boolean[][] isVisited,int row,int column){
		
		//this array is used to find the eight Neighbours of a given cell
		int[] rowNumbr =	{-1,-1,-1,0,0,1,1,1};
		int[] columnNmbr=	{-1,0,1,-1,1,-1,0,1};
		
		//marking this cell as VIsited
		isVisited[row][column] = true;
		
		for(int i=0;i<8;i++){
			if(isSafe(M, row+rowNumbr[i], column+columnNmbr[i], isVisited)){
				DFS(M, isVisited, row+rowNumbr[i], column+columnNmbr[i]);
			}
		}
	}
	
	int countIsland(int[][] M){
		boolean[][] visited = new boolean[ROW][COLUMN];
		int count =0;
		
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COLUMN;j++){
				if(M[i][j]==1 && !visited[i][j]){
					DFS(M, visited, i, j);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] arg){
		  int M[][]=  new int[][] {{1, 1, 0, 0, 0},
              {0, 1, 0, 0, 1},
              {1, 0, 0, 1, 1},
              {0, 0, 0, 0, 0},
              {1, 0, 1, 0, 1}
             };
             
             DFS2DGrid ob = new DFS2DGrid();
             System.out.println("NUmber of Island "+ob.countIsland(M));
	}
}
