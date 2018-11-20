package users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersService {

    private static UsersService instance;
    private Integer nextId;
    private List<User> users;

    private UsersService() {
        this.users = new ArrayList<>();
        this.nextId = 1;
        save(new User("Jan", "Nowak", 24, "male"));
        save(new User("Anna", "Nowak", 25, "female"));
        save(new User("Jurek", "Nowak", 27, "male"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }


    public static UsersService instanceOf() {
        if (instance == null) {
            instance = new UsersService();
        }
        return instance;
    }

    public void save(User user) {
        if (user.getId() != null) {
            users.stream()
                    .filter(e -> e.getId().equals(user.getId()))
                    .findAny()
                    .ifPresent(e -> {
                        e.setFirstName(user.getFirstName());
                        e.setLastName(user.getLastName());
                        e.setGender(user.getGender());
                        e.setAge(user.getAge());

                    });
        } else {
            user.setId(nextId++);
            users.add(user);
        }
    }

    public User findById(int id) throws UserNotFoundException {
        return users.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException("User with Id" + id + "does not exists"));
    }

    public List<User> findByQuery(String query) {
        List<User> usersToReturn = new ArrayList<>();
        for (User user : users) {
            String userRepresentation = user.getFirstName() + " " + user.getLastName();
            if (userRepresentation.contains(query)) {
                usersToReturn.add(user);
            }
        }
        return usersToReturn;
    }

    public void delete(Integer id) {
        this.users= users.stream()
                .filter(e-> !e.getId().equals(id))
                .collect(Collectors.toList());
    }
}
