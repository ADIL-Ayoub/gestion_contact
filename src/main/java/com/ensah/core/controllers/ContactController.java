package com.ensah.core.controllers;

import com.ensah.core.bo.Contact;
import com.ensah.core.services.ContactServiceImpl;
import com.ensah.core.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private IContactService contactService;

    private HashMap<String,String> genders= new HashMap<>();

    public ContactController(){
        genders.put("Male","Male");
        genders.put("Female","Female");
    }
    //  for testing
    @RequestMapping("/test")
    public String test(Model model){
        return "temp";
    }


    //List of contacts
    @RequestMapping(name="/")
    public String showContactList(Model model){
        model.addAttribute("contactList",contactService.getAllContacts());
        return "contactList";
    }

    //show form for new contact
    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("contactModel",new Contact());
        model.addAttribute("genders",genders);
        return  "form";
    }
    //save the new contact or after modifications
    @RequestMapping ("/addContact")
    public String addContact(@Valid @ModelAttribute("contactModel") Contact contact, BindingResult bindingResult,
                             Model model) {
        model.addAttribute("genders",genders);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMsg", "Les données sont invalides.");
        } else {
            contactService.saveOrUpdateContact(contact);
            return "redirect:/";
        }
        return "form";
    }
    @RequestMapping("/modify/{id}")
    public String modify(@PathVariable(name="id") Long id, Model model){
        Contact contact=contactService.getContactById(id);
        model.addAttribute("contactModel",contact);
        model.addAttribute("genders",genders);
        return "editForm";
    }

    @RequestMapping ("/modifyContact")
    public String modifyContact(@Valid @ModelAttribute("contactModel") Contact contact, BindingResult bindingResult,
                             Model model) {
        model.addAttribute("genders",genders);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMsg", "Les données sont invalides.");
        } else {
            contactService.saveOrUpdateContact(contact);
            return "redirect:/";
        }

        return "editForm";
    }
    @RequestMapping("/delete/{id}")
    public String deleteContact(@PathVariable(name="id") Long id, Model model){
        contactService.deleteContact(id);
        model.addAttribute("contactList",contactService.getAllContacts());
        return "redirect:/";
    }
    @RequestMapping("/findContact")
    public String findContact(){
        return "newContactSearch";
    }
   /* @RequestMapping("/findContactBy")
    public String findContactBy(@ModelAttribute("contactModel") Contact contact,Model model){
        System.out.println(contact.getGender());
        List<Contact> contactFound=new ArrayList<>();
        if(contact.getGender().equals("name")){
            for(Contact buffcontact :contactService.getAllContacts()){
                if(buffcontact.getFirstName().equals(contact.getFirstName()) || buffcontact.getLastName().equals(contact.getFirstName()))
                    contactFound.add(buffcontact);
            }
            model.addAttribute("contactFound",contactFound);
            model.addAttribute("foundBy","Name");

        }else if(contact.getGender().equals("professionalnumber")){
            for(Contact buffcontact :contactService.getAllContacts()){
                    if(buffcontact.getProfessionalNumber().equals(contact.getFirstName()))
                        contactFound.add(buffcontact);
            }
            model.addAttribute("contactFound",contactFound);
            model.addAttribute("foundBy","Professional number");

        }else if(contact.getGender().equals("personnalnumber")){
                for(Contact buffcontact :contactService.getAllContacts()){
                    if(buffcontact.getPersonnalNumber().equals(contact.getFirstName()))
                        contactFound.add(buffcontact);
                }
                model.addAttribute("contactFound",contactFound);
                model.addAttribute("foundBy","Personnal number");

        }
        return "contactFound";
    }
*/
    @RequestMapping("/newFind")
    public String newFind(HttpServletRequest request,Model model){
        String searchValue = (String) request.getParameter("searchValue");
        String type= (String) request.getParameter("type");
        List<Contact> contactList = new ArrayList<>();
        if(type.equals("name")){
            contactList= contactService.getAllContactsByFirstName(searchValue);
            List<Contact> contacts=contactService.getAllContactsByLastName(searchValue);
            for(Contact contact:contacts )
                if(!contactList.contains(contact))
                    contactList.add(contact);
        }else if(type.equals("personnal")){
            contactList=contactService.getAllContactsByPersonnalNumber(searchValue);
        }else if(type.equals("professional")){
            contactList=contactService.getAllContactsByProfessionalNumber(searchValue);
        }

        model.addAttribute("contactList",contactList);
        return "contactList";
    }


/*
    @RequestMapping("/findContactByName")
    public String findContactByName(@ModelAttribute("contactModel") Contact contact, Model model){
        List<Contact> contactFound=new ArrayList<>();
        for(Contact buffcontact :contactService.getAllContacts()){
            if(buffcontact.getFirstName().equals(contact.getFirstName()) || buffcontact.getLastName().equals(contact.getLastName()))
                contactFound.add(buffcontact);
        }
        model.addAttribute("contactFound",contactFound);
        model.addAttribute("foundBy","Name");
        return "contactFound";
    }

    @RequestMapping("/findContactByNumber")
    public String findContactByNumber(@ModelAttribute("typeOfNumber") String typeOfNumber,@ModelAttribute("contactModel") Contact contact, Model model){
        List<Contact> contactFound=new ArrayList<>();
        for(Contact buffcontact :contactService.getAllContacts()){
            if(typeOfNumber.equals("personnal")){
                if(buffcontact.getPersonnalNumber().equals(contact.getPersonnalNumber()))
                    contactFound.add(buffcontact);
            }else{
                if(buffcontact.getProfessionalNumber().equals(contact.getProfessionalNumber()))
                    contactFound.add(buffcontact);
            }
        }
        model.addAttribute("contactFound",contactFound);
        model.addAttribute("foundBy","Number");
        return "contactFound";
    }*/
}
