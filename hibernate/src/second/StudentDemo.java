package second;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
           try
           {
        	  Student stu1=new Student(3,"xyz3","xyz3");
        	  session.beginTransaction();
        	  //add objects 
        	  session.save(stu1);
        	 
        	   session= factory.getCurrentSession();
        	  Student stu2=session.get(Student.class, stu1.getId());
        	  //retrieve objects
              System.out.println(stu2.getId() +" "+stu2.getName()+" "+stu2.getEmail());
              //update content
               
              session.getTransaction().commit();
        	  System.out.println("done");
           }
           catch(Exception e)
           {
        	   e.printStackTrace();
           }
	}

}
