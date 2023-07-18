package com.ensah.core.services;

import com.ensah.core.bo.Contact;
import com.ensah.core.bo.Groupe;

import java.util.List;

public interface IGroupeService {
    public void saveOrUpdateGroupe(Groupe groupe);
    public void deleteGroupe(Long id);
    public List<Groupe> getAllGroupes();
    public Groupe getGroupeById(Long id);
    public List<Groupe> getGroupesByName(String name);
}
