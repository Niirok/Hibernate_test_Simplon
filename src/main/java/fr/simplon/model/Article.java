package fr.simplon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticle;

    private String description;
    private String brand;

    @Column(name = "UnitaryPrice")
    private double price;

    public Article(String descr, String brand, double price) {
        this.description = descr;
        this.brand = brand;
        this.price = price;
    }

    public Article() {
        this("unknown", "unknown", 0);
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Article [idArticle=" + idArticle + ", description=" + description +
                ", brand=" + brand + ", price=" + price + "]";
    }

}
