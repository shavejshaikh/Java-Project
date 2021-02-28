package com.hadoop.mapreduce.example;

import java.io.IOException;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.io.*;

public class MovieMapper extends Mapper<LongWritable,Text,Text,FloatWritable>{
	
	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
		
		String line=value.toString();
		String[] parts=line.split(",");
		context.write(new Text(parts[1]),new FloatWritable(Float.parseFloat(parts[2])));
	}
	
}
