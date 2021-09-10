package Day6_28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class CollectionTest03 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        User u1 = new User("lixianghuan");
        c1.add(u1);

        User u2 = new User("lixianghuan");
        System.out.println(c1.contains(u2));
    }
}

class User {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }
}


