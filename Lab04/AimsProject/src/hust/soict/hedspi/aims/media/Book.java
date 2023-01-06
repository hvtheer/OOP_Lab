package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}

	public Book(int id, String title) {
		super(id, title);
	}

	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.printf("The author has been added successfully\n");
		} else {
			System.out.println("The author is already in Authors' list of this book!");
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.printf("The author has been removed successfully\n");
		} else {
			System.out.println("The author is not already in Authors' list of this book!");
		}
	}

}
