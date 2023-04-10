public abstract class Product {
    private static int idCounter = 0;
    private int id;
    private String brand;
    private String name;
    private String memory;
    private int ram;
    private double screenSize;
    private double price;
    private int discountRate;
    private int stock;
    private String category;

    public Product(String brand, String name, String memory, int ram, double screenSize, double price, int discountRate, int stock, String category) {
        idCounter++;
        this.id = idCounter;
        this.brand = brand;
        this.name = name;
        this.memory = memory;
        this.ram = ram;
        this.screenSize = screenSize;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.category = category;
    }

    public String  getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
