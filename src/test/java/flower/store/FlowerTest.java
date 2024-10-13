package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor().toString());
    }

    @Test
    public void testFlowerType() {
        FlowerType flowerType = FlowerType.ROSE;
        flower.setFlowerType(flowerType);
        Assertions.assertEquals(flowerType, flower.getFlowerType());
    }

    @Test
    public void testSepalLength() {
        double sepalLength = RANDOM_GENERATOR.nextDouble();
        flower.setSepalLength(sepalLength);
        Assertions.assertEquals(sepalLength, flower.getSepalLength());
    }

    @Test
    public void testToString() {
        flower.setPrice(10);
        flower.setColor(FlowerColor.RED);
        flower.setFlowerType(FlowerType.ROSE);
        flower.setSepalLength(1.0);
        Assertions.assertEquals("Flower(sepalLength=1.0, color=#FF0000, price=10.0, flowerType=ROSE)", flower.toString());
    }
}
