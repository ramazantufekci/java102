package patikadevstore.controller;

import patikadevstore.model.Brand;
import patikadevstore.model.Category;
import patikadevstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private static List<Product> products = new ArrayList<>();
    private static int lastProductId;
    private CategoryController categoryController;
    private BrandController brandController;

    public ProductController(CategoryController categoryController, BrandController brandController) {
        this.categoryController = categoryController;
        this.brandController = brandController;
        createDefaultObjects();
    }

    private void createDefaultObjects(){
        Category cellphone = categoryController.getCategoryByName("cellphone");
        Category notebook = categoryController.getCategoryByName("notebook");

        // Default Cellphones
        products.add(
                new Product(++lastProductId, "SAMSUNG GALAXY A51", cellphone,
                        3199, 0,10,brandController.getBrandByName("Samsung"),
                        "128 GB","6.5 inches","6 GB","Black", "4000 mAh")
        );
        products.add(
                new Product(++lastProductId, "iPhone 11", cellphone,
                        7379, 0,5,brandController.getBrandByName("Apple"),
                        "64 GB","6.1 inches","6 GB","Blue", "3046 mAh")
        );

        products.add(
                new Product(++lastProductId, "Red-Mi Note 10 Pro", cellphone,
                        4012, 0,15,brandController.getBrandByName("Xiaomi"),
                        "128 GB","6.5 inches","12 GB","White", "4000 mAh")
        );

        // Default notebooks
        products.add(
                new Product(++lastProductId, "HUAWEI Matebook 14", notebook,
                        7000, 0,4,brandController.getBrandByName("Huawei"),
                        "512 GB","14 inches","16 GB", "---", "---")
        );

        products.add(
                new Product(++lastProductId, "LENOVO V14 IGL", notebook,
                        3699, 0,4,brandController.getBrandByName("Lenovo"),
                        "1 TB","14 inches","8 GB", "---", "---")
        );

        products.add(
                new Product(++lastProductId, "ASUS Tuf Gaming", notebook,
                        8199, 0,4,brandController.getBrandByName("Asus"),
                        "2 TB","15.6 inches","2x16 GB", "---", "---")
        );
    }

    public List<Product> getProducts() {
        return products;
    }

    public void deleteUncategorizedProducts(){
        for (Product p : products)
        {
            if(p.getProductCategory() == null){
                products.remove(p);
                deleteUncategorizedProducts();
                break;
            }
        }
    }

    public void deleteUnbrandedProducts(){
        for (Product p : products)
        {
            if(p.getProductBrand() == null){
                products.remove(p);
                deleteUnbrandedProducts();
                break;
            }
        }
    }

    public int getLastProductId() {
        return lastProductId;
    }

    public void addNewProduct(String productName, Category productCategory, double price, double discountRate, int stockQuantity, Brand productBrand, String internalStorage, String screenSize, String ramCapacity, String color, String batteryCapacity){

        products.add(
                new Product(++lastProductId, productName, productCategory,
                        price, discountRate,stockQuantity,productBrand,
                        internalStorage,screenSize,ramCapacity,color, batteryCapacity)
        );

        System.out.println("New Product Added.");
    }

    public void deleteProduct(Product product){
        products.remove(product);
    }

}
