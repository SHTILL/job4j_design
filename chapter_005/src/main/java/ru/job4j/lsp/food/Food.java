package ru.job4j.lsp.food;

import java.util.Calendar;

public class Food {
    private String name;
    private Calendar expiryDate;
    private Calendar createDate;
    private double price;

    private double discount;

    public Food(String name, Calendar expiryDate, Calendar createDate, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\''
                + ", expire=" + expiryDate.get(Calendar.DATE) + "/" + expiryDate.get(Calendar.MONTH)
                + ", created=" + createDate.get(Calendar.DATE) + "/" + createDate.get(Calendar.MONTH)
                + ", discount=" + discount
                + '}';
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }
}
