package a2;

import java.io.*;
import java.util.*;
public class a2
{
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int n,i;
		System.out.println("enter the size:");
		n=sc.nextInt();
		List<Integer>num=new ArrayList<>();
		System.out.println("enter the array:");
		for(i=0;i<n;i++)
		{
			num.add(sc.nextInt());
		}
                Integer max=Collections.max(num);
                Integer min=Collections.min(num);	
                num.remove(max);
                num.remove(min);
                Integer secmax=Collections.max(num);
                Integer secmin=Collections.min(num);
		System.out.println("The second smallest element is:"+secmin);
		System.out.println("second largest element is :"+secmax);
	}
}
