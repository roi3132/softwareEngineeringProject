package prog;

import java.util.ArrayList;

public class Worker extends Person {
    protected double salary;
    protected double salesSum;
    protected String branchId;

    public Worker(String id, String address, Gender gender, String email, String firstName, String lastName, String password, AccessLevel accessLevel, String userName) {
        super(id, address, gender, email, firstName, lastName, password, accessLevel, userName);
        this.isManager=false;
        this.accessLevel=AccessLevel.WORKER;
    }

    protected enum status{AVAILABLE,ONLEAVE};
    protected boolean isManager;

    public boolean isManager() {
        return isManager;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalesSum() {
        return salesSum;
    }

    public void setSalesSum(double salesSum) {
        this.salesSum = salesSum;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }


    public void createNewSale(){

    }

    public void returnProduct(){

    }

    public void viewSalasHistory(){

    }

    public void updateShopStorage(){

    }

	@Override
	public String toString() {
//		return "Worker id= " + id + ", address= " + address + ", gender= " + gender
//				+ ", firstName= " + firstName + ", lastName= " + lastName ;
		return String.format( "Worker ID: %-10s Address: %-15s First Name: %-15s Last Name: %-15s",id,address,firstName,lastName );
	}
    


}
