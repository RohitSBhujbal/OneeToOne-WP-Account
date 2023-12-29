package com.Connection;

import com.Model.ContactNoDTO;
import com.Model.WhatsappDTO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryHelper {

    public static SessionFactory getsessionFactory(){
        Configuration cfg=new Configuration().configure().addAnnotatedClass(ContactNoDTO.class).addAnnotatedClass(WhatsappDTO.class);
        SessionFactory factory=cfg.buildSessionFactory();
        return factory;
    }
}
