package ir.asta.training.contacts.services.impl;

import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.manager.CaseManager;
import ir.asta.training.contacts.services.CaseService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ASUS on 5/4/2019.
 */
@Named("caseService")
public class CaseServiceImpl implements CaseService {
    @Inject
    private CaseManager manager;

    @Override
    public List<CaseEntity> getAll() {
        return manager.getAll();
    }
}
