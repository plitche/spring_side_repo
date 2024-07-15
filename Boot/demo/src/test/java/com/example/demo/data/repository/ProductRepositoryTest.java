package com.example.demo.data.repository;

import com.example.demo.data.entity.Product;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void GenerateData() {
        int count = 1;
        productRepository.save(getProduct(Integer.toString(count), count++, 2000, 3000));
        productRepository.save(getProduct(Integer.toString(count), count++, 3000, 9000));
        productRepository.save(getProduct(Integer.toString(--count), count = count + 2, 1500, 200));
        productRepository.save(getProduct(Integer.toString(count), count++, 4000, 5000));
        productRepository.save(getProduct(Integer.toString(count), count++, 10000, 1500));
        productRepository.save(getProduct(Integer.toString(count), count++, 1000, 1000));
        productRepository.save(getProduct(Integer.toString(count), count++, 500, 10000));
        productRepository.save(getProduct(Integer.toString(count), count++, 8500, 3500));
        productRepository.save(getProduct(Integer.toString(count), count++, 7200, 2000));
        productRepository.save(getProduct(Integer.toString(count), count++, 5100, 1700));
    }

    private Product getProduct(String id, int nameNumber, int price, int stock) {
        return new Product(id, "상품" + nameNumber, price, stock);
    }

    @Test
    void findTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundEntities = productRepository.findByName("상품4");
        for (Product foundEntity : foundEntities) {
            System.out.println("foundEntity = " + foundEntity.toString());
        }

        List<Product> queryEntities = productRepository.queryByName("상품4");
        for (Product queryEntity : queryEntities) {
            System.out.println("queryEntity = " + queryEntity.toString());
        }

    }

    @Test
    void existTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        System.out.println(productRepository.existsByName("상품4"));
    }

    @Test
    void countTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        System.out.println(productRepository.countByName("상품4"));
    }

    @Test
    @Transactional
    void deleteTest() {
        System.out.println("before : " + productRepository.count());

        productRepository.deleteById("1");
        productRepository.deleteById("9");

        System.out.println("after : " + productRepository.count());
    }

    @Test
    void topTest() {
        productRepository.save(getProduct("100", 123, 1500, 5000));
        productRepository.save(getProduct("101", 123, 2500, 5000));
        productRepository.save(getProduct("102", 123, 3500, 5000));
        productRepository.save(getProduct("103", 123, 4500, 5000));
        productRepository.save(getProduct("104", 123, 1000, 5000));
        productRepository.save(getProduct("105", 123, 2000, 5000));
        productRepository.save(getProduct("106", 123, 3000, 5000));
        productRepository.save(getProduct("107", 123, 4000, 5000));

        List<Product> foundEntities = productRepository.findFirst5ByName("상품123");
        for (Product foundEntity : foundEntities) {
            System.out.println("foundEntity = " + foundEntity.toString());
        }

        List<Product> foundEntities2 = productRepository.findTop3ByName("상품123");
        for (Product product : foundEntities2) {
            System.out.println("productEntity = " + product.toString());
        }
    }

    /* 조건자 키워드 테스트 */

    @Test
    void isEqualTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        System.out.println(productRepository.findByIdIs("1"));
        System.out.println(productRepository.findByIdEquals("1"));
    }

    @Test
    void notTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        System.out.println(productRepository.findByIdNot("1"));
        System.out.println(productRepository.findByIdIsNot("1"));
    }

    @Test
    void nullTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        System.out.println(productRepository.findByProductStockIsNull());
        System.out.println(productRepository.findByProductStockIsNotNull());
    }

    @Test
    void andTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        System.out.println(productRepository.findTopByIdAndName("1", "상품1"));
    }

    @Test
    void greaterTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> productEntities = productRepository.findByProductPriceGreaterThan(5000);

        for (Product product : productEntities) {
            System.out.println("productEntity.toString() = " + product.toString());
        }
    }

    @Test
    void containTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        System.out.println(productRepository.findByNameContaining("상품1"));
    }

    /* 정렬과 페이징 */
    @Test
    void orderByTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByNameContainingOrderByStockAsc("상품");
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }

        foundProducts = productRepository.findByNameContainingOrderByStockDesc("상품");
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void multiOrderByTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByNameContainingOrderByPriceAscStockDesc("상품");
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void orderByWithParameterTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByNameContaining("상품"
            , Sort.by(Order.asc("price")));
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }

        foundProducts = productRepository.findByNameContaining("상품"
            , Sort.by(Order.asc("price"), Order.asc("stock")));
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void pagingTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByPriceGreaterThan(200
            , PageRequest.of(0, 2));
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }

        foundProducts = productRepository.findByPriceGreaterThan(200
            , PageRequest.of(2, 2));
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }

        foundProducts = productRepository.findByPriceGreaterThan(200
            , PageRequest.of(4, 2));
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void queryTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByPriceBasis();
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void nativeQueryTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByPriceBasisNativeQuery();
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void parameterQueryTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByPriceWithParameter(2000);
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void parameterNamingQueryTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByPriceWithParameterNaming(2000);
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void parameterNamingQueryTest2() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByPriceWithParameterNaming2(2000);
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }

    @Test
    void nativeQueryPagingTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("=====↓↓ Test Data ↓↓=====");
        for (Product product : foundAll) {
            System.out.println("productEntity = " + product);
        }
        System.out.println("=====↑↑ Test Data ↑↑=====");

        List<Product> foundProducts = productRepository.findByPriceWIthParameterPaging(2000,
            PageRequest.of(2, 2));
        for (Product foundProduct : foundProducts) {
            System.out.println("foundProduct = " + foundProduct);
        }
    }




}
