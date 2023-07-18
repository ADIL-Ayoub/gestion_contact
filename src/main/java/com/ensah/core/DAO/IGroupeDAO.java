package com.ensah.core.DAO;

import com.ensah.core.bo.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroupeDAO extends JpaRepository<Groupe, Long> {
    //public List<Groupe> findAllByName(String name);
    public List<Groupe> findAllByNameContainsIgnoreCaseOrderByName(String name);

}
