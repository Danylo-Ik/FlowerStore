package flower.store;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlowerSpec {
    private double sepalLength;
    private double price;
    private FlowerType flowerType;
    private FlowerColor color;

    public FlowerSpec(double sepalLength, double price, FlowerType flowerType, FlowerColor flowerColor) {
        this.sepalLength = sepalLength;
        this.price = price;
        this.flowerType = flowerType;
        this.color = flowerColor;
    }

    public boolean matches(FlowerSpec otherSpec) {
        if (otherSpec.getFlowerType() != null && !otherSpec.getFlowerType().equals(this.flowerType)) {
            return false;
        }
        if (otherSpec.getColor() != null && !otherSpec.getColor().equals(this.color)) {
            return false;
        }
        if (otherSpec.getSepalLength() != 0.0 && otherSpec.getSepalLength() != this.sepalLength) {
            return false;
        }
        if (otherSpec.getPrice() != 0.0 && otherSpec.getPrice() != this.price) {
            return false;
        }
        return true;
    }

}
