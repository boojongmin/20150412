package kr.bankspring.study.step09;

import kr.bankspring.study.step09.AccountsVo;
import kr.bankspring.study.step09.UsersVo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class Main {
	public static void main(String[] args) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("kr/bankspring/study/step09/application-context.xml");
	    
	    //http://stackoverflow.com/questions/18954698/cannot-be-cast-to-org-springframework-orm-hibernate4-localsessionfactorybean
	    LocalSessionFactoryBean sessionFactoryBean = context.getBean("&sessionFactory", LocalSessionFactoryBean.class);
	    SessionFactory factory = sessionFactoryBean.getObject();
	    Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        UsersVo usersVo = new UsersVo();
        usersVo.setUserId("boojongmin");
        usersVo.setName("부종민");
        session.save(usersVo);
        
        
        AccountsVo accountsVo = new AccountsVo(); 
        accountsVo.setAccountNumber("0000100001");
        accountsVo.setAmount(1000000);
        
        accountsVo.setUsersVo(usersVo);
        //Set에 담아주지 않으면 이후에 조회가 되지 않음. 동작원리 확인 필요.
        usersVo.getAccountList().add(accountsVo);
        session.save(accountsVo);
        
        
        tx.commit();
        
        System.out.println("commit 후 : " + usersVo);
        
        UsersVo uVo = (UsersVo) session.get(UsersVo.class, 1L);
        String message1 = String.format("id : %d, userId: %s, name: %s", uVo.getId(), uVo.getUserId(), uVo.getName());
        System.out.println(message1);
        System.out.println(uVo.getAccountList().size());
        if(uVo.getAccountList() != null && uVo.getAccountList().size() > 0){
          AccountsVo aVo = uVo.getAccountList().iterator().next();
          String message2 = String.format(">>id : %d, users_id: %s, accountNumber: %s, amount: %d", aVo.getId(), aVo.getUsersVo().getId(), aVo.getAccountNumber(), aVo.getAmount());
          System.out.println(message2);
        }
        AccountsVo aaVo = (AccountsVo) session.get(AccountsVo.class, 1L);
        String message2 = String.format("--id : %d, users_id: %s, accountNumber: %s, amount: %d", aaVo.getId(), aaVo.getUsersVo().getId(), aaVo.getAccountNumber(), aaVo.getAmount());
        System.out.println(message2);
        
        session.close();
        factory.close();

	}
}