package hello.entity;

public class Result {
    private String status;
    private String msg;
    private boolean isLogin;
    private Object data;

    private Result(String status, String msg, boolean isLogin) {
        this(status, msg, isLogin, null);
    }

    private Result(String status, String msg, boolean isLogin, Object data) {
        this.status = status;
        this.msg = msg;
        this.isLogin = isLogin;
        this.data = data;
    }

    public static Result failMsg(String msg) {
        return new Result("fail", msg, false);
    }

    public static Result statusIsOkAndLoginIsFalse(String msg) {
        return new Result("ok", msg, false);
    }

    public static Result successMsg(String msg, Object loggerInUser) {
        return new Result("ok", msg, false, loggerInUser);
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public Object getData() {
        return data;
    }
}
