package com.ensah.core.bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    @NotBlank(message = "This field is required")
    private String name;
    @ManyToMany
    @JoinTable(name = "contact_groupe", joinColumns = @JoinColumn(name="id_Groupe"),
    inverseJoinColumns = @JoinColumn(name ="id_Contact"))
    private Set<Contact> contacts= new HashSet<>();

    @Override
    public String toString() {
        return "Groupe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }



}
