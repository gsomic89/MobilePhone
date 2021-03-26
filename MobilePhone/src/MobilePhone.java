import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact newContact){
        if(findContact(newContact.getName()) >= 0){
            System.out.println("contact already on file");
            return false;
        }
        myContacts.add(newContact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + " not found");
            return false;
        }
        this.myContacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was removed");
        return true;
    }

    private int findContact(Contact contact){
        int position = this.myContacts.indexOf(contact);
        return position;
    }

    private int findContact(String name){
        for(int i = 0; i < this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List");
        for(int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i+1) + "."+
                    this.myContacts.get(i).getName()+ "-->" +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}
