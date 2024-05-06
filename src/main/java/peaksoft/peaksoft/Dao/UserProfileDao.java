package peaksoft.peaksoft.Dao;

import jdk.dynalink.linker.LinkerServices;
import peaksoft.peaksoft.Entity.UserProfile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserProfileDao {

    String saveUserP(UserProfile userP);

    Optional<UserProfile> getUserPById(Long id);

    String updateUserP(Long userPId , UserProfile newUserP);

    void deleteUserPById(Long id);

    void getUserPByEmail(String email);

   List<UserProfile> GetUserRegisteredAfterDate(LocalDate date);




}
