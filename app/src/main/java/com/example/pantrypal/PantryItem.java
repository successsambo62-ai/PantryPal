package com.example.pantrypal;

public class PantryItem {

    private int id;
    private String name;
    private double quantity;
    private String unit;
    private String expiryDate;

    public PantryItem(String name,
                      double quantity,
                      String unit,
                      String expiryDate) {

        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expiryDate = expiryDate;
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

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
