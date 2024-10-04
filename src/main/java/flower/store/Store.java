package flower.store;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private ArrayList<FlowerBucket> inventory;
    
    public void addBucket(FlowerBucket bucket) {
        inventory.add(bucket);
    }

    public String search(FlowerBucket bucket) {
        for (FlowerBucket flowerBucket : inventory) {
            if (flowerBucket.getPrice() == bucket.getPrice() && 
            flowerBucket.getFlowerPacks().equals(bucket.getFlowerPacks())) {
                return "Bucket found";
            }
        }
        return "Bucket not found";
    }
}
