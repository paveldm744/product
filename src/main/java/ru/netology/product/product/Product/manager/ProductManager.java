package ru.netology.product.product.Product.manager;

import ru.netology.product.product.Product.Product;
import ru.netology.product.product.Product.repository.Repository;

public class ProductManager {
    private Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] results = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[results.length + 1];
                System.arraycopy(results, 0, tmp, 0, results.length);
                tmp[tmp.length - 1] = product;
                results = tmp;
            }
        }
        return results;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}


