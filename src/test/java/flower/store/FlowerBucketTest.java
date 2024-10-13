package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Rose();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testSpec() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Rose();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        FlowerSpec spec = flowerBucket.getSpec();
        Assertions.assertEquals(flower.getFlowerType(), spec.getFlowerType());
        Assertions.assertEquals(flower.getColor(), spec.getColor());
        Assertions.assertEquals(flower.getPrice(), spec.getPrice());
        Assertions.assertEquals(flower.getSepalLength(), spec.getSepalLength());
    }

    @Test
    public void testToString() {
        Flower flower = new Rose();
        flower.setPrice(10);
        flower.setColor(FlowerColor.RED);
        flower.setFlowerType(FlowerType.ROSE);
        flower.setSepalLength(1.0);
        FlowerPack flowerPack = new FlowerPack(flower, 1);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals("FlowerBucket{flowerPacks=[FlowerPack{flower=Flower(sepalLength=1.0, color=#FF0000, price=10.0, flowerType=ROSE), quantity=1}]}", flowerBucket.toString());
    }

    @Test
    public void testSpecs() {
        FlowerSpec spec = new FlowerSpec(1.0, 10.0, FlowerType.ROSE, FlowerColor.RED);
        Flower flower = new Rose();
        flower.setPrice(10);
        flower.setColor(FlowerColor.RED);
        flower.setFlowerType(FlowerType.ROSE);
        flower.setSepalLength(1.0);
        FlowerPack flowerPack = new FlowerPack(flower, 1);
        flowerBucket.add(flowerPack);
        Assertions.assertTrue(spec.matches(flowerBucket.getSpec()));
    }
}
