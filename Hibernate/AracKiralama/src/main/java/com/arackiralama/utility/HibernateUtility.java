package com.arackiralama.utility;

import com.arackiralama.entity.Arac;
import com.arackiralama.entity.Kiralama;
import com.arackiralama.entity.Musteri;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {


        private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

        private static SessionFactory sessionFactoryHibernate() {


            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Arac.class);
                configuration.addAnnotatedClass(Kiralama.class);
                configuration.addAnnotatedClass(Musteri.class);

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
