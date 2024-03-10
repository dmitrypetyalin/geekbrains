package phonebook;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Felix", "+79239232233");
        pb.add("Felix", "+79239232234");
        pb.showAllContacts();
        pb.showAll();
        System.out.println(pb.findByName("Felix"));
        System.out.println(pb.findByPhone("+79239232234"));

        pb.delete("Felix");
        pb.showAllContacts();
    }
}
