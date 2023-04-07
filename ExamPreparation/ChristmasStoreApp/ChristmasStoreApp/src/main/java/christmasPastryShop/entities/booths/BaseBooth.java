package christmasPastryShop.entities.booths;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.setBoothNumber(boothNumber);
        this.setCapacity(capacity);
        this.setNumberOfPeople(numberOfPeople);
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        if(capacity < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }
    public void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }
    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    public void setPrice() {
        this.price = numberOfPeople * pricePerPerson;
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReserved = true;
        this.setNumberOfPeople(numberOfPeople);
        this.setPrice();
    }
    @Override
    public double getBill() {
        //double amountForCocktails = cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        //double amountForDelicacy = delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        //return amountForCocktails + amountForDelicacy + getPrice();
        double finalPrice = 0;
        double delicacyPrice = 0;
        for (Delicacy delicacy : delicacyOrders) {
            delicacyPrice += delicacy.getPrice();
        }
        double cocktailPrice = 0;
        for (Cocktail cocktail : cocktailOrders) {
            cocktailPrice += cocktail.getPrice();
        }
        return finalPrice = delicacyPrice + cocktailPrice;
    }
    @Override
    public void clear() {
        delicacyOrders.clear();
        cocktailOrders.clear();
        numberOfPeople = 0;
        isReserved = false;
        price = 0;
    }
}
