package prog;

import java.io.Serializable;
import java.util.ArrayList;

public  class MainDriver implements Serializable {
    private ArrayList<Client> clientArrayList;
    private ArrayList<Worker> workerArrayList;
    private ArrayList<Manager> managerArrayList;
    private ArrayList<Person> personArrayList;
    private ArrayList<Product> warehouseProductList;
    private Person currentUser;
    private Shop shop;

    // creates all the lists for clients,workers,managers etc..
    public MainDriver() {
        this.clientArrayList = new ArrayList<Client>();
        this.workerArrayList = new ArrayList<Worker>();
        this.managerArrayList = new ArrayList<Manager>();
        this.personArrayList = new ArrayList<Person>();
        this.warehouseProductList = new ArrayList<Product>();
        this.shop = new Shop("Florida");


//        Product product1 = new Product("KeyBoard","101",700,15);
//        Product product2 = new Product("Mouse","102",500,10);
//        Product product3 = new Product("Speaker","103",1500,45);
//
//        this.shop.getShopStorage().addProduct(product1);
//        this.shop.getShopStorage().addProduct(product2);
//        this.shop.getShopStorage().addProduct(product3);
//
//
//        Manager sampleManager=new Manager("1","sample", Gender.MALE,"sample","Manager",
//                "sample1","manager", AccessLevel.MANAGER,"manager");
//        this.personArrayList.add(sampleManager);
//        this.managerArrayList.add(sampleManager);
//
//        Worker worker=new Worker("2","sample", Gender.MALE,"sample","sample",
//                "sample","worker", AccessLevel.WORKER,"worker");
//        this.personArrayList.add(worker);
//        this.workerArrayList.add(worker);
//
//        Client client=new Client("22","sample", Gender.MALE,"sample","sample",
//                "sampleClient","client", AccessLevel.CLIENT,"client");
//        this.personArrayList.add(client);
//        this.clientArrayList.add(client);
    }

    public Person getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Person currentUser) {
        this.currentUser = currentUser;
    }

    public Shop getShop() {
        return shop;
    }

    public ArrayList<Client> getClientArrayList() {
        return clientArrayList;
    }

    public void setClientArrayList(ArrayList<Client> clientArrayList) {
        this.clientArrayList = clientArrayList;
    }

    public ArrayList<Worker> getWorkerArrayList() {
        return workerArrayList;
    }

    public void setWorkerArrayList(ArrayList<Worker> workerArrayList) {
        this.workerArrayList = workerArrayList;
    }

    public ArrayList<Manager> getManagerArrayList() {
        return managerArrayList;
    }

    public void setManagerArrayList(ArrayList<Manager> managerArrayList) {
        this.managerArrayList = managerArrayList;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public ArrayList<Product> getWarehouseProductList() {
        return warehouseProductList;
    }
}