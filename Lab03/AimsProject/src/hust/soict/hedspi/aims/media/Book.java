package hust.soict.hedspi.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		int n = authors.size();
		int check = 0;
		for (int i=0;i<=n;i++) {
			if (authors.get(i)== authorName) {
				check = 1;
				break;
			}
		}
		if (check == 1) System.out.println("This author name already existed!");
		else if (check == 0) authors.add(authorName);
	}

	public void removeAuthor(String authorName) {
		int n = authors.size();
		int check = 0;
		for (int i = 0; i<= n; i++) {
			if (authors.get(i)== authorName) {
				check = i;
				break;
			}
		}
		if (check == 0) System.out.println("This author name doesn't exist!");
		else authors.remove(check);
	}
}
