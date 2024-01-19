import java.util.*;

public class naturalsorting {

    public static void main(String[] args) {


        int f=0;

        String[] obj  = new String[]{"anna", "elsa", "sara"};

        for(int i=0;i< obj.length;i++)

        {

            f=i;

            for(int j=i+1;j< obj.length;j++)

            {

                if(obj[f].compareTo(obj[j])>0)

                {

                    f=j;

                }

            }

            String temp=obj[f];

            obj[f]=obj[i];

            obj[i]=temp;

        }


        for(String i: obj)

        {

            System.out.print(i+" ");

        }

    }

}