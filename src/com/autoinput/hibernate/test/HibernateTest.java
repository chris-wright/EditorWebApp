package com.autoinput.hibernate.test;


import java.util.Date;

import org.hibernate.Session;

import com.autoinput.hibernate.objects.Continent;
import com.autoinput.hibernate.util.HibernateUtil;
 
public class HibernateTest
{
   public static void main(String[] args)
   {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      
      System.out.println("1");
      
      // Add new Employee object
      Continent c = new Continent();

      System.out.println("2");
      
      c.setContinentalityName("European");
      c.setFederationName("Union of European Football Associations");
      c.setName("Europe");
      c.setOldName("Europee");
      c.setRegionalStrength(1L);
      c.setShortFederationName("UEFA");
      c.setThreeLetterName("EUR");
      c.setNameId(c.getThreeLetterName() + "_" + c.getName());
      c.setDateAdded(new Date());
      
      System.out.println("3");
      
      session.save(c);
      System.out.println("4");
      session.getTransaction().commit();
      System.out.println("5");
      HibernateUtil.shutdown();
   }
}