package flower.store;
import java.util.ArrayList;
import java.util.Iterator;

public class Store {
    private ArrayList<FlowerBucket> inventory;

    public Store() {
        inventory = new ArrayList<>();
    }
    
    public void addBucket(FlowerBucket bucket) {
        inventory.add(bucket);
    }

    public String search(FlowerSpec spec) {
        ArrayList<FlowerBucket> foundBuckets = new ArrayList<>();
        for (Iterator<FlowerBucket> i = inventory.iterator(); i.hasNext();) {
            FlowerBucket bucket = (FlowerBucket) i.next();
            FlowerSpec bucketSpec = bucket.getSpec();
            if (spec.matches(bucketSpec)) {
                foundBuckets.add(bucket);
            }
        }
        if (foundBuckets.isEmpty()) {
            return "No flowers found";
        }
        return foundBuckets.toString();
    }
}
