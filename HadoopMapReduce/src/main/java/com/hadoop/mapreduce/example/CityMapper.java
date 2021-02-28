package com.hadoop.mapreduce.example;
import java.io.IOException;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.*;

public class CityMapper extends MapReduceBase implements Mapper <LongWritable, Text, Text, IntWritable> {
	//private final static IntWritable one = new IntWritable(1);

	
	public void map(LongWritable key, Text value, OutputCollector <Text, IntWritable> output, Reporter reporter) throws IOException {

		String valueString = value.toString();
		String[] CityData = valueString.split(",");
		//output.collect(new Text(CityData[7]), one);
		String product=CityData[0];
		//String city=CityData[5];
		//String pro=CityData[4];
		
		try{
			int money=Integer.parseInt(CityData[3]);
			//System.out.println("Trip id "+product+"Trip "+money);
			output.collect(new Text("Trip-id "+product),new IntWritable(money));
		}
		 catch (Exception e) {
			   e.printStackTrace();
			  }
	}
}