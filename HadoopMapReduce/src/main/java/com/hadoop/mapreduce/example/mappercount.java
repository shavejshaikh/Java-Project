package com.hadoop.mapreduce.example;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

//import org.apache.hadoop.conf.Configuration;
import java.util.*;

public class mappercount extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> 
{
	private final static IntWritable n=new IntWritable(1);
	private Text word= new Text();
	public void map(LongWritable Key, Text Values,OutputCollector<Text, IntWritable> collector, Reporter reporter) throws IOException
	{	//Configuration conf=context.getConfiguration();
		String line=Values.toString();
		StringTokenizer st= new StringTokenizer(line," ");
		
		while(st.hasMoreTokens())
		{
			word.set(st.nextToken());
			collector.collect(word,n);		}
	}

}
