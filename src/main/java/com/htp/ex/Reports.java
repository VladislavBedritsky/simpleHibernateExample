package com.htp.ex;

import com.htp.ex.model.Auto;
import com.htp.ex.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class Reports {

    public void saveUser (User user, Session session) {
        user.setFirstname("Tron");
        user.setEmail("t@mail.ru");
        user.setUsername("krik");
        session.save(user);
    }

    public void deleteUser (User user, Session session) {
        session.delete(user);
    }

    public void saveAuto (Auto auto, Session session) {

        auto.setColor("black");
        auto.setModel("ford");
        auto.setPrice(8900);
        session.save(auto);
    }

    public void deleteAuto (Auto auto, Session session) {
        session.delete(auto);
    }

    public void updateUser (User user, Session session) {
        user = session.get(User.class,2);
        user.setFirstname("Bill");
    }

    public User findUserById (User user, Session session) {
        return session.get(User.class, 2);
    }

    public void userBuyCar (Session session ) {

        User user = session.get(User.class,4);
        Auto auto = session.get(Auto.class,4);
        user.getUserAutos().add(auto);
        saveUser(user,session);
    }

    public List<User> findUserByIdAndUsername (Session session) {

        String query = "select u from User u where u.id = :id and u.firstname = :username";

        Query q = session.createQuery(query);
        q.setParameter("id",4);
        q.setParameter("username","Tron");

        return q.getResultList();

    }

    public List<User> findUserByCarIdAndModel (Session session) {

        String query = "select u from User u join u.userAutos autos where autos.id = :id and autos.model =:model";

        Query q = session.createQuery(query);

        q.setParameter("id",1);
        q.setParameter("model","bmw");

        return q.getResultList();
    }

    public List<Auto> findAutosByUserIdAndEmail (Session session) {

        String query = "select a from Auto a join a.users users where users.id = :id and users.email = :email";

        Query q = session.createQuery(query);

        q.setParameter("id",4);
        q.setParameter("email","t@mail.ru");

        return q.getResultList();
    }

// and etc.
}
