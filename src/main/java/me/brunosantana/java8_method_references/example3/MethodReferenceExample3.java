package me.brunosantana.java8_method_references.example3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class MethodReferenceExample3 {

	public static void main(String[] args) {
		
		//Reference to a constructor example ####################
		//Example based in the official doc: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
		
		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Bruno"));
		roster.add(new Person("Enzo"));
		roster.add(new Person("Íris"));
		
		exampleUsingLambda(roster);
		
		exampleUsingMethodReference(roster);

	}

	private static void exampleUsingLambda(List<Person> roster) {
		Set<Person> rosterSetLambda = transferElements(roster, () -> { return new HashSet<>(); }); //Lambda
		System.out.println(rosterSetLambda);
	}
	
	private static void exampleUsingMethodReference(List<Person> roster) {
		Set<Person> rosterSet = transferElements(roster, HashSet::new); //here is the method reference
		
		//Above, the Java compiler infers that you want to create a HashSet collection that contains elements of type Person. Alternatively, you can specify this as follows:
		//Set<Person> rosterSet = transferElements(roster, HashSet<Person>::new);
		
		System.out.println(rosterSet);
	}

	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
			SOURCE sourceCollection, Supplier<DEST> collectionFactory) {

		DEST result = collectionFactory.get();
		for (T t : sourceCollection) {
			result.add(t);
		}
		return result;
	}

}

class Person{
	
	private String name;

	public Person(String name) {
		super();
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
		return "Person [name=" + name + "]";
	}
}