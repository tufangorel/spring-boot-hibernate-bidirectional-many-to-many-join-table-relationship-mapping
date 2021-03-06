package com.company.customerinfo;


import com.company.customerinfo.model.Product;
import com.company.customerinfo.model.Store;
import com.company.customerinfo.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CustomerInfoApplication.class)
@ActiveProfiles("dev")
public class StoreServiceIntegrationTest {

    @Autowired
    private StoreService storeService;

    @Test
    public void saveCustomerWithOrderTest() {

        Store store1 = new Store();
        Store store2 = new Store();
        Product product1 = new Product();
        product1.setName("product1");
        Product product2 = new Product();
        product2.setName("product2");
        Product product3 = new Product();
        product3.setName("product3");

        store1.addProduct(product1);
        store1.addProduct(product2);
        store1.addProduct(product3);
        store2.addProduct(product1);


        List<Store> savedRecordList = storeService.saveStoresWithProducts(List.of(store1,store2));
        assertThat( savedRecordList != null);
        assertThat( savedRecordList.size() > 0 );
        assertThat( savedRecordList.size() == 2 );
        assertThat( savedRecordList.get(0).getProducts() != null);
        assertThat( savedRecordList.get(1).getProducts() != null);

    }
}
