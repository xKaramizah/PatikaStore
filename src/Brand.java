public class Brand implements Comparable<Brand>{
    private int id;
    private String name;

    public Brand(int id, String brandName) {
        this.id = id;
        this.name = brandName;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Brand o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
}
