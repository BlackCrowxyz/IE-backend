package ir.asta.training.contacts.entities;

import javax.persistence.*;

/**
 * Created by ASUS on 5/19/2019.
 */
@Table(name = "details")
@Entity
public class DetailsEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    //TODO: other details go here ?? How ??
}
