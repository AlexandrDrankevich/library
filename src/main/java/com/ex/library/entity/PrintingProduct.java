package com.ex.library.entity;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;

public class PrintingProduct implements Serializable {

	@Serial
	private static final long serialVersionUID = 2787232361672994772L;
	@Id
	private long id;
	private String author;
	private String publisher;
	private String name;
	private Date releaseDate;

	public PrintingProduct() {
	}

	public PrintingProduct(long id, String name, String author, String publisher, Date releaseDate) {
		this.id = id;
		this.author = author;
		this.publisher = publisher;
		this.name = name;
		this.releaseDate = releaseDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, name, publisher, releaseDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrintingProduct other = (PrintingProduct) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(publisher, other.publisher) && Objects.equals(releaseDate, other.releaseDate);
	}

	@Override
	public String toString() {
		return "PrintingProduct [id=" + id + ", author=" + author + ", publisher=" + publisher + ", name=" + name
				+ ", releaseDate=" + releaseDate + "]";
	}
}
