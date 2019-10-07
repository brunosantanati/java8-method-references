package me.brunosantana.java8_method_references.example2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		
		//Reference to an instance method example ####################
		
		Book book1 = new Book("Domain-Driven Design: Tackling Complexity in the Heart of Software", new BigDecimal("130.00"));
		Book book2 = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", new BigDecimal("202.71"));
		Book book3 = new Book("Test-Driven Development: Teste e Design no Mundo Real", new BigDecimal("59.90"));
		List<Book> bookList = Arrays.asList(book1, book2, book3);
		
		BookComparator bookComparator = new BookComparator();
		
		//using normal Lambda
		bookList.stream()
			.sorted((b1, b2) -> bookComparator.compare(b1, b2)) //Lambda
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("----------------------------------------");
		
		//using method reference
		bookList.stream()
			.sorted(bookComparator::compare) //here is the method reference
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}

}
