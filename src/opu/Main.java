package opu;

public class Main {

   public static void main(String[] args) {
      final User user1 = new User("user1", "Password1", SystemRole.ADMIN);
      final User user2 = new User("user2", "Password1", SystemRole.USER);
      final User user3 = new User("user3", "Password1", SystemRole.GUEST);
/*
      System.out.println(user1);
      System.out.println(user2);
      System.out.println(user3);
*/
      System.out.println();

      final Users users = new Users(3);
      users.addUser(user1);
      users.addUser(user2);
      users.addUser(user3);
//      System.out.println("The oldest user is: " + users.findOldestUser());
//      System.out.println();
//      System.out.println(users);
//      System.out.println();
//      users.removeUser(1);
//      System.out.println(users);
//      users.removeUser("user1");
//      System.out.println();
      System.out.println(users);


   }
}
