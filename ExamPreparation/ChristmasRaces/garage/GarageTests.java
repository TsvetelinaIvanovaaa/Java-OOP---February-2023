package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {

    @Test
    public void testAddCar(){
        Garage garage = new Garage();

        Car car = new Car("Mercedec", 300, 45000);
        Car car1 = new Car("BMW", 250, 30000);
        Car car2 = new Car("Shkoda", 200, 25000);

        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        Assert.assertEquals(3, garage.getCars().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarNull(){
        Garage garage = new Garage();
        Car car = null;
        garage.addCar(car);
    }

    @Test
    public void testGetCount(){
        Garage garage = new Garage();

        Car car = new Car("Mercedec", 300, 45000);
        Car car1 = new Car("BMW", 250, 30000);
        Car car2 = new Car("Shkoda", 200, 25000);

        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        Assert.assertEquals(3, garage.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Garage garage = new Garage();

        Car car = new Car("Mercedec", 300, 45000);
        Car car1 = new Car("BMW", 250, 30000);
        Car car2 = new Car("Shkoda", 200, 25000);

        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        List<Car> carWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(250);
        Assert.assertEquals("Mercedec", carWithMaxSpeedAbove.get(0).getBrand());
    }
    @Test
    public void testGetTheMostExpensiveCar(){
        Garage garage = new Garage();

        Car car = new Car("Mercedec", 300, 45000);
        Car car1 = new Car("BMW", 250, 30000);
        Car car2 = new Car("Shkoda", 200, 25000);

        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        Car expensiveCar;
        expensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertEquals("Mercedec", expensiveCar.getBrand());
    }
    @Test
    public void testFindAllCarsByBrand(){
        Garage garage = new Garage();

        Car car = new Car("Mercedec", 300, 45000);
        Car car1 = new Car("BMW", 250, 30000);
        Car car2 = new Car("Shkoda", 200, 25000);

        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        List<Car> carFindAllCarsByBrand= garage.findAllCarsByBrand("Shkoda");
        Assert.assertEquals("Shkoda", carFindAllCarsByBrand.get(0).getBrand());
    }
}