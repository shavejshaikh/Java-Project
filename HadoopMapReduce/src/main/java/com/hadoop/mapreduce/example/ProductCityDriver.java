package com.hadoop.mapreduce.example;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class ProductCityDriver {
    public static void main(String[] args) throws Exception 
    {
        JobClient my_client = new JobClient();
        // Create a configuration object for the job
        Configuration conf = new Configuration();
        
        JobConf job_conf = new JobConf(conf,ProductCityDriver.class);

        

		Path inputPath = new Path("hdfs://127.0.0.1:9000/input/uber.txt");
		Path outputPath = new Path("hdfs://127.0.0.1:9000/output/uber");

		job_conf.setJarByClass(ProductCityDriver.class);
        
        
        // Set a name of the Job
        job_conf.setJobName("SalePerCity");
        
        FileInputFormat.setInputPaths(job_conf, inputPath);
        FileOutputFormat.setOutputPath(job_conf,outputPath);

        // Specify data type of output key and value
        job_conf.setOutputKeyClass(Text.class);
        job_conf.setOutputValueClass(IntWritable.class);

        // Specify names of Mapper and Reducer Class
        job_conf.setMapperClass(CityMapper.class);
        job_conf.setReducerClass(CityReducer.class);

        // Specify formats of the data type of Input and output
        job_conf.setInputFormat(TextInputFormat.class);
        job_conf.setOutputFormat(TextOutputFormat.class);

        // Set input and output directories using command line arguments, 
        //arg[0] = name of input directory on HDFS, and arg[1] =  name of output directory to be created to store the output file.

        
        
        FileSystem hdfs = FileSystem.get(URI.create("hdfs://127.0.0.1:9000"), conf);
        
        if (hdfs.exists(outputPath))
         hdfs.delete(outputPath, true);
        
        my_client.setConf(job_conf);
        try {
            // Run the job 
            JobClient.runJob(job_conf);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 

   
}


