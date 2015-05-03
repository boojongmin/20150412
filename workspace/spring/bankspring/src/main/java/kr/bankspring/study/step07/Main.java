package kr.bankspring.study.step07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration() .configure("kr/bankspring/study/step07/hibernate.cfg.xml") .buildSessionFactory();
		
		Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        UsersVo usersVo = new UsersVo();
        usersVo.setUserId("boojongmin");
        usersVo.setName("부종민");
        
        session.save(usersVo);
        System.out.println("commit 후 : " + usersVo);
        tx.commit();
        UsersVo vo = (UsersVo) session.get(UsersVo.class, 1L);
        String message = String.format("id : %d, userId: %s, name: %s", vo.getId(), vo.getUserId(), vo.getName());
        System.out.println(message);
        
        session.close();
        factory.close();
	}
}