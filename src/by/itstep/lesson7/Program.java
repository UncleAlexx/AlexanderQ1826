package by.itstep.lesson7;

import java.util.*;

public class Program {
    static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        var treeSet = new TreeSet<User>();
        var hashSet = new HashSet<User>();
        hashSet.add(new User("namt2", Sex.MALE, 11));
        hashSet.add(new User("name", Sex.FEMALE, 11));
        hashSet.add(new User("nama", Sex.FEMALE, 11));
        hashSet.add(new User("n", Sex.MALE, 11));
        hashSet.add(new User("name", Sex.MALE, 1));
        hashSet.add(new User("name", Sex.MALE, 2));
        hashSet.add(new User("namt", Sex.MALE, 11));

        treeSet.add(new User("namt2", Sex.MALE, 11));
        treeSet.add(new User("name", Sex.FEMALE, 11));
        treeSet.add(new User("nama", Sex.FEMALE, 11));
        treeSet.add(new User("n", Sex.MALE, 11));
        treeSet.add(new User("name", Sex.MALE, 1));
        treeSet.add(new User("name", Sex.MALE, 2));
        treeSet.add(new User("namt", Sex.MALE, 11));
        var treeSet2 = (TreeSet<User>)(treeSet.clone());
        var hashSet2 = (HashSet<User>)(hashSet.clone());
        List<User> list =((HashSet<User>)hashSet.clone()).stream().toList();

        for(var i: treeSet){
            System.out.println(i);
        }

        System.out.println();
        hashSet.stream().sorted().forEach(System.out::println);
        System.out.println();
        assert UserService.withName(treeSet2, "name").equals(UserService.withName(hashSet2, "name")) &&
               UserService.withName(list, "name").equals(UserService.withName(hashSet2, "name")) &&
               UserService.withName(treeSet2,"name").equals(treeSet2.stream().filter(x -> x.name.equals("name")));
        UserService.withName(treeSet2, "name").forEach(System.out::println);
        System.out.println();
        assert UserService.withSex(treeSet2, Sex.MALE).equals(UserService.withSex(hashSet2, Sex.MALE)) &&
               UserService.withSex(list, Sex.MALE).equals(UserService.withSex(hashSet2, Sex.MALE)) &&
               UserService.withSex(list, Sex.MALE).equals(treeSet2.stream().filter(x -> x.sex == Sex.MALE));
        UserService.withSex(treeSet2, Sex.MALE).forEach(System.out::println);
        System.out.println();
        assert UserService.sortedByAge(treeSet2).equals(UserService.sortedByAge(hashSet2)) &&
               UserService.sortedByAge(treeSet2).equals(UserService.sortedByAge(list)) &&
               UserService.sortedByAge(treeSet2).equals(treeSet2.stream().sorted(Comparator.comparingInt(x -> x.age)));
        UserService.sortedByAge(treeSet2).forEach(System.out::println);

    }
}
