package hello.service;

import hello.entity.User;
import hello.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;
    @Mock
    private UserMapper mockUserMapper;
    @InjectMocks
    private UserService userService;

    @Test
    public void testSave() {
        //调用userService
        //验证userService
        Mockito.when(mockBCryptPasswordEncoder.encode("myPassword")).thenReturn("myEncodedPassword");
        userService.save("myUser", "myPassword");
        Mockito.verify(mockUserMapper).save("myUser", "myEncodedPassword");
    }

    @Test
    public void testGetUserByUsername() {
        userService.getUserByUsername("myUsername");
        Mockito.verify(mockUserMapper).findUserByUsername("myUsername");
    }

    @Test
    public void testThrowExceptionWhenUserNotFound() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> userService.loadUserByUsername("myUser"));
    }

    @Test
    public void testReturnUserDetailsWhenUserFound() {
        Mockito.when(mockUserMapper.findUserByUsername("myUsername"))
                .thenReturn(new User(123, "myUsername", "myEncryptedPassword"));

        UserDetails userDetails = userService.loadUserByUsername("myUsername");

        Assertions.assertEquals("myUsername", userDetails.getUsername());
        Assertions.assertEquals("myEncryptedPassword", userDetails.getPassword());

    }

}