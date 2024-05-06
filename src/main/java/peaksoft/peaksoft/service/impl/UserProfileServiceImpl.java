package peaksoft.peaksoft.service.impl;

import peaksoft.peaksoft.Dao.impl.UserProfileDaoImpl;
import peaksoft.peaksoft.Entity.UserProfile;
import peaksoft.peaksoft.service.UserProfileService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserProfileServiceImpl implements UserProfileService {
private final UserProfileDaoImpl userProfileDao = new UserProfileDaoImpl();
    @Override
    public String saveUserP(UserProfile userP) {
        return  userProfileDao.saveUserP(userP);
    }

    @Override
    public Optional<UserProfile> getUserPById(Long id) {
        return userProfileDao.getUserPById(id);
    }

    @Override
    public String updateUserP(Long userPId, UserProfile newUserP) {
        return userProfileDao.updateUserP(userPId,newUserP);
    }

    @Override
    public boolean deleteUserPById(Long id) {

        return false;
    }

    @Override
    public boolean getUserPByEmail(String email) {
userProfileDao.getUserPByEmail(email);
        return false;
    }

    @Override
    public List<UserProfile> GetUserRegisteredAfterDate(LocalDate date) {
        return userProfileDao.GetUserRegisteredAfterDate(date);
    }
}
