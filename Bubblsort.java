package Sortieralgorithmen;

import java.lang.reflect.Array;
import java.util.Arrays;


public class Bubblsort {

	public static void main(String[] args) {
		
		int [] array = {1,51,215,12,48,7,3};
		bubblesort(array);
		for(int i=0; i < array.length;i++) {
			System.out.println(array[i]);
			
		}
	}
	
	public static int[] bubblesort(int []array)
	{
		int temp=0;
		for(int i=0;i < array.length;i++)
		{
			for(int j=1; j < array.length-i;j++ )
			{
				if(array[j]<array[j-1])
				{
					temp=array[j-1];
					array[j-1]=array[j];
					array[j]=temp;
				}
			}
		}
		return array;
	}
}

