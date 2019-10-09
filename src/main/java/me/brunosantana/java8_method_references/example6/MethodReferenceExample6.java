package me.brunosantana.java8_method_references.example6;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample6 {

	public static void main(String[] args) {
		
		//Reference to a constructor example ####################
		//Example base on the page: https://www.baeldung.com/java-method-references
		
		List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
		
		exampleUsingLambda(bikeBrands);
		
		exampleUsingMethodReference(bikeBrands);

	}

	private static void exampleUsingLambda(List<String> bikeBrands) {

		Bicycle[] bicycles = bikeBrands.stream()
				.map((brand) -> new Bicycle(brand))
				.toArray(size -> new Bicycle[size]);
		
		System.out.println(Arrays.deepToString(bicycles));
	}
	
	private static void exampleUsingMethodReference(List<String> bikeBrands) {
		
		Bicycle[] bicycles = bikeBrands.stream()
				.map(Bicycle::new)
				.toArray(Bicycle[]::new);
		
		System.out.println(Arrays.deepToString(bicycles));
	}

}

class Bicycle {
	 
    private String brand;
    
    public Bicycle(String brand) {
        this.brand = brand;
    }

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Bicycle [brand=" + brand + "]";
	}
}