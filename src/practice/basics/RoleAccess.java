package practice.basics;
enum Role{
    ADMIN,USER
    }

public class RoleAccess {
    public static void main(String[] args) {
        Role role=Role.ADMIN;
        switch (role) {
            case USER -> System.out.println("Access granted: Limited feature.");
            case ADMIN -> System.out.println("Access granted: Full control.");
        }
        }
    }

