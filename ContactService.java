/**
 * Jorge Flores
 * February 2025
 * ContactService.java
 */

package contact;

public class ContactService {
	private final ContactDAO contactDAO;
	
	public ContactService() {
		this.contactDAO = new ContactDAO();
	}
	
	// Constructor for testing with in-memory database
	public ContactService(String dbUrl) {
		this.contactDAO = new ContactDAO(dbUrl);
	}
	
	// new contact
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact must not be null.");
		}
		contactDAO.addContact(contact);
	}
	
	// deletes the contact id
	public void deleteContact(String contactId) {
		contactDAO.deleteContact(contactId);
	}
	
	// updates the firstName
	public void updateFirstName(String contactId, String firstName) {
		Contact contact = contactDAO.getContact(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact Id not found.");
		}
		contact.setFirstName(firstName);
		contactDAO.updateContact(contact);
	}
	
	// updates lastName
	public void updateLastName(String contactId, String lastName) {
		Contact contact = contactDAO.getContact(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact Id not found.");
		}
		contact.setLastName(lastName);
		contactDAO.updateContact(contact);
	}
	
	// updates the phone
	public void updatePhone(String contactId, String phone) {
		Contact contact = contactDAO.getContact(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact Id not found.");
		}
		contact.setPhone(phone);
		contactDAO.updateContact(contact);
	}
	
	// updates the address
	public void updateAddress(String contactId, String address) {
		Contact contact = contactDAO.getContact(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact id not found.");
		}
		contact.setAddress(address);
		contactDAO.updateContact(contact);
	}
	
	// retrieves contact
	public Contact getContact(String contactId) {
		return contactDAO.getContact(contactId);
	}
}
	



