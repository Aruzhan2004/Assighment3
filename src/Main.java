import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> my_table = new MyHashTable<>(100);

        // Add 10000 random elements to the table
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(rand.nextInt(100), UUID.randomUUID().toString());
            Integer value = rand.nextInt(1000);
            my_table.put(key, value);
        }

        // Print the number of elements in each bucket
        int[] bucketSizes = my_table.printNumElementsInEachBucket();
        System.out.println(Arrays.toString(bucketSizes));

        MyHashTable<String, Integer> table = new MyHashTable<>();

        // Test put() and get() methods
        table.put("foo", 42);
        table.put("bar", 123);
        table.put("baz", 999);
        System.out.println(table.get("foo")); // Output: 42
        System.out.println(table.get("bar")); // Output: 123
        System.out.println(table.get("baz")); // Output: 999
        System.out.println(table.get("qux")); // Output: null

        // Test contains() method
        System.out.println(table.contains(123)); // Output: true
        System.out.println(table.contains(456)); // Output: false

        // Test getKey() method
        System.out.println(table.getKey(42)); // Output: foo
        System.out.println(table.getKey(123)); // Output: bar
        System.out.println(table.getKey(999)); // Output: baz
        System.out.println(table.getKey(0)); // Output: null

        // Test put() method with duplicate key
        table.put("foo", 456);
        System.out.println(table.get("foo")); // Output: 456

        // Test remove() method
        System.out.println(table.remove("bar")); // Output: 123
        System.out.println(table.get("bar")); // Output: null

        // Test resize() method
        MyHashTable<String, Integer> table2 = new MyHashTable<>(2);
        table2.put("foo", 42);
        table2.put("bar", 123);
        table2.put("baz", 999);
        System.out.println(table2.get("foo")); // Output: 42
        System.out.println(table2.get("bar")); // Output: 123
        System.out.println(table2.get("baz")); // Output: 999
    }
}