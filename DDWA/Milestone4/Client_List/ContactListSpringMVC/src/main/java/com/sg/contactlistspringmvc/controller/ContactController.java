/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistspringmvc.controller;

import com.sg.contactlistspringmvc.dao.ContactListDao;
import com.sg.contactlistspringmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmlnd
 */
@Controller
public class ContactController {

    ContactListDao dao;

    @Inject
    public ContactController(ContactListDao dao) {
        this.dao = dao;
    }

    // Controller Endpoint
    /*
    
    This code does the following:

        Maps the /deleteContact URL pattern to this method - because this request is sent as a result of clicking on a link, the HTTP method is GET.
        Grabs the contactId from the request.
        Converts the contactId value to a long.
        Asks the DAO to remove the Contact associated with the given id from the system.
        Redirects to the displayContactsPage endpoint so the updated MyContacts table can be displayed.
    
     */
    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public String deleteContact(HttpServletRequest request) {
        String contactIdParameter = request.getParameter("contactId");
        long contactId = Long.parseLong(contactIdParameter);
        dao.removeContact(contactId);
        return "redirect:displayContactsPage";
    }

    // create the controller endpoint to handle the displayEditContactForm request.  
    @RequestMapping(value = "/displayEditContactForm", method = RequestMethod.GET)
    public String displayEditContactForm(HttpServletRequest request, Model model) {
        String contactIdParameter = request.getParameter("contactId");
        long contactId = Long.parseLong(contactIdParameter);
        Contact contact = dao.getContactById(contactId);
        model.addAttribute("contact", contact);
        return "editContactForm";
    }

    @RequestMapping(value = "/displayContactDetails", method = RequestMethod.GET)
    public String displayContactDetails(HttpServletRequest request, Model model) {
        String contactIdParameter = request.getParameter("contactId");
        int contactId = Integer.parseInt(contactIdParameter);
        Contact contact = dao.getContactById(contactId);
        model.addAttribute("contact", contact);
        return "contactDetails";
    }

    @RequestMapping(value = "/displayContactsPage", method = RequestMethod.GET)
    public String displayContacts(Model model) {

        List<Contact> contactList = dao.getAllContacts();

        //put list of contacts on the model
        model.addAttribute("contactList", contactList);
        //return logical name of view compnent
        return "contacts";
    }

    @RequestMapping(value = "/createContact", method = RequestMethod.GET)
    public String createContact(HttpServletRequest request) {
        // grabbing the incomin values from the form and create the new contact
        Contact contact = new Contact();
        contact.setFirstName(request.getParameter("firstName"));
        contact.setLastName(request.getParameter("lastName"));
        contact.setCompany(request.getParameter("company"));
        contact.setPhone(request.getParameter("phone"));
        contact.setEmail(request.getParameter("email"));

        //persist the new contact
        dao.addContact(contact);

        // we don't want to forward to a View component - we want to
        // redirect to the endpoint that displays the Contacts Page
        // so it can display the new Contact in the table.
        return "redirect:displayContactsPage";
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.POST)
    public String editContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {

        if (result.hasErrors()) {
            return "editContactForm";
        }

        dao.updateContact(contact);

        return "redirect:displayContactsPage";
    }
}
