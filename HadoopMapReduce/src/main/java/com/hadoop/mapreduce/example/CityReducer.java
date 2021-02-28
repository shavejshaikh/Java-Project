package com.hadoop.mapreduce.example;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class CityReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, Text> {

	public void reduce(Text t_key, Iterator<IntWritable> values, OutputCollector<Text,Text> output, Reporter reporter) throws IOException {
		Text key = t_key;
		 int sum = 0;
		 int count=0;
		  while (values.hasNext()) {
		   sum = sum + values.next().get();
		   count++;
		   }
		   String out = "\tActive Trip: " + sum + " :: "+"Per Day: "+ count;;
		   output.collect(key, new Text(out));

	}
}