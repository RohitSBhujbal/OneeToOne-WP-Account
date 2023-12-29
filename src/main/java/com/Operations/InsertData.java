package com.Operations;

import com.Connection.SessionFactoryHelper;
import com.Model.ContactNoDTO;
import com.Model.WhatsappDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Scanner;

public class InsertData {

    ContactNoDTO contactNoDTO=new ContactNoDTO();
    //set whatsapp information
    WhatsappDTO whatsappDTO=new WhatsappDTO();
    public void InsertData() {
        SessionFactory factory= SessionFactoryHelper.getsessionFactory();
        Session session=factory.openSession();

        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER CONTACT NUMBER");
        long contact_NO=scanner.nextLong();
        System.out.println("ENTER CONTACT AUTHOR NAME");
        scanner.nextLine();
        String c_Author_Name=scanner.nextLine().toUpperCase();
        System.out.println("ENTER SERVICE PROVIDER");
        String service=scanner.next().toUpperCase();
        System.out.println("ENTER 5G ENABLED/NOT (TRUE OR FALSE)");
        boolean enabled=scanner.nextBoolean();
        scanner.nextLine();


        contactNoDTO.setContact_No(contact_NO);
        contactNoDTO.setContact_Holder_Name(c_Author_Name);
        contactNoDTO.setService_Provide(service);
        contactNoDTO.set_5GUnable_Or_not(enabled);


        System.out.println("DO YOU WANT TO CREATE WHATSAPP ACCOUNT YES/NO");
        String answer=scanner.nextLine();

        if(answer.equalsIgnoreCase("YES")){
            whatsappDTO.setWhatsapp_No(contact_NO);

            System.out.println("ENTER WHATSAPP NAME");
            String whatsapp_Name=scanner.next();
            System.out.println("ENTER ABOUT");
            scanner.nextLine();
            String about=scanner.nextLine().toUpperCase();
            System.out.println("ENTER ACCOUNT TYPE 1. BUSSINESS ACCOUNT 2. REGULAR ACCOUNT");
            int choice=scanner.nextInt();
            String acc_Type="REGULAR";
            if(choice==1){
                acc_Type="BUSSINESS";

            }
            contactNoDTO.setWhatsappDTO(whatsappDTO);
            whatsappDTO.setWhatsapp_User_Name(whatsapp_Name);
            whatsappDTO.setAbout(about);
            whatsappDTO.setAcoount_Type(acc_Type);
            System.out.println("WHATSAPP ACCOUNT CREATED SUCCESSFULLY...!");

        }
        session.save(contactNoDTO);
        session.save(whatsappDTO);
        Transaction tx=session.beginTransaction();
        tx.commit();
        session.close();
        factory.close();

    }
}
