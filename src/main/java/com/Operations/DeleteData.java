package com.Operations;

import com.Connection.SessionFactoryHelper;
import com.Model.ContactNoDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class DeleteData {
    public void deleteData() {
        SessionFactory factory = SessionFactoryHelper.getsessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER ID FOR DELETE RECORDS");
        int id = sc.nextInt();
        ContactNoDTO contactNoDTO = session.load(ContactNoDTO.class, id);
        session.delete(contactNoDTO);
        System.out.println("DATA DELETED SUCCESSFULLY...!");
        tx.commit();
        session.close();
        factory.close();
    }
}
