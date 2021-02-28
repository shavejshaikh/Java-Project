package com.hadoop.mapreduce.example;

import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.*;

import java.net.URI;
import java.io.IOException;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;


public class MovieDriver {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Configuration conf= new Configuration();
		Job job=Job.getInstance(new Configuration());
		job.setJarByClass(MovieDriver.class);
		job.setJobName("Movie Lens Database");
		
		job.setMapperClass(MovieMapper.class);
		job.setReducerClass(MovieReducer.class);
		
		Path inputPath = new Path("hdfs://127.0.0.1:9000/input/ratings");
		Path outputPath = new Path("hdfs://127.0.0.1:9000/output/recom");

		
		FileInputFormat.addInputPath(job, inputPath);
		FileOutputFormat.setOutputPath(job, outputPath);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		
		
		FileSystem hdfs = FileSystem.get(URI.create("hdfs://127.0.0.1:9000"), conf);
	       
		if (hdfs.exists(outputPath))
	        hdfs.delete(outputPath, true);

	   	 

		
		System.exit(job.waitForCompletion(true)?0:1);
		

	}

}
