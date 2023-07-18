package com.ensah.core.services;

import com.ensah.core.DAO.IGroupeDAO;
import com.ensah.core.bo.Contact;
import com.ensah.core.bo.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GroupeServiceImpl implements IGroupeService{
    @Autowired
    private IGroupeDAO dao;


    @Override
    public void saveOrUpdateGroupe(Groupe groupe) {
        dao.save(groupe);
    }

    @Override
    public void deleteGroupe(Long id) {
        dao.delete(getGroupeById(id));
    }

    @Override
    public List<Groupe> getAllGroupes() {
        List<Groupe> listGroupe=new ArrayList<>();
        dao.findAll(Sort.by("name")).forEach(groupe->listGroupe.add(groupe));
        return listGroupe;
    }

    @Override
    public Groupe getGroupeById(Long id) {

        return dao.findById(id).get();
    }

    @Override
    public List<Groupe> getGroupesByName(String name) {
        //return dao.findAllByName(name) ;
        return dao.findAllByNameContainsIgnoreCaseOrderByName(name);
    }
}
