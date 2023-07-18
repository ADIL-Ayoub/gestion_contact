package com.ensah.core.services;

import com.ensah.core.bo.Contact;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IContactService {
    public void saveOrUpdateContact(Contact contact);
    public void deleteContact(Long id);
    public List<Contact> getAllContacts();
    public Contact getContactById(Long id);
    public List<Contact> getAllContactsByFirstName(String name);
    public List<Contact> getAllContactsByLastName(String name);
    public List<Contact> getAllContactsByPersonnalNumber(String number);
    public List<Contact> getAllContactsByProfessionalNumber(String number);


}
