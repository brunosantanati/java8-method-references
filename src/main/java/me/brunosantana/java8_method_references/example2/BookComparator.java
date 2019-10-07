package me.brunosantana.java8_method_references.example2;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		return b1.getPrice().compareTo(b2.getPrice());
	}
}
