package com.hadoop.mapreduce.example;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import java.io.IOException;
import java.util.Iterator;

public class reducercount extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>
{	
	
	public void reduce (Text key, Iterator<IntWritable>value,OutputCollector<Text, IntWritable> output,
			   Reporter reporter) throws IOException {
		int sum=0;
		
		while(value.hasNext())
		{
			sum=sum+value.next().get();
			
		}output.collect(key, new IntWritable(sum));
	}

}
