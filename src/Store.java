import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagement pm = new ProductManagement();

        int choice = -1;
        while (choice != 0) {
            System.out.println("""
                    \n### PATIKASTORE ÜRÜN YÖNETİM SİSTEMİ ###
                    1 - Marka listele
                    2 - Tüm ürünleri listele
                    3 - Cep telefonu listele
                    4 - Notebook listele
                    5 - Yeni marka ekle
                    6 - Yeni ürün ekle
                    7 - Ürün sil
                    8 - Ürünleri filtrele
                    0 - Çıkış""");

            System.out.print("Seçiminiz: ");
            choice = scanner.nextInt();

            while (choice < 0 || choice > 8) {
                System.out.print("Geçersiz seçim. Seçimi tekrarlayınız: ");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    pm.displayBrands();
                    System.out.println("Ana menü için herhangi bir tuşa bas.");
                    String delay1 = scanner.next();
                    break;
                case 2:
                    pm.displayAllProducts();
                    System.out.println("Ana menü için herhangi bir tuşa bas.");
                    delay1 = scanner.next();
                    break;
                case 3:
                    pm.displayPhones();
                    System.out.println("Ana menü için herhangi bir tuşa bas.");
                    delay1 = scanner.next();
                    break;
                case 4:
                    pm.displayNotebooks();
                    System.out.println("Ana menü için herhangi bir tuşa bas.");
                    delay1 = scanner.next();
                    break;
                case 5:
                    System.out.print("Eklemek istediğiniz marka adını giriniz: ");
                    String brandName = scanner.next();
                    pm.addBrand(brandName);
                    break;
                case 6:
                    System.out.print("""
                            1- Cep telefonu
                            2- Notebook
                            0- Ana menüye dön
                            Eklemek istediğiniz ürün grubunu seçiniz: 
                            """);
                    byte select1 = scanner.nextByte();
                    while (select1 < 0 || select1 > 2) {
                        System.out.print("Hatalı seçim yaptınız.\n" +
                                "Eklemek istediğiniz ürünün grubunu seçiniz: ");
                        select1 = scanner.nextByte();
                    }
                    switch (select1) {
                        case 1 -> pm.addPhone();
                        case 2 -> pm.addNotebook();
                    }
                    break;
                case 7:
                    pm.displayAllProducts();
                    System.out.print("Listeden silmek istediğiniz ürün ID'si seçiniz (Üst menüye dönmek için '0' seçiniz): ");
                    byte selectProductToDelete = scanner.nextByte();
                    if (selectProductToDelete == 0) break;
                    pm.deleteProduct(selectProductToDelete);
                    break;
                case 8:
                    System.out.print("Filtrelemek istediğiniz markayı giriniz (Üst menüye dönmek için '0' seçiniz): ");
                    String filterSelect = scanner.next();
                    if (filterSelect.equalsIgnoreCase(Integer.toString(0))) break;
                    pm.filterByBrand(filterSelect);
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
            }
        }
    }
}