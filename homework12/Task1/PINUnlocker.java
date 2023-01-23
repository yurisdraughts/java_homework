package Task1;

public class PINUnlocker extends Unlocker implements UnlockingMethod<Integer> {
    private Integer password;

    public PINUnlocker(Integer password) {
        this.password = password;
    }

    @Override
    public Integer getPassword() {
        return password;
    }

    @Override
    public void setPassword(Integer password) {
        this.password = password;
    }
}
