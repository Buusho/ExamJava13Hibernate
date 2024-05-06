package peaksoft.peaksoft.service;

import peaksoft.peaksoft.Entity.UserProfile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserProfileService {
    String saveUserP(UserProfile userP);

    Optional<UserProfile> getUserPById(Long id);

    String updateUserP(Long userPId , UserProfile newUserP);

    boolean deleteUserPById(Long id);

    boolean getUserPByEmail(String email);

    List<UserProfile> GetUserRegisteredAfterDate(LocalDate date);

}
