package Graph;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
*/
public class BFS2D {
    static class cell {
        int x;
        int y;

        public cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    Queue<cell> queue = new LinkedList<cell>();
    boolean isVisited[][] =new boolean[4][4];
    int level[][] = new int[4][4];
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

   void bfs(int sx,int sy){
    queue.add(new cell(sx,sy));
    isVisited[sx][sy] = true;
    level[sx][sy] =1;
    while (queue.size()!=0){
        cell top = queue.poll();
        System.out.println(top.x+"  "+top.y);
        for(int i=0;i<4;i++){
            int tx = top.x+dx[i];
            int ty = top.y+dy[i];
            if(tx>=0 && tx<4 && ty>=0 && ty<4 && !isVisited[tx][ty]){
                isVisited[tx][ty] = true;
                level[tx][ty] = level[top.x][top.y]+1;
                queue.add(new cell(tx,ty));
            }
        }
    }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       BFS2D ob = new BFS2D();
       ob.bfs(0,0);
    }
}
