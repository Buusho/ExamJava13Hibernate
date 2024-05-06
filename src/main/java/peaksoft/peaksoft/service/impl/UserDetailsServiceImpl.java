package peaksoft.peaksoft.service.impl;

import peaksoft.peaksoft.Dao.impl.UserDetailsDaoImpl;
import peaksoft.peaksoft.Entity.UserDetails;
import peaksoft.peaksoft.service.UserDetailsService;

import java.util.List;
import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsDaoImpl userDetailsDao = new UserDetailsDaoImpl();
    @Override
    public String saveUserDetailToUserPById(Long user_id, UserDetails userDetails) {
        return userDetailsDao.saveUserDetailToUserPById(user_id,userDetails);
    }

    @Override
    public Optional<UserDetails> getUserDById(Long id) {
        return userDetailsDao.getUserDById(id);
    }

    @Override
    public String updateAddressUserDetails(Long userD_id, String address) {
        return userDetailsDao.updateAddressUserDetails(userD_id,address);
    }

    @Override
    public boolean deleteUserDById(Long id) {
      userDetailsDao.deleteUserDById(id);
        return false;
    }

    @Override
    public String getUserDetailsByAddress(String address) {
        return userDetailsDao.getUserDetailsByAddress(address);
    }

    @Override
    public List<UserDetails> sortUserDetailsByDateOfBirth() {
        return userDetailsDao.sortUserDetailsByDateOfBirth();
    }
}
