package me.brunosantana.java8_method_references.example5;

interface StringProducer{
	String getString(String message);
}

public class MethodReferenceExample5 {

	public static void main(String[] args) {

		StringProducer stringProducer = String::new;
		//The statement above is the same the statement in the comment bellow:
		//StringProducer stringProducer = (message) -> new String(message);
		System.out.println(stringProducer.getString("Hello World!"));
	}

}
