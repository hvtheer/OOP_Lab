package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {

	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
			new MediaComparatorByCostTitle();

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public Media(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(String string) {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		return Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Media [" + id + " - " + title + " - " + category + " - " + cost + "$]\n";
	}

    public void setTitle(String title) {
    }
	
}
