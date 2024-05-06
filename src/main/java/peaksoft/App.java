package peaksoft;

import org.postgresql.jdbc.EscapedFunctions2;
import peaksoft.peaksoft.Entity.UserDetails;
import peaksoft.peaksoft.Entity.UserProfile;
import peaksoft.peaksoft.config.HibernateConfig;
import peaksoft.peaksoft.service.UserDetailsService;
import peaksoft.peaksoft.service.UserProfileService;
import peaksoft.peaksoft.service.impl.UserDetailsServiceImpl;
import peaksoft.peaksoft.service.impl.UserProfileServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        UserProfileService userProfileService = new UserProfileServiceImpl();
        UserDetailsService userDetailsService = new UserDetailsServiceImpl();

        while (true) {
            System.out.println("""
                    1.Save User Profile
                    2.Get User Profile
                    3.Update
                    4.Delete
                    5.Find User By Email
                    6.Get User After Registration Date
                    --------------------
                    7.Save user Details
                    8.Get User Detail
                    9.Update Address
                    10.Delete
                    11.Get User Details By Address
                    12.Sort User Details BY DateOFBirth
                    """);

            switch (new Scanner(System.in).nextInt()){
                case 1 ->{
                    UserProfile userProfile = UserProfile.builder().user_name(new Scanner(System.in).next()).email(new Scanner(System.in).next()).registration_date(LocalDate.now()).build();
                    System.out.println(userProfileService.saveUserP(userProfile));
                }
                case 2 ->{
                    System.out.println(userProfileService.getUserPById(new Scanner(System.in).nextLong()));
                }
                case 3 ->{
                    Scanner sc =  new Scanner(System.in);
                    System.out.println("Choose House Profile Id");
                    Long id = sc.nextLong();
                    System.out.println("Enter new user_name :");
                    String newName = sc.next();
                    System.out.println("Enter new Email");
                    String newEmail = sc.next();
                    System.out.println("Enter New registration date (yyyy-MM-dd):");
                    LocalDate newreg = LocalDate.parse(sc.nextLine());

                    UserProfile  userProfile = new UserProfile();
                     userProfile.setUser_name(newName);
                     userProfile.setEmail(newEmail);
                     userProfile.setRegistration_date(newreg);
                    System.out.println(userProfileService.updateUserP(id,userProfile));
                }
                case 4 ->{
                    System.out.println(userProfileService.deleteUserPById(new Scanner(System.in).nextLong()));
                }
                case 5 ->{
                    System.out.println(userProfileService.getUserPByEmail(new Scanner(System.in).next()));
                }
                case 6 ->{
                    System.out.println("Enter registration date (yyyy-MM-dd):");
                    System.out.println(userProfileService.GetUserRegisteredAfterDate(LocalDate.now()));
                }
                case 7 ->{
                     UserDetails userDetails = UserDetails.builder().full_name(new Scanner(System.in).next()).date_of_birth(LocalDate.now()).address(new Scanner(System.in).next()).build();
                    System.out.println(userDetailsService.saveUserDetailToUserPById(new Scanner(System.in).nextLong(),userDetails));
                }
                case 8 ->{
                    System.out.println(userDetailsService.getUserDById(new Scanner(System.in).nextLong()));
                }
                case 9 ->{
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter new Address :");
                    String newAddress = sc.next();
                    UserDetails userDetails = new UserDetails();
                    userDetails.setAddress(newAddress);
                    System.out.println(userDetailsService.updateAddressUserDetails(new Scanner(System.in).nextLong(),newAddress));
                }
                case 10 ->{
                    System.out.println(userDetailsService.deleteUserDById(new Scanner(System.in).nextLong()));
                }
                case 11 ->{
                    System.out.println(userDetailsService.getUserDetailsByAddress(new Scanner(System.in).next()));
                }
                case 12 ->{
                    System.out.println(userDetailsService.sortUserDetailsByDateOfBirth());
                }
            }

        }


    }
}
