package ru.netology.product.product.Product.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.product.Product.Book;
import ru.netology.product.product.Product.Product;
import ru.netology.product.product.Product.Smartphone;

public class RepositoryTest {
    Book product1 = new Book(1, "book1", 100, "Pushkin");
    Book product2 = new Book(2, "book2", 110, "Lermontov");
    Book product3 = new Book(3, "book3", 120, "Blok");
    Smartphone product4 = new Smartphone(4, "smart1", 1000, "Xiaomi");
    Smartphone product5 = new Smartphone(5, "smart2", 1100, "Asus");
    Smartphone product6 = new Smartphone(6, "smart3", 1200, "Poco");
    Repository repo = new Repository();

    @Test

    public void shouldSaveProduct() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.removeById(5);
        Product[] expected = {product1, product2, product3, product4, product6};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
