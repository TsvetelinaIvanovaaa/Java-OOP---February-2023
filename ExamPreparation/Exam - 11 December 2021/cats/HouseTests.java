package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseWithInvalidCapacity(){
        new House("House1", -4);

    }
    @Test(expected = NullPointerException.class)
    public void TestCreateHouseWithInvalidName(){
        new House(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void TestCreateHouseWithInvalidNameEmpty(){
        new House("", 5);
    }

    @Test
    public void testCreateHouse(){
        House house = new House("House1", 10);
        Assert.assertEquals("House1", house.getName());
        Assert.assertEquals(10, house.getCapacity());
    }
    @Test
    public void testAddCat(){
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        Assert.assertEquals(0,house.getCount());

        house.addCat(mike);
        Assert.assertEquals(1, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCatFullHouse(){
        House house = new House("House1", 1);
        Cat mike = new Cat("Mike");
        house.addCat(mike);
        Cat betty = new Cat("Betty");
        house.addCat(betty);
    }
    @Test
    public void testRemoveCat(){
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        Cat betty = new Cat("Betty");
        house.addCat(mike);
        house.addCat(betty);
        Assert.assertEquals(2, house.getCount());

        house.removeCat("Betty");
        Assert.assertEquals(1, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingCat(){
        House house = new House("House1", 0);
        house.removeCat("Ivan");
    }
    @Test
    public void testCatForSale(){
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        house.addCat(mike);

        Cat returnedCat = house.catForSale("Mike");
        Assert.assertFalse(returnedCat.isHungry());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleNonExistingCat(){
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        house.addCat(mike);

        Cat returnedCat = house.catForSale("Ivan");
    }
    @Test
    public void testStatisticks(){
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        Cat betty = new Cat("Betty");
        Cat john = new Cat("John");
        house.addCat(mike);
        house.addCat(betty);
        house.addCat(john);

        Assert.assertEquals("The cat Mike, Betty, John is in the house House1!",house.statistics());

    }
}
