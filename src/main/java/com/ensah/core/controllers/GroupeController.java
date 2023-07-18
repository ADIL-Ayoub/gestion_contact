package com.ensah.core.controllers;

import com.ensah.core.DAO.IGroupeDAO;
import com.ensah.core.bo.Contact;
import com.ensah.core.bo.Groupe;
import com.ensah.core.services.IContactService;
import com.ensah.core.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/groupes")
public class GroupeController {

    @Autowired
    private IGroupeService service;

    @Autowired
    IContactService contactService;

    @ModelAttribute("test")
    public String test2(Model model){
        System.out.println("model method is called.");
        return "ok";
    }
    @RequestMapping("test3")
    public void test3(@ModelAttribute("test") String s){
        System.out.println("this is: "+s);
    }


    @RequestMapping(value = {""})
    public String showGroupeList(Model model) {
        model.addAttribute("groupes", service.getAllGroupes());
        return "groupeList";
    }

    @RequestMapping("/showMembers")
    public String showMembers(Model model) {
        model.addAttribute("contactList", contactService.getAllContacts());
        return "members";
    }

    /*    @RequestMapping("/members")
        public String showMembers(HttpServletRequest request, RedirectAttributes attributes) {
            String[] ids = request.getParameterValues("chosenContact");
            Groupe groupe = new Groupe();
            Set<Contact> contacts = new HashSet<>();
            if (ids != null)
                for (String id : ids) {
                    contacts.add(contactService.getContactById(Long.parseLong(id)));
                }
            groupe.setContacts(contacts);
            attributes.addFlashAttribute("groupeModel", groupe);
            return "redirect:/groupes/showForm";
        }*/
    @RequestMapping("/showForm")
    public String showMembers(HttpServletRequest request, Model model) {
        String[] ids = request.getParameterValues("chosenContact");
        Groupe groupe = new Groupe();
        Set<Contact> contacts = new HashSet<>();
        if (ids != null)
            for (String id : ids) {
                contacts.add(contactService.getContactById(Long.parseLong(id)));
            }
        groupe.setContacts(contacts);
        //add the group to the session
        HttpSession session = request.getSession();
        session.setAttribute("groupeModel", groupe);
        model.addAttribute("groupeModel", new Groupe());
        return "groupeForm";
    }

    /*    @RequestMapping("/showForm")
        public String showGroupeForm(@ModelAttribute("groupeModel") Groupe groupe, HttpServletRequest request,
                                     Model model) {
            HttpSession session = request.getSession();
            session.setAttribute("groupeModel", groupe);
            return "groupeForm";
        }*/
    @RequestMapping("/addGroupe")
    public String addContact(@Valid @ModelAttribute("groupeModel") Groupe groupe, BindingResult bindingResult,
                             Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMsg", "Les données sont invalides.");
        } else {
            HttpSession session = request.getSession();
            Groupe sessionGroupe = (Groupe) session.getAttribute("groupeModel");
            session.removeAttribute("groupeModel");
            groupe.setContacts(sessionGroupe.getContacts());
            groupe.setId(sessionGroupe.getId());
            // System.out.println(groupe);
            service.saveOrUpdateGroupe(groupe);
            return "redirect:/groupes/";
        }
        return "groupeForm";
    }

    @RequestMapping("/modify/{id}")
    public String modify(@PathVariable(name = "id") Long id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        List<Contact> allContacts = contactService.getAllContacts();
        Set<Contact> oldContacts = service.getGroupeById(id).getContacts();
        Set<Contact> notInGroupeContacts = new HashSet<>();
        for (Contact contact : allContacts) {
            if (!oldContacts.contains(contact)) {
                notInGroupeContacts.add(contact);
            }
        }
        /*System.out.println("old ones");
        if (oldContacts != null)
            for (Contact contact : oldContacts)
                System.out.println(contact);
        System.out.println("new ones");
        if (notInGroupeContacts != null)
            for (Contact contact : notInGroupeContacts)
                System.out.println(contact);*/

        model.addAttribute("oldContacts", oldContacts);
        model.addAttribute("notInGroupeContacts", notInGroupeContacts);

        return "editGroupeForm";
    }

    @RequestMapping("/modifyGroupe")
    public String modifyContact(HttpServletRequest request) {
        String newName = (String) request.getParameter("name");
        String[] oldIds = request.getParameterValues("chosenOldContacts");
        String[] newIds = request.getParameterValues("chosenNewContacts");
        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute("id");
        System.out.println("id : " + id);
        session.removeAttribute("id");
        System.out.println(" after id : " + id);
        Groupe groupe = service.getGroupeById(id);
        groupe.setName(newName);
        Set<Contact> newContacts = new HashSet<>();
        if (oldIds != null)
            for (String t_id : oldIds) {
                newContacts.add(contactService.getContactById(Long.parseLong(t_id)));
            }
        if (newIds != null)
            for (String t_id : newIds) {
                newContacts.add(contactService.getContactById(Long.parseLong(t_id)));
            }
        groupe.setContacts(newContacts);
        System.out.println(groupe);
        service.saveOrUpdateGroupe(groupe);
        return "redirect:/groupes/";


    }

    @RequestMapping("/delete/{id}")
    public String deleteContact(@PathVariable(name = "id") Long id, Model model) {
        service.deleteGroupe(id);
        model.addAttribute("groupes", service.getAllGroupes());
        return "redirect:/groupes/";
    }


    @RequestMapping("/findGroupe")
    public String search(Model model, HttpServletRequest request) {
        String searchValue = (String) request.getParameter("searchValue");
        System.out.println("-------------" + searchValue);
        System.out.println("groupes:\n");
        for (Groupe groupe : service.getGroupesByName(searchValue)) {
            System.out.println(groupe);
        }
        model.addAttribute("groupes", service.getGroupesByName(searchValue));
        return "groupeList";
    }
}
