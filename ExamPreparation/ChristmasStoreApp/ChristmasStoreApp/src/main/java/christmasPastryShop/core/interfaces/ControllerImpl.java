package christmasPastryShop.core.interfaces;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.DelicacyRepositoryImpl;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);
        if(delicacy == null){
            if(type.equals("Ginderbread")){
                delicacy = new Gingerbread(name, price);
            }else if(type.equals("Stolen")){
                delicacy = new Stolen(name, price);
            }else{
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
            }
        }
        delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED, type, name);
    }

    @Override
    public String addCocktail(String type, String name, int portion, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);
        if(cocktail == null){
            if(type.equals("MulledWine")){
                cocktail = new MulledWine(name, cocktail.getSize(), brand);
            }else if(type.equals("Hibernation")){
                cocktail = new Hibernation(name, cocktail.getSize(), brand);
            }else{
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
            }
        }
        cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED,name, type);
    }

    @Override
    public String addBooth(String type, int boohNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boohNumber);
        if(booth.equals("OpenBooth")){
            booth = new OpenBooth(boohNumber, capacity);
        }else if(booth.equals("PrivateBooth")){
            booth = new PrivateBooth(boohNumber, capacity);
        }else{
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boohNumber));
        }
        boothRepository.add(booth);
        return String.format(OutputMessages.BOOTH_ADDED, boohNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        List<Booth> freeTables = boothRepository.getAll()
                .stream()
                .filter(b -> b.isReserved() == false && b.getCapacity() >= numberOfPeople)
                .collect(Collectors.toList());
        if (freeTables.isEmpty()) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        freeTables.get(0).reserve(numberOfPeople);
        return (String.format(OutputMessages.BOOTH_RESERVED, freeTables.get(0).getBoothNumber(), numberOfPeople));

    }

    @Override
    public String leaveBooth(int tableNumber) {
        Booth booth = boothRepository.getByNumber(tableNumber);
        double amount = booth.getBill();
        totalIncome += amount;
        booth.clear();
        return String.format(OutputMessages.TOTAL_INCOME, totalIncome);
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, totalIncome);
    }
}
