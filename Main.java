package phonebook;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Felix", "+79239232233");
        pb.add("Felix", "+79239232234");
        pb.showAllContacts();
    }
}
