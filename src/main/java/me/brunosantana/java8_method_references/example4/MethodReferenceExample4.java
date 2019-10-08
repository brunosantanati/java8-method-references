package me.brunosantana.java8_method_references.example4;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample4 {

	public static void main(String[] args) {
		
		Function<String, Job> jobCreator = Job::new;
		//the above statement is equivalent to
		Function<String, Job> jobCreator2 = (jobName) -> { return new Job(jobName); };
		
		Supplier<Job> jobCreator3 = Job::new;
		//the above statement is equivalent to
		Supplier<Job> jobCreator4 = () -> { return new Job(); };
		
		System.out.println(jobCreator.apply("Developer"));
		System.out.println(jobCreator2.apply("Architect"));
		System.out.println(jobCreator3.get());
		System.out.println(jobCreator4.get());

	}

}

class Job{
	
	private String name;
	
	Job(){
	}

	Job(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Job [name=" + name + "]";
	}
	
}