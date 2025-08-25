/**
 * Jorge Flores
 * February 2025
 * ContactDAO.java - Simplified version without external dependencies
 */

package contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactDAO {
    private final Map<String, Contact> contacts = new HashMap<>();
    
    public ContactDAO() {
        // Default constructor - uses in-memory storage
    }
    
    public ContactDAO(String dbUrl) {
        // For compatibility - ignores dbUrl and uses in-memory storage
    }
    
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists: " + contact.getContactId());
        }
        contacts.put(contact.getContactId(), contact);
    }
    
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
    
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }
    
    public void updateContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (!contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact not found: " + contact.getContactId());
        }
        contacts.put(contact.getContactId(), contact);
    }
    
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found: " + contactId);
        }
        contacts.remove(contactId);
    }
    
    public boolean contactExists(String contactId) {
        return contacts.containsKey(contactId);
    }
}
