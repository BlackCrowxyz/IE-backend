package ir.asta.training.contacts.entities;

import javax.persistence.*;

/**
 * Created by ASUS on 5/19/2019.
 */
@Table(name = "details")
@Entity
public class DetailsEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private int detail_id;

    @Column(name = "text")
    private String text;
    @Column(name = "responsible")
    private String responsible;
    //TODO: time set?


    public DetailsEntity() {
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
