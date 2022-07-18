package ro.siit.JavaOOPHW2;


public class Main {
    public static void main(String[] args) {
        Phone phone = new XiaomiNote11("91297957912");
        phone.addContact(new Contact(1, "0747213431", "Bobi" , "Ceciliu"));
        phone.addContact(new Contact(2, "0763517318", "Alfonso" , "Ignatiu"));
        phone.listContacts();
        phone.sendMessage(new Contact.Message("0747213431" , "Salut, o zi faina!"));
        phone.listMessages();
        phone.call("0763517318" );
        phone.viewHistory();


    }
}
