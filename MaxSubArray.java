
import java.util.*;
public class MaxSubArray
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
    }
	    int arr[]=new int [n];
	    for(int i=0;i<n;i++)
	    {
	        arr[i]=sc.nextInt();
	    }
	    int prefix=0,suffix=0;
	    for(int i=0;i<n;i++)
	    {
	        prefix+=arr[i];
	        for(int j =n-1;j>=i;j--)
	        {
	            suffix+=arr[j];
	        }
	        if(prefix==suffix)
	        {
	            System.out.println("SUM IS:"+prefix);
	            System.out.println("POINT IS :"+i);
	            break;
	        }
	        else
	        {
	            suffix=0;
	        }
	    }
	    if(suffix==0)
	    {
	        System.out.println("CAN'T FIND");
	    }
}

