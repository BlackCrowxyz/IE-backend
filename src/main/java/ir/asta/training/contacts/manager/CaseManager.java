package ir.asta.training.contacts.manager;

import ir.asta.training.contacts.dao.CaseDAO;
import ir.asta.training.contacts.entities.CaseEntity;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ASUS on 5/4/2019.
 */
@Named("caseManager")
public class CaseManager {
    @Inject
    private CaseDAO dao;

    public List<CaseEntity> getAll(){
        return dao.getAll();
    }
}
