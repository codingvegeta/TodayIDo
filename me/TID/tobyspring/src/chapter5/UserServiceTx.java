//package chapter5;
//
//import chapter1.User;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//
//public class UserServiceTx implements UserService
//{
//    UserService userService;
//    PlatformTransactionManager transactionManager;
//
//    public void setUserService(UserService userService)
//    {
//        this.userService = userService;
//    }
//
//    public void setTransactionManager(PlatformTransactionManager transactionManager)
//    {
//        this.transactionManager = transactionManager;
//    }
//
//    @Override
//    public void add(User user)
//    {
//        userService.add(user);
//    }
//
//    @Override
//    public void upgradeLevels()
//    {
//        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
//
//        try
//        {
//            userService.upgradeLevels();
//
//            transactionManager.commit(status);
//        }
//        catch (RuntimeException e)
//        {
//            transactionManager.rollback(status);
//            throw e;
//        }
//    }
//}
