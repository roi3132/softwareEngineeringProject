package prog;

import static org.junit.jupiter.api.Assertions.*;

class TestCases {


//    Product product2 = new Product("Mouse", "102", 500, 10);
//    Product product3 = new Product("Speaker", "103", 1500, 45);
//
//    this.shop.getShopStorage().
//
//    addProduct(product1);
//    this.shop.getShopStorage().
//
//    addProduct(product2);
//    this.shop.getShopStorage().
//
//    addProduct(product3);
//
//
//    Manager sampleManager = new Manager("1", "sample", Gender.MALE, "sample", "Manager",
//            "sample1", "manager", AccessLevel.MANAGER, "manager");
//    this.personArrayList.add(sampleManager);
//    this.managerArrayList.add(sampleManager);
//
//    Worker worker = new Worker("2", "sample", Gender.MALE, "sample", "sample", "sample", "worker", AccessLevel.WORKER, "worker");
//    this.personArrayList.add(worker);
//    this.workerArrayList.add(worker);
//
//    Client client = new Client("22", "sample", Gender.MALE, "sample", "sample",
//            "sampleClient", "client", AccessLevel.CLIENT, "client");
//    this.personArrayList.add(client);
//    this.clientArrayList.add(client);

    @org.junit.jupiter.api.Test
//test salary
    void setSalary() {
        Product product1 = new Product("KeyBoard", "101", 700, 15);
        assertEquals(700,product1.getPrice());
    }
    @org.junit.jupiter.api.Test
//test purchaseprice
    void purchaseprice() {
//        MainDriver store = new MainDriver();
//        store.getShop().addWorker();
        Product product2 = new Product("KeyBoard", "101", 700, 15);
        ShopStorage storage = new ShopStorage();
        storage.addProduct(product2);
        assertTrue(storage.isProductionShop(product2));

    }
//    test purchaseQuantity
    @org.junit.jupiter.api.Test
    void purchasQuantity() {
        Product product1 = new Product("KeyBoard", "101", 700, 42);
        assertEquals(42,product1.getQuantity());

    }

//test manager

    @org.junit.jupiter.api.Test

    void manager() {
        Manager sampleManager = new Manager("1", "sample", Gender.MALE, "sample", "Manager",
            "sample1", "manager", AccessLevel.MANAGER, "manager");
            assertTrue(sampleManager.isManager());

    }
     //salary check
    @org.junit.jupiter.api.Test
    void salary () {
        Worker worker1 = new Worker("2", "sample", Gender.MALE, "sample", "sample", "sample", "worker", AccessLevel.WORKER, "worker");
        worker1.setSalary(5000);
        assertEquals(5000, worker1.getSalary());

    }





}