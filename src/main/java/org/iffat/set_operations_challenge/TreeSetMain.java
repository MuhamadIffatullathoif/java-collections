package org.iffat.set_operations_challenge;

import org.iffat.sets_and_maps.Contact;
import org.iffat.sets_and_maps.ContactData;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        // NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("-".repeat(90));
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("-".repeat(90));
        System.out.printf("min = %s, first = %s %n", min.getName(), first.getName());
        System.out.printf("max = %s, last = %s %n", max.getName(), last.getName());
        System.out.println("-".repeat(90));

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("-".repeat(90));

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact contact : List.of(daffy, daisy, last, snoopy)) {
            System.out.printf("ceiling(%s)=%s%n", contact.getName(), fullSet.ceiling(contact));
            System.out.printf("higher(%s)=%s%n", contact.getName(), fullSet.higher(contact));
        }
        System.out.println("-".repeat(90));

        for (Contact contact : List.of(daffy, daisy, first, archie)) {
            System.out.printf("floor(%s)=%s%n", contact.getName(), fullSet.floor(contact));
            System.out.printf("lower(%s)=%s%n", contact.getName(), fullSet.lower(contact));
        }
        System.out.println("-".repeat(90));

        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("-".repeat(90));

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("-".repeat(90));
        fullSet.forEach(System.out::println);
        System.out.println("-".repeat(90));

        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion, true);
        headSet.forEach(System.out::println);
        System.out.println("-".repeat(90));

        var tailSet = fullSet.tailSet(marion, false);
        tailSet.forEach(System.out::println);
        System.out.println("-".repeat(90));

        Contact linus = new Contact("Linus Van Pelt");
        // var subset = fullSet.subSet(linus, marion);
        var subset = fullSet.subSet(linus, false, marion, true);
        subset.forEach(System.out::println);
    }
}
