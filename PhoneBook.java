package phonebook;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class PhoneBook {
    private static Map<String, Set<String>> map;

    public PhoneBook() {
        map = new HashMap<>();

        map.put("Miller", new LinkedHashSet<>(Collections.singleton("+79239232220")));
        map.put("Fox", new LinkedHashSet<>(Collections.singleton("+79239232221")));
        map.put("Getz", new LinkedHashSet<>(Collections.singletonList("+79239232222")));
        map.put("Koch", new LinkedHashSet<>(Arrays.asList("+79239232223", "+79239232225", "+79239232226")));
        map.put("Brett", new LinkedHashSet<>(Collections.singleton("+79239232224")));
    }

    public void showAllContacts() {
        Map<String, Set<String>> sortedMap = map.entrySet().stream()
                .sorted(comparingByValue(comparingInt(Set::size)))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, Set<String>> entry : sortedMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Phone number: " + entry.getValue());
        }
    }

    public void showAll() {
        Map<String, Set<String>> sortedMap = map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Set<String>> entry : sortedMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Phone number: " + entry.getValue());
        }
    }

    public void add(String name, String number) {
        if (map.containsKey(name)) {
            map.get(name).add(number);
        } else {
            map.put(name, new LinkedHashSet<>(Collections.singleton(number)));
        }
    }

    public Set<String> findByName(String name) {
        return map.get(name);
    }

    public String findByPhone(String phoneNumber) {
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void delete(String name) {
        Object contact = map.remove(name);
        if (contact == null) {
            System.out.println("Contact wasn't found");
        } else {
            System.out.println("Contact " + name + " was deleted");
        }
    }

    public void change(String name, String number) {
    }
}
