package service;

public class LoginExecutorImpl implements LoginInterface {
    @Override
    public void login(String name) throws Exception {
        System.out.println(": " + name);
    }
}
