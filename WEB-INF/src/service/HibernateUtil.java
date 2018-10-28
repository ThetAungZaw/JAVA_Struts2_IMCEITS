package service;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
public class HibernateUtil 
{
    private static final SessionFactory sessionFactory;
    static {
	        try {
	             Configuration cfg = new AnnotationConfiguration();            
	             sessionFactory = cfg.configure().buildSessionFactory();
	        } 
		catch (Throwable ex) 
		{         ex.printStackTrace(System.out);
	             throw new ExceptionInInitializerError(ex);
	        }
	    }
    public static Session getSession() throws HibernateException 
   {
        return sessionFactory.openSession();
    }
}

