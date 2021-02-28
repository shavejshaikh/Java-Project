package com.hadoop.mapreduce.example;

import org.apache.hadoop.mapreduce.*;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class MovieReducer extends Reducer<Text,FloatWritable,Text,FloatWritable>{
	
	public void reduce(Text key,Iterable<FloatWritable> values,Context context)
		throws IOException, InterruptedException
	{
		float count=0;
		float sum=0;
		float average=0;
		for(FloatWritable value:values)
		{
			sum=sum+value.get();
			count++;
		}
		average=sum/count;
		context.write(key, new FloatWritable(average));
	}

}
