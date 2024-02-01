import java.util.Scanner;
public class maneuvering {
 
     static int path(int m , int n) {
         if(m==1 || n==1) 
             return 1;
         
         return path(m-1,n)+path(m,n-1);
     }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
         System.out.println("Enter test cases : ");
         c=sc.nextInt();
         while(c-- > 0)
         {
            System.out.println("Enter number of rows and columns : ");
          a=sc.nextInt();
          b=sc.nextInt();
          
     
         System.out.println(path(a,b));
            
         }
          
        
    }
}
