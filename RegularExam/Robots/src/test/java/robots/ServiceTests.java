package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceTests {

    private List<Robot> robotList;
    private Service service;

    @Before
    public void setup() {
        robotList = List.of(
                new Robot("A"),
                new Robot("B"),
                new Robot("C")
        );
        service = new Service("FirstService", 3);
        service.add(robotList.get(0));
        service.add(robotList.get(1));
        service.add(robotList.get(2));
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameInvalidName() {
        String name = "";
        service = new Service(name, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameIsNull() {
        String name = null;
        service = new Service(name, 3);
    }
    @Test
    public void testGetNameCorrect(){
        Assert.assertEquals("FirstService", service.getName());
    }
    @Test
    public void testGetCapacityCorrect() {
        Assert.assertEquals(3, service.getCapacity());
        Assert.assertEquals(3, service.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityNegativeNumber() {
        Service service1 = new Service("abc", -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithFullCapacity() {
        Service service1 = new Service("A", 3);
        Robot robot = new Robot("1");
        Robot robot1 = new Robot("2");
        Robot robot2 = new Robot("3");
        Robot robot3 = new Robot("4");

        service1.add(robot);
        service1.add(robot1);
        service1.add(robot2);
        service1.add(robot3);
    }
    @Test
    public void testServiceRemoveRobotShouldRemoveRobot(){

        service.remove("A");
        Assert.assertEquals(robotList.size()-1, service.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testServiceRemoveRobotWhichIsNull(){
        service.remove("Me");
    }
    @Test
    public void testRobotForSaleShouldReturnRobot(){
        Robot expected = robotList.get(0);
        Robot actual = service.forSale("A");
        Assert.assertFalse(actual.isReadyForSale());
        Assert.assertEquals(expected.getName(), actual.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRobotForSaleIfRobotIsNull(){
        Robot robot = service.forSale("");
    }
    @Test
    public void testReport(){
        String output = robotList.stream()
                .map(Robot::getName)
                .collect(Collectors.joining(", "));
        String expected = String.format("The robot %s is in the service %s!",output, service.getName());

        String actual = service.report();
        Assert.assertEquals(expected, actual);
    }
}
