package com.yasinsolak.util;

import com.yasinsolak.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {


        private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

        private static SessionFactory sessionFactoryHibernate() {


            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Admin.class);
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(ProductDetails.class);

                SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
                return sessionFactory;
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
            return null;
        }

        public static SessionFactory getSessionFactory() {
            return SESSION_FACTORY;
        }


}
