package prog;

public class Manager extends Worker {

    public Manager(String id, String address, Gender gender, String email, String firstName, String lastName, String password, AccessLevel accessLevel, String userName) {
        super(id, address, gender, email, firstName, lastName, password, accessLevel, userName);
        super.isManager=true;
        super.accessLevel= AccessLevel.MANAGER;
    }

    public void updateSalary(Worker worker,Double updatedSalary){
        worker.setSalary(salary);
    }

    public void updateManager(){};

    public void addWorker(){}

    public void deleteWorker(){}

}
