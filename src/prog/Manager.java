package prog;

public class Manager extends Worker {
    // the constructor for the manager, gets all the details for the manager
    public Manager(String id, String address, Gender gender, String email, String firstName, String lastName, String password, AccessLevel accessLevel, String userName) {
        super(id, address, gender, email, firstName, lastName, password, accessLevel, userName);
        super.isManager=true;
        super.accessLevel= AccessLevel.MANAGER;
    }


    public void updateSalary(Worker worker,Double updatedSalary){
        worker.setSalary(salary);
    }
    // other functions that may be used later
    //public void updateManager(){};

    //public void addWorker(){}

    //public void deleteWorker(){}

}
