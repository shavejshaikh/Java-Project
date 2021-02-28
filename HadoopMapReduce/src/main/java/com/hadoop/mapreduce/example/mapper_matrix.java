package com.hadoop.mapreduce.example;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;

import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class mapper_matrix
{
	public static class mapper extends Mapper<LongWritable, Text, Text, IntWritable> 
	{
		private final static IntWritable n=new IntWritable(1);
		private Text word= new Text();
		public void map(LongWritable Key, Text Values,Context context) throws IOException,InterruptedException
		{	//Configuration conf=context.getConfiguration();
			String line=Values.toString();
			StringTokenizer st= new StringTokenizer(line," ");
			
			while(st.hasMoreTokens())
			{
				word.set(st.nextToken());
				context.write(word,n);		
			}
		}

	}
	

public class reducer extends Reducer<Text, IntWritable, Text, IntWritable>
{	
	
	public void reduce (Text key, Iterator<IntWritable>value,Context context) throws IOException, InterruptedException {
		int sum=0;
		
		while(value.hasNext())
		{
			sum=sum+value.next().get();
			
		}context.write(key, new IntWritable(sum));
	}

}


public static void main(String[] args) throws Exception {
 Configuration conf = new Configuration();

 Path inputPath = new Path("hdfs://127.0.0.1:9000/input/WordCountSmaple.txt");
 Path outputPath = new Path("hdfs://127.0.0.1:9000/output/matrix");

 Job job = Job.getInstance(conf, "word");
 job.setJarByClass(word.class);
 job.setJobName("WordCounterJob");

 FileInputFormat.setInputPaths(job, inputPath);
 FileOutputFormat.setOutputPath(job, outputPath);

 job.setOutputKeyClass(Text.class);
 job.setOutputValueClass(IntWritable.class);
 job.setOutputFormatClass(TextOutputFormat.class);
 job.setMapperClass(mapper.class); 
 job.setReducerClass(reducer.class);

 FileSystem hdfs = FileSystem.get(URI.create("hdfs://127.0.0.1:9000"), conf);
 
 if (hdfs.exists(outputPath))
  hdfs.delete(outputPath, true);

 //RunningJob runningJob = JobClient.runJob(job);
 //System.out.println("job.isSuccessfull: " + runningJob.isComplete());

}



}

