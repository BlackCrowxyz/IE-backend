package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.BookEntity;
import ir.asta.training.contacts.entities.TimeEntity;

import javax.inject.Named;

/**
 * Created by ASUS on 5/5/2019.
 */
@Named("MyDao")
public class MyDao {

    public BookEntity bookEntity(BookEntity entity) {
        entity.setAuthor("Mr."+entity.getAuthor());
        entity.setBookname(entity.getBookname()+", a novel");
        entity.setComment(entity.getAuthor()+" "+entity.getBookname());
        return entity;
    }

    public String getTime(TimeEntity entity) {
        entity.setText("امروز:\n"+entity.getYear()+"/"+entity.getMonth()+"/"+entity.getDay());
        return entity.getText();
    }
}
