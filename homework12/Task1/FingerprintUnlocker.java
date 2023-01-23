package Task1;

public class FingerprintUnlocker extends Unlocker implements UnlockingMethod<String> {
    private String password;

    public FingerprintUnlocker(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}