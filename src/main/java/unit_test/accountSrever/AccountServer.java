package unit_test.accountSrever;

public class AccountServer implements AccountServerI {
    private int usersLimit = 10;

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }
}
