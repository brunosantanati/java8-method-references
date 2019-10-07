package me.brunosantana.java8_method_references.example1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class MethodReferencesExample1 {

	public static void main(String[] args) {
		
		//Reference to a static method example ####################
		
		List<String> languages = Arrays.asList("java", "php", "c");
		
		//using normal Lambda
		languages.stream()
			.map(language -> StringUtils.capitalize(language))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//using method reference
		languages.stream()
			.map(StringUtils::capitalize)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
	}

}
