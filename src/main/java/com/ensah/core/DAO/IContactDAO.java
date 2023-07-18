package com.ensah.core.DAO;

import com.ensah.core.bo.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContactDAO extends JpaRepository<Contact,Long> {
    public List<Contact> findAllByFirstNameContainsIgnoreCaseOrderByFirstName(String name);
    public List<Contact> findAllByLastNameContainsIgnoreCaseOrderByFirstName(String name);
    public List<Contact> findAllByPersonnalNumberContainsIgnoreCaseOrderByFirstName(String number);
    public List<Contact> findAllByProfessionalNumberContainsIgnoreCaseOrderByFirstName(String number);
}
