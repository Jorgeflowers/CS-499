/**
 * Jorge Flores
 * February 2025
 * Main.java - Test class for Contact Management System
 */

package contact;

public class Main {
    public static void main(String[] args) {
        System.out.println("Contact Management System - Demo");
        System.out.println("================================");
        
        try {
            // Create service instance
            ContactService service = new ContactService();
            
            // Test adding contacts
            System.out.println("\n1. Adding contacts...");
            Contact contact1 = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
            Contact contact2 = new Contact("002", "Jane", "Smith", "0987654321", "456 Oak Ave");
            
            service.addContact(contact1);
            service.addContact(contact2);
            System.out.println("✓ Added 2 contacts successfully");
            
            // Test retrieving contacts
            System.out.println("\n2. Retrieving contacts...");
            Contact retrieved1 = service.getContact("001");
            Contact retrieved2 = service.getContact("002");
            
            System.out.println("Contact 001: " + retrieved1.getFirstName() + " " + retrieved1.getLastName());
            System.out.println("Contact 002: " + retrieved2.getFirstName() + " " + retrieved2.getLastName());
            
            // Test updating contacts
            System.out.println("\n3. Updating contacts...");
            service.updateFirstName("001", "Jonathan");
            service.updateAddress("002", "789 Pine Rd");
            
            Contact updated1 = service.getContact("001");
            Contact updated2 = service.getContact("002");
            
            System.out.println("Updated Contact 001: " + updated1.getFirstName() + " " + updated1.getLastName());
            System.out.println("Updated Contact 002: " + updated2.getFirstName() + " " + updated2.getLastName() + 
                             " - Address: " + updated2.getAddress());
            
            // Test deleting a contact
            System.out.println("\n4. Deleting contact...");
            service.deleteContact("001");
            Contact deleted = service.getContact("001");
            if (deleted == null) {
                System.out.println("✓ Contact 001 successfully deleted");
            }
            
            // Show remaining contacts
            System.out.println("\n5. Remaining contacts:");
            Contact remaining = service.getContact("002");
            if (remaining != null) {
                System.out.println("Contact 002: " + remaining.getFirstName() + " " + remaining.getLastName());
            }
            
            System.out.println("\n✓ All operations completed successfully!");
            System.out.println("Note: This version uses in-memory storage for simplicity.");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
