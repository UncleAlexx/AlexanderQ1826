package by.itstep.lesson7;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    public static ArrayList<User> withName(Collection<User> users, String name){
        var usersWithName = new ArrayList<User>();
        for (User user : users) {
            if (user.name.equals(name)) {
                usersWithName.add(user);
            }
        }
        return usersWithName;
    }

    public static ArrayList<User> withSex(Collection<User> users, Sex sex){
        var usersWithName = new ArrayList<User>();
        for (User user : users) {
            if (user.sex.equals(sex)) {
                usersWithName.add(user);
            }
        }
        return usersWithName;
    }

    public static List<User> sortedByAge(Collection<User> users){
        Collections.sort(new ArrayList<>(users), new Comparator<User>() {
            @Override
            public int compare(User user1, User user2){
                return  user1.age == user2.age? 0 : user1.age > user2.age? 1 : -1;
            }
        });
        return  users.stream().toList();
    }
}
