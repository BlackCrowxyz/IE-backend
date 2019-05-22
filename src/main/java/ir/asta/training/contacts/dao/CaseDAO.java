package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.CaseEntity;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 5/4/2019.
 */
@Named("caseDAO")
public class CaseDAO {
    public List<CaseEntity> getAll(){
        List<CaseEntity> entities = new ArrayList<>();
        entities.add(new CaseEntity("Ehsan"));
        entities.add(new CaseEntity("Pouya"));
        entities.add(new CaseEntity("Ali"));
        entities.add(new CaseEntity("Khar"));
        return entities;
    }
}
