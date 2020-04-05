package hello.entity;

public class LoginResult extends Result<User> {
    private boolean isLogin;

    public static LoginResult failMsg(String msg) {
        return new LoginResult("fail", msg, false, null);
    }

    public static LoginResult statusIsOkAndLoginIsFalse(String msg) {
        return new LoginResult("ok", msg, false,null);
    }

    public static LoginResult successMsg(String msg, User loggerInUser) {
        return new LoginResult("ok", msg, true, loggerInUser);
    }

    private LoginResult(String status, String msg, boolean isLogin, User user) {
        super(status, msg, user);
        this.isLogin = isLogin;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
