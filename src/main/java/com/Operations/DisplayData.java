package com.Operations;

import com.Connection.SessionFactoryHelper;
import com.Model.ContactNoDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class DisplayData {

    public void displayData() {
        SessionFactory factory = SessionFactoryHelper.getsessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER ID FOR DISPLAY RECORDS");
        int id = sc.nextInt();

        ContactNoDTO contactNoDTO = session.load(ContactNoDTO.class, id);
        if (contactNoDTO != null) {
            System.out.println("CONTACT NUMBER IS :" + "\t" + contactNoDTO.getContact_No());
            System.out.println("CONTACT HOLDER NAME :" + contactNoDTO.getContact_Holder_Name());
            System.out.println("NUMBER SERVICE PROVIDE :" + contactNoDTO.getService_Provide());

            // Check if whatsappDTO is null
            if (contactNoDTO.getWhatsappDTO() != null) {
                System.out.println("WHATSAPP USER NAME :" + contactNoDTO.getWhatsappDTO().getWhatsapp_User_Name());
                System.out.println("ABOUT ME :" + contactNoDTO.getWhatsappDTO().getAbout());
                System.out.println("ACCOUNT TYPE :" + contactNoDTO.getWhatsappDTO().getAcoount_Type());
            } else {
                System.out.println("DO NOT HAVE A WHATSAPP ACCOUNT");
            }
        } else {
            System.out.println("ENTER VALID ID");
        }

        tx.commit();
        session.close();
        factory.close();
    }
}
