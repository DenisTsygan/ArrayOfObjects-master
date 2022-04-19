package opu;

import java.time.LocalDateTime;


import static opu.utilityPasswordMaker.generatePassword;

public class Users {
   private final int Days_Registered_Ago=2;
   private User[] users;
   private int currentUserNumber;


   public Users(final int usersNumber) {
      this.users = new User[usersNumber];
      currentUserNumber = -1;
   }

   public User findOldestUser() {
      User user1 = users[0];

      for (final User user : users) {
         if (user.getRegistrationDate().isBefore(user1.getRegistrationDate())) user1 = user;
      }

      return user1;
   }


   public void addUser(final User user) {
      if (++currentUserNumber < users.length) {
         users[currentUserNumber] = user;
      }
      CheckDayRegistration(user);

   }

   private void CheckDayRegistration(User user) {
      if(user.getRegistrationDate().plusDays(Days_Registered_Ago).isBefore(LocalDateTime.now())){
          user.setPassword(generatePassword());
      }
   }

   private void delUserByNumber(final int number) {
      final Users tempUsers = new Users(currentUserNumber);
      tempUsers.currentUserNumber = currentUserNumber;

      int newIndex = 0;
      for (int i = 0; i <= currentUserNumber; i++) {
         if (i == number) continue;
         tempUsers.users[newIndex++] = users[i];
      }
      users = tempUsers.users;
      currentUserNumber--;
   }

   public void removeUser(final int number) {
      if (number < 0 || number >= currentUserNumber) {
         return;
      } else {
         delUserByNumber(number);
      }
   }

   public void removeUser(final String login) {
      int number = 0;
      for (final User user : users) {
         if (user.getLogin().equalsIgnoreCase(login.strip())) {
            delUserByNumber(number);

            return;
         }
         number++;
      }
   }

   @Override
   public String toString() {
      String result = "Users: " + System.lineSeparator();

      for (final User user : users) {
         result += user + System.lineSeparator();
      }

      return result;
   }
}
