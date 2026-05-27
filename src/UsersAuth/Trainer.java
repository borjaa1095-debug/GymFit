package UsersAuth;

public class Trainer extends UserBase {

    private String specialization;
    public Trainer(String username, String password) {
        super(username, password);
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


}
