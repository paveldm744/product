package ru.netology.product.product.Product.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.product.Product.Book;
import ru.netology.product.product.Product.Product;
import ru.netology.product.product.Product.Smartphone;
import ru.netology.product.product.Product.repository.Repository;

public class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager (repo);
    Book product1 = new Book(1, "book1", 100, "Pushkin");
    Book product2 = new Book(2, "book2", 110, "Lermontov");
    Book product3 = new Book(3, "book3", 120, "Blok");
    Smartphone product4 = new Smartphone(4, "smart1", 1000, "Xiaomi");
    Smartphone product5 = new Smartphone(5, "smart2", 1100, "Asus");
    Smartphone product6 = new Smartphone(6, "smart3", 1200, "Poco");


    @Test

    public void shouldAddProduct() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test

    public void shouldSearchBy() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        Product[] expected = {product2};
        Product[] actual = manager.searchBy("book2");

        Assertions.assertArrayEquals(expected,actual);

    }
}
