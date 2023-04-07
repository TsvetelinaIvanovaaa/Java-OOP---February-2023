package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ToyStoryTest {

    ToyStore toyStore;
    List<Toy> toys;
    @Before
    public void setup() throws OperationNotSupportedException {
        toyStore = new ToyStore();
        toys = List.of(
                new Toy("Lego", "1"),
                new Toy("Barby", "2"),
                new Toy("Fishbone", "3")
        );
        String output = toyStore.addToy("A", toys.get(0));
    }
    @Test
    public void testToyStore() {

        Map<String, Toy> toyShelf = new LinkedHashMap<>();
        Toy toy = new Toy("A", "A");
        Toy toy1 = new Toy("B", "B");
        Toy toy2 = new Toy("C", "C");
        toyShelf.put("First", toy);
        toyShelf.put("Second", toy1);
        toyShelf.put("Turd", toy2);

        Assert.assertEquals(toy, toyShelf.get("First"));
        Assert.assertEquals(toy1, toyShelf.get("Second"));
        Assert.assertEquals(toy2, toyShelf.get("Turd"));

    }
    @Test
    public void testConstructor() {
        toyStore = new ToyStore();
        Map<String, Toy> toyShelf = toyStore.getToyShelf();
        Assert.assertEquals(7, toyShelf.size());
    }
    @Test
    public void testAddToyShouldAddToyOnShelfA(){
        Toy actual = toyStore.getToyShelf().get("A");
        Assert.assertEquals(toys.get(0).getToyId(), actual.getToyId());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToNonexistentShelfShouldThrowEx() throws OperationNotSupportedException {
        toyStore.addToy("W", toys.get(0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToSameShelfShouldThrowEx() throws OperationNotSupportedException {

        toyStore.addToy("A", toys.get(1));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddSameToyShouldThrowExOp() throws OperationNotSupportedException {

        toyStore.addToy("B", toys.get(0));
    }

    @Test
    public void testRemoveToyShouldRemoveToyOnShelfA() {

        Toy toy = toyStore.getToyShelf().get("A");
        String output = toyStore.removeToy("A", toy);
        Assert.assertFalse(toyStore.getToyShelf().containsValue(toy));
        Assert.assertTrue(toyStore.getToyShelf().containsValue(null));
        Assert.assertEquals("Remove toy:1 successfully!", output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyFromNonexistentShelfShouldThrowEx() {

        Toy toy = toyStore.getToyShelf().get("A");
        toyStore.removeToy("W", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonexistentToyShouldThrowEx() {
        toyStore.removeToy("A", toys.get(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetToyShelfShouldThrowExBecauseReturnUnmodifiableList() {
        toyStore.getToyShelf().put("A", toys.get(0));
    }
}