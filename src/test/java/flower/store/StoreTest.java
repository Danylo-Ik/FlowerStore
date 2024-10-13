package flower.store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class StoreTest {

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testSearch() {
        FlowerSpec spec = new FlowerSpec();
        spec.setFlowerType(FlowerType.ROSE);
        spec.setColor(FlowerColor.RED);
        spec.setPrice(10);
        spec.setSepalLength(1.0);
        Flower flower = new Rose();
        flower.setPrice(10);
        flower.setColor(FlowerColor.RED);
        flower.setFlowerType(FlowerType.ROSE);
        flower.setSepalLength(1.0);
        FlowerPack flowerPack = new FlowerPack(flower, 1);
        flowerBucket.add(flowerPack);
        Store store = new Store();
        store.addBucket(flowerBucket);
        Assertions.assertEquals("[FlowerBucket{flowerPacks=[FlowerPack{flower=Flower(sepalLength=1.0, color=#FF0000, price=10.0, flowerType=ROSE), quantity=1}]}]", store.search(spec));
    }
}
