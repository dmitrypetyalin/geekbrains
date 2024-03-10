package phonebook;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class PhoneBook {
    private Map<String, Set<String>> map;

    public PhoneBook() {
        map = new HashMap<String, Set<String>>();

        map.put("Miller", new LinkedHashSet<String>(Collections.singleton("+79239232220")));
        map.put("Fox", new LinkedHashSet<String>(Collections.singleton("+79239232221")));
        map.put("Getz", new LinkedHashSet<String>(Collections.singletonList("+79239232222")));
        map.put("Koch", new LinkedHashSet<String>(Arrays.asList("+79239232223", "+79239232225", "+79239232226")));
        map.put("Brett", new LinkedHashSet<String>(Collections.singleton("+79239232224")));
    }

    public void showAllContacts() {

        Map<String, Set<String>> sorted = map.entrySet().stream()
                .sorted(comparingByValue(comparingInt(Set::size)))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        HashMap::new
                ));

        for (Map.Entry<String, Set<String>> entry : sorted.entrySet()) {
            String k = entry.getKey();
            Set<String> v = entry.getValue();
            System.out.println("Name: " + k + ", Phone number: " + v);
        }
    }
    public void add(String name, String number) {
        if (map.containsKey(name)) {
            map.get(name).add(number);
        } else {
            map.put(name, new LinkedHashSet<String>(Collections.singleton(number)));
        }
    }

    public Set<String> find(String name) {
        return new LinkedHashSet<>();
    }

    public void change(String name, String number) {

    }

    public void delete() {

    }
}
