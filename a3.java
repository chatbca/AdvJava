package a3;

import java.util.*;

public class a3 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> arrayList=new ArrayList<>();
		int choice;
		do{
			System.out.println("\n Menu");
			System.out.println("\n1. Add element to the array");
			System.out.println("\n2.sort elements");
			System.out.println("\n3.replace element");
			System.out.println("\n4.remove element");
			System.out.println("\n5.Display all element");
			System.out.println("\n6.Add an element between 2 elements");
			System.out.println("\n7.exit");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			switch(choice)		
			{
				case 1:
					System.out.println("Enter num of elements to be added");
					int numElements=sc.nextInt();
					System.out.println("enter the elements:");
					for(int i=0;i<numElements;i++)
					{
						int element=sc.nextInt();
						arrayList.add(element);
					}
					break;
				case 2:
					Collections.sort(arrayList);
					System.out.println("elements sorted");
					break;
				case 3:
					System.out.println("enter the index of the ele to replace:");
					int replaceIndex=sc.nextInt();
					System.out.println("enter the new Element:");
					int newElement=sc.nextInt();
					arrayList.set(replaceIndex,newElement);
					System.out.println("element replaced");
					break;
				case 4:
					System.out.println("Enter Index of element to remove");
					int removeIndex=sc.nextInt();
					arrayList.remove(removeIndex);
					System.out.println("element removed");
					break;
				case 5:
					System.out.println("ALL elements of array");
					for(int element:arrayList)
					{
						System.out.print(element+" ");
					}
					System.out.println();
					break;
				case 6:
					System.out.println("enter Index after which to add    element");             
					int addIndex=sc.nextInt();
					System.out.println("Enter element to be added");
					int newElementToAdd=sc.nextInt();
					arrayList.add(addIndex+1,newElementToAdd);
					System.out.println("element added");
					break;
				case 7:
					System.out.println("Exiting..");
					break;
				default:
					System.out.println("Invalid choice please try again");
			}
		}while(choice!=7);
		sc.close();
	}
}
