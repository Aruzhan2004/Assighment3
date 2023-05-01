public class MyTestingClass {
    private int field1;
    private String field2;

    public MyTestingClass(int field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    // Custom hashCode implementation
    @Override
    public int hashCode() {
        final int prime1 = 31;
        final int prime2 = 37;
        int result = 1;
        result = prime1 * result + field1;
        result = prime2 * result + (field2 == null ? 0 : field2.hashCode());
        return result;
    }

    // Getters and setters omitted for brevity
}
