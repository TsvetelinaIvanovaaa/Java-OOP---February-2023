package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class GiftFactoryTests {
    private GiftFactory giftFactory;

    private List<Gift> gifts;

    @Before
    public void setup() {
        giftFactory = new GiftFactory();
        gifts = List.of(
                new Gift("Flowers", 1),
                new Gift("Hat", 2),
                new Gift("Dress", 3)
        );
        gifts.stream().forEach(g -> giftFactory.createGift(g));
    }

    @Test
    public void testConstructor(){
        int size = giftFactory.getCount();
        assertEquals(gifts.size(), size);
    }

    @Test
    public void testCreateGiftShouldAdGifts(){
        int size = giftFactory.getCount();
        assertEquals(gifts.size(), size);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftShouldThrowExForExistingGift(){
        giftFactory.createGift(gifts.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftShouldThrowExForNull(){
        giftFactory.removeGift(null);
    }

    @Test
    public void testRemoveGiftShouldReturnFalse(){
        boolean actual = giftFactory.removeGift("Invalid");
        Assert.assertFalse(actual);
    }

    @Test
    public void testRemoveGiftShouldReturnTrue(){
        boolean actual = giftFactory.removeGift("Dress");
        Assert.assertTrue(actual);
        int size = giftFactory.getCount();
        assertEquals(gifts.size() - 1, size);
    }

    @Test
    public void testGetPresentWithLeastMagic(){
        Gift expected = gifts.stream().min(Comparator.comparing(Gift::getMagic)).get();
        Gift actual = giftFactory.getPresentWithLeastMagic();
        assertEquals(expected.getMagic(), actual.getMagic(), 0);
    }

    @Test
    public void testGetPresentWithLeastMagicShouldReturnNull(){
        gifts.stream().forEach(g->giftFactory.removeGift(g.getType()));
        Gift actual = giftFactory.getPresentWithLeastMagic();
        Assert.assertNull(actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPresentsShouldThrowExBecauseReturnUnmodifiableList(){
        Gift gift = new Gift("Test", 2);
        giftFactory.getPresents().add(gift);
    }

    @Test
    public void testGetPresentsShouldReturn() {
        List<Gift> actual = giftFactory.getPresents().stream().collect(Collectors.toList());
        for (int i = 0; i < gifts.size(); i++) {
            Assert.assertEquals(gifts.get(i).getType(), actual.get(i).getType());
        }

    }
    
}
