package com.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WhatsappDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "genretor_Type")
    @SequenceGenerator(name="genretor_Type",initialValue = 1000,allocationSize = 100)
    private int whatsapp_Id;
    private long whatsapp_No;
    private String whatsapp_User_Name;
    private String about;
    private String acoount_Type;
}
