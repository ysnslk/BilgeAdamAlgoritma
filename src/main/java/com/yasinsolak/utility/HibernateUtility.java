package com.yasinsolak.utility;

import com.yasinsolak.entity.Kullanici;
import com.yasinsolak.entity.Yarisma;
import com.yasinsolak.entity.YarismaKatilim;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {


        private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

        private static SessionFactory sessionFactoryHibernate() {


            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Kullanici.class);
                  configuration.addAnnotatedClass(Yarisma.class);
                  configuration.addAnnotatedClass(YarismaKatilim.class);

                SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
                return sessionFactory;
            } catch (Exception exception) {
                System.out.println(exception.toString());
                System.out.println("Oturum Bulunamadı...!");
            }
            return null;
        }

        public static SessionFactory getSessionFactory() {
            return SESSION_FACTORY;
        }


}
