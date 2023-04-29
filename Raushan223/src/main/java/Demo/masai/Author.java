package Demo.masai;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private  double rating;


public Author() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return "Author [id=" + id + ", name=" + name + ", rating=" + rating + "]";
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public double getRating() {
	return rating;
}


public void setRating(double rating) {
	this.rating = rating;
}


public Author(String name, double rating) {
	super();
	this.name = name;
	this.rating = rating;
}



}
