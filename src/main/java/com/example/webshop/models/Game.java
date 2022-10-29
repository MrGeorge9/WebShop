package com.example.webshop.models;

public class Game {

    private String name;
    private String genre;
    private int year;
    private String description;
    private int price;
    private int quantity;

    private int review;


    public Game() {
    }

    public Game(String name, String genre, int year, String description, int price, int quantity) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Game(String name, String genre, int year, String description, int price, int quantity, int review) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }
}
