package flower.store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerPackTest {

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerPack flowerPack;

    @BeforeEach
    public void init() {
        flowerPack = new FlowerPack();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Rose();
        flower.setPrice(price);
        flowerPack.setFlower(flower);
        flowerPack.setQuantity(quantity);
        Assertions.assertEquals(price * quantity, flowerPack.getPrice());
    }

    @Test
    public void testSpec() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Rose();
        flower.setPrice(price);
        flowerPack.setFlower(flower);
        flowerPack.setQuantity(quantity);
        Assertions.assertEquals(flower.getFlowerType(), flowerPack.getFlower().getFlowerType());
        Assertions.assertEquals(flower.getColor(), flowerPack.getFlower().getColor());
        Assertions.assertEquals(flower.getPrice(), flowerPack.getFlower().getPrice());
        Assertions.assertEquals(flower.getSepalLength(), flowerPack.getFlower().getSepalLength());
    }

    @Test
    public void testToString() {
        Flower flower = new Rose();
        flower.setPrice(10);
        flower.setColor(FlowerColor.RED);
        flower.setFlowerType(FlowerType.ROSE);
        flower.setSepalLength(1.0);
        flowerPack.setFlower(flower);
        flowerPack.setQuantity(1);
        Assertions.assertEquals("FlowerPack{flower=Flower(sepalLength=1.0, color=#FF0000, price=10.0, flowerType=ROSE), quantity=1}", flowerPack.toString());
    }
}
