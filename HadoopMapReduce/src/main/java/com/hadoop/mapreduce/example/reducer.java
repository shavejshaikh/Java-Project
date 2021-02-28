package com.hadoop.mapreduce.example;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class reducer extends Reducer<Text,Text,Text,Text>
{
	public void red(Text key,Iterable<Text> values,Context context) throws IOException , InterruptedException
	{
		String [] value;
		HashMap<Integer,Float>hashA=new HashMap<Integer,Float>();
		HashMap<Integer,Float>hashB=new HashMap<Integer,Float>();
		
		for(Text val:values)
		{
			value=val.toString().split(",");
			if(value[0].equals("A"))
			{
				System.out.println("Sahi hai");
				hashA.put(Integer.parseInt(value[1]),Float.parseFloat(value[2]));
			}
			else
			{
				System.out.println("Mast haoi");
				hashB.put(Integer.parseInt(value[1]),Float.parseFloat(value[2]));
			}
		}
		
		for(Float value1:hashA.values())
		{
			System.out.println("A  "+value1);
		}
		
		Float a_ij;
		Float b_ij;
		
		int n=Integer.parseInt(context.getConfiguration().get("n"));
		
		Float result=0.0F;
		
		for(int k=0;k<n;k++)
		{
			a_ij=hashA.containsKey(k)? hashA.get(k):0.0F;
			System.out.println(""+a_ij);
			b_ij=hashB.containsKey(k)? hashB.get(k):0.0F;
			System.out.println(""+b_ij);
			
			result=a_ij*b_ij;
			
			if(result!=0.0F)
			{
				context.write(null, new Text(key.toString()+" ,"+Float.toString(result)));
			}
		}
			
		
		
	}
}
