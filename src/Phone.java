public class Phone extends Product{
    private int batteryCapacity;
    private String color;

    public Phone(String brand, String name, String memory, int ram, double screenSize, double price, int discountRate, int stock, int batteryCapacity, String color) {
        super(brand, name, memory, ram, screenSize, price, discountRate, stock, "Phone");
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
