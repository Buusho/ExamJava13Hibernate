package peaksoft.peaksoft.service;

import peaksoft.peaksoft.Entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService {
    String saveUserDetailToUserPById(Long user_id , UserDetails userDetails);

    Optional<UserDetails> getUserDById(Long id);

    String updateAddressUserDetails(Long userD_id,String address);
    boolean deleteUserDById(Long id);

    String getUserDetailsByAddress (String address);

    List<UserDetails> sortUserDetailsByDateOfBirth ();
}
