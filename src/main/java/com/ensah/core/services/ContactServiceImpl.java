package com.ensah.core.services;

import com.ensah.core.DAO.IContactDAO;
import com.ensah.core.bo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements IContactService{
    @Autowired
    private IContactDAO dao;


    @Override
    public void saveOrUpdateContact(Contact contact) {
        dao.save(contact);
    }
    @Override
    public Contact getContactById(Long id){
        return dao.findById(id).get();
    }

    @Override
    public List<Contact> getAllContactsByFirstName(String name) {
        return dao.findAllByFirstNameContainsIgnoreCaseOrderByFirstName(name);
    }

    @Override
    public List<Contact> getAllContactsByLastName(String name) {
        return dao.findAllByLastNameContainsIgnoreCaseOrderByFirstName(name);
    }

    @Override
    public List<Contact> getAllContactsByPersonnalNumber(String number) {
        return dao.findAllByPersonnalNumberContainsIgnoreCaseOrderByFirstName(number);
    }

    @Override
    public List<Contact> getAllContactsByProfessionalNumber(String number) {
        return dao.findAllByProfessionalNumberContainsIgnoreCaseOrderByFirstName(number);
    }

    @Override
    public List<Contact> getAllContacts(){
        List<Contact> listContact=new ArrayList<>();
        dao.findAll(Sort.by("firstName")).forEach(contact->listContact.add(contact));
        return listContact;
    }

    @Override
    public void deleteContact(Long id) {
        dao.delete(getContactById(id));
    }


}
