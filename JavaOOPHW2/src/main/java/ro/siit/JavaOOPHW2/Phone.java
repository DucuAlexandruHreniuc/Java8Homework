package main.java.ro.siit.JavaOOPHW2;

import java.util.ArrayList;

abstract class Phone {


    protected int batteryLife;
    protected final String imei;
    ArrayList<Contact> contacts = new ArrayList<>();
    ArrayList<Contact.Message> messages = new ArrayList<>();
    ArrayList<String> callList = new ArrayList<>();
    public Phone(String imei) {
//        this.batteryLife = batteryLife;
        this.imei = imei;
    }



    public void addContact(Contact contact){
        contacts.add(contact);

    }
    void listContacts(){

        contacts.forEach(System.out::println);
    }
    void sendMessage(Contact.Message message){
        messages.add(message);
        batteryLife = batteryLife-2;

    }
    void listMessages(){
        messages.forEach(System.out::println);

    }
    void call(String callContact){
        System.out.println("\nYou are calling: " + callContact);
        callList.add(callContact);
        batteryLife = batteryLife-2;
        System.out.println("Battery: " + batteryLife + "h");

    }

    void viewHistory(){
        System.out.println("\nYour call history: ");
        callList.forEach(System.out::println);
    }
}

class Contact {
    int index;
    String phoneNumber;
    String firstName;
    String lastName;

    public Contact(int index, String phoneNumber, String firstName, String lastName) {
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;


    }

    public String toString() {
        return "Contact number: " + index + "\nPhone number: " + phoneNumber + "\nFirst Name: " + firstName + "\nLast name: " + lastName + "\n";
    }

    static class Message {
        String number;
        String content;

        public Message(String number, String content) {
            this.number = number;
            this.content = content;
        }

        @Override
        public String toString() {
            return "Message to: " + number + "\nContent: " + content;
        }
    }

}
class CallContact {
    String callNumber;

    public CallContact(String callNumber) {
        this.callNumber = callNumber;


    }

    @Override
    public String toString() {
        return "You are calling" + callNumber;
    }
}
