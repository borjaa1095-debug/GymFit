package UsersAuth;

public class Trainer extends UserBase {

    private String specialization;
    public Trainer(String username, String email, int id, String password, String specialization) {
        super(username, email, id, password);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }




    @Override
    public boolean register(String file) {
        return false;
    }
}
