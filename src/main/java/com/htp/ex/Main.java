package com.htp.ex;

import com.htp.ex.model.Auto;
import com.htp.ex.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        Auto auto = new Auto();
        Reports reports = new Reports();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


       for (Auto t : reports.findAutosByUserIdAndEmail(session)) {
           System.out.println(t);
       }


        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
