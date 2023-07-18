package com.ensah.core.bo;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Contact {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private Long id;
    @NotBlank(message = "This field is required")
    private String firstName;
    @NotBlank(message = "This field is required")
    private String lastName;
    @NotBlank(message = "This field is required")
    private String personnalNumber;
    @NotBlank(message = "This field is required")
    private String professionalNumber;
    @NotBlank(message = "This field is required")
    private String address;
    @NotBlank(message = "This field is required")
    @Email(message = "Enter a valid email")
    private String personnalEmail;
    @NotBlank(message = "This field is required")
    @Email(message = "Enter a valid email")
    private String professionalEmail;
    @NotBlank(message = "This field is required")
    private String gender;
    @ManyToMany(mappedBy = "contacts")
    private Set<Groupe> groupes=new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
*/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonnalNumber() {
        return personnalNumber;
    }

    public void setPersonnalNumber(String personnalNumber) {
        this.personnalNumber = personnalNumber;
    }

    public String getProfessionalNumber() {
        return professionalNumber;
    }

    public void setProfessionalNumber(String professionalNumber) {
        this.professionalNumber = professionalNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonnalEmail() {
        return personnalEmail;
    }

    public void setPersonnalEmail(String personnalEmail) {
        this.personnalEmail = personnalEmail;
    }

    public String getProfessionalEmail() {
        return professionalEmail;
    }

    public void setProfessionalEmail(String professionalEmail) {
        this.professionalEmail = professionalEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personnalNumber='" + personnalNumber + '\'' +
                ", professionalNumber='" + professionalNumber + '\'' +
                ", address='" + address + '\'' +
                ", personnalEmail='" + personnalEmail + '\'' +
                ", professionalEmail='" + professionalEmail + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
