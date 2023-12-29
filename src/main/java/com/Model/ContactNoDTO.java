package com.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ContactNoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contact_Id;
    private long contact_No;
    private String contact_Holder_Name;
    private String service_Provide;
    private boolean _5GUnable_Or_not;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="whatsappDTO")
    private WhatsappDTO whatsappDTO;

}
