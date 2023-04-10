import java.util.*;

public class ProductManagement {
    Scanner sc = new Scanner(System.in);
    ArrayList<Brand> brands;
    ArrayList<Product> products;

    public ProductManagement() {
        brands = new ArrayList<>();
        products = new ArrayList<>();

        initializeBrands();
        initializeProducts();
    }

    public void initializeBrands() {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
    }

    public void initializeProducts() {
        products.add(new Phone("Samsung", "Galaxy A51", "128 GB", 6, 6.5, 2000, 5, 3, 4000, "Siyah"));
        products.add(new Phone("Xiaomi", "Redmi Note 10", "64 GB", 8, 6.4, 1500, 0, 5, 5000, "Mavi"));

        products.add(new Notebook("Apple", "MacBook Air", "512 GB", 8, 14, 5000, 2, 8));
        products.add(new Notebook("Lenovo", "ThinkPad X1 Carbon", "1 TB", 512, 15, 3000, 1, 12));
    }

    public void displayBrands() {
        System.out.println("### Marka Listesi ###");
        Collections.sort(brands);
        for (Brand brand : brands) {
            System.out.println("ID: " + brand.getId() + " Marka: " + brand.getName());
        }
    }

    public void displayAllProducts() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        String format = "| %-3s | %-10s | %-10s | %-20s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s |\n";
        System.out.format(format, "KOD", "KATEGORI", "MARKA", "URUN ADI", "FIYAT", "INDIRIM", "HAFIZA", "RAM", "EKRAN", "STOK");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        for (Product product : products) {
            System.out.format(format, product.getId(), product.getCategory(), product.getBrand(), product.getName(), product.getPrice(), product.getDiscountRate(), product.getMemory(), product.getRam(), product.getScreenSize(), product.getStock());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    }

    public void displayPhones() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        String format = "| %-3s | %-10s | %-20s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s |\n";
        System.out.format(format, "KOD", "MARKA", "URUN ADI", "FIYAT", "INDIRIM", "DEPOLAMA", "EKRAN", "PIL", "RAM", "RENK", "STOK");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        for (Product product : products) {
            if (product instanceof Phone phone) {
                System.out.format(format, phone.getId(), phone.getBrand(), phone.getName(), phone.getPrice(), phone.getDiscountRate(), phone.getMemory(), phone.getScreenSize(), phone.getBatteryCapacity(), phone.getRam(), phone.getColor(), phone.getStock());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    }

    public void displayNotebooks() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        String format = "| %-3s | %-10s | %-20s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s |\n";
        System.out.format(format, "KOD", "MARKA", "URUN ADI", "FIYAT", "INDIRIM", "HAFIZA", "RAM", "EKRAN", "STOK");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        for (Product product : products) {
            if (product instanceof Notebook notebook) {
                System.out.format(format, notebook.getId(), notebook.getBrand(), notebook.getName(), notebook.getPrice(), notebook.getDiscountRate(), notebook.getMemory(), notebook.getRam(), notebook.getScreenSize(), notebook.getStock());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    }

    public void addBrand(String brandName) {
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                System.out.println("Girdiğiniz marka listede bulunuyor");
                return;
            }
        }
        brands.add(new Brand(brands.size() + 1, brandName));
    }

    public void addPhone() {
        System.out.println("### Telefon özelliklerini giriniz ###");

        boolean checkBrand = false;
        String brandName;
        do {
            System.out.print("Marka giriniz: ");
            brandName = sc.next();
            for (Brand brand : brands) {
                if (brandName.equalsIgnoreCase(brand.getName())) {
                    checkBrand = true;
                    break;
                }
            }
        } while (!checkBrand);

        System.out.print("Model giriniz: ");
        String modelName = sc.next();
        System.out.print("Hafıza giriniz (Örn. 64 GB): ");
        String memory = sc.next();
        System.out.print("RAM giriniz (Örn. 8): ");
        int ram = sc.nextInt();
        System.out.print("Ekran boyutu giriniz (Örn. 6.1): ");
        double screen = sc.nextDouble();
        System.out.print("Ürün fiyatı giriniz (Örn. 1000): ");
        double price = sc.nextDouble();
        System.out.print("İndirim oranı giriniz (Örn. 5): ");
        int discount = sc.nextInt();
        System.out.print("Stok adedi giriniz (Örn. 3): ");
        int stock = sc.nextInt();
        System.out.print("Batarya kapasitesi giriniz (Örn. 3000): ");
        int battery = sc.nextInt();
        System.out.print("Ürün rengini giriniz (Örn. Black): ");
        String color = sc.next();

        products.add(new Phone(brandName, modelName, memory, ram, screen, price, discount, stock, battery, color));

        System.out.println(brandName + " Marka " + modelName + " Model telefon stoklara eklendi.\nAna menüye dönmek için herhangi bir tuşa basınız.");
        String leave = sc.next();
    }

    public void deleteProduct(int id) {
            products.removeIf(product -> product.getId() == id);
    }

    public void addNotebook() {
        System.out.println("### Notebook özelliklerini giriniz ###");

        boolean checkBrand = false;
        String brandName;
        do {
            System.out.print("Marka giriniz: ");
            brandName = sc.next();
            for (Brand brand : brands) {
                if (brandName.equalsIgnoreCase(brand.getName())) {
                    checkBrand = true;
                    break;
                }
            }
        } while (!checkBrand);

        System.out.print("Model giriniz: ");
        String modelName = sc.next();
        System.out.print("Hafıza giriniz (Örn. 64 GB): ");
        String memory = sc.next();
        System.out.print("RAM giriniz (Örn. 8): ");
        int ram = sc.nextInt();
        System.out.print("Ekran boyutu giriniz (Örn. 6.1): ");
        double screen = sc.nextDouble();
        System.out.print("Ürün fiyatı giriniz (Örn. 1000): ");
        double price = sc.nextDouble();
        System.out.print("İndirim oranı giriniz (Örn. 5): ");
        int discount = sc.nextInt();
        System.out.print("Stok adedi giriniz (Örn. 3): ");
        int stock = sc.nextInt();

        products.add(new Notebook(brandName, modelName, memory, ram, screen, price, discount, stock));
    }

    public void filterByBrand(String brandName) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brandName)) {
                filteredProducts.add(product);
            }
        }
        if (filteredProducts.isEmpty()) {
            System.out.println("Markanın ürünü bulunamadı.");
        } else {
            System.out.println("------------------------------------------------------------------------------");
            String format = "| %-3s | %-10s | %-10s | %-20s | %-8s | %-8s |\n";
            System.out.format(format, "KOD", "KATEGORI", "MARKA", "URUN ADI", "FIYATI", "STOK");
            System.out.println("------------------------------------------------------------------------------");
            for (Product product : filteredProducts) {
                System.out.format(format, product.getId(), product.getCategory(), product.getBrand(), product.getName(), product.getPrice(), product.getStock());
            }
            System.out.println("------------------------------------------------------------------------------");
        }

    }
}
