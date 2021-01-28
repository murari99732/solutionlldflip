package service;
class LoginProxy implements LoginInterface {
    boolean ifallowed;
    LoginExecutorImpl loginExecutor;

    public LoginProxy(String name) {
        if(name == "Admin" ) {
            ifallowed = true;
        }
        loginExecutor = new LoginExecutorImpl();
    }




    @Override
    public void login(String query) throws Exception {
        if(ifallowed) {
            loginExecutor.login(query);
        } else {
          System.out.println("no u r not authorized");
        }
    }
}
