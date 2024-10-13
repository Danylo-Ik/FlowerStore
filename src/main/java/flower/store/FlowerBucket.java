package flower.store;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FlowerBucket {
    private List<FlowerPack> flowerPacks;

    public FlowerBucket() {
        flowerPacks = new ArrayList<>();
    }

    public void add(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack : flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    public FlowerSpec getSpec() {
        FlowerSpec spec = new FlowerSpec();
        for (FlowerPack flowerPack : flowerPacks) {
            spec.setFlowerType(flowerPack.getFlower().getFlowerType());
            spec.setColor(flowerPack.getFlower().getColor());
            spec.setPrice(flowerPack.getFlower().getPrice());
            spec.setSepalLength(flowerPack.getFlower().getSepalLength());
        }
        return spec;
    }

    @Override
    public String toString() {
        return "FlowerBucket{" +
                "flowerPacks=" + flowerPacks +
                '}';
    }
}