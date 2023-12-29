package com.Operations;

import com.Connection.SessionFactoryHelper;
import com.Model.ContactNoDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class UpdateData {

    public void updateData() {
        SessionFactory factory = SessionFactoryHelper.getsessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER ID FOR UPDATE RECORDS");
        int id = sc.nextInt();
        ContactNoDTO contactNoDTO = session.load(ContactNoDTO.class, id);
        System.out.println("ENTER SERVICE PROVIDER ");
        String service=sc.next();
        contactNoDTO.setService_Provide(service);
        System.out.println("ENTER ABOUT");
        sc.nextLine();
        String about=sc.nextLine();
        contactNoDTO.getWhatsappDTO().setAbout(about);
        session.update(contactNoDTO);
        tx.commit();
        session.close();
        factory.close();

    }
}
