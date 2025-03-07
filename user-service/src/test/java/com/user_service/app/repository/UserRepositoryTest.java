package com.user_service.app.repository;
import com.user_service.app.data.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void testInsert(){
        User user = new User("1","John","abc","John Doe");

        userRepository.insert(user);

        Assertions.assertNotNull(user);
        Mockito.verify(userRepository,Mockito.times(1)).insert(new User(user.getId(),"John","abc","John Doe"));
    }

    @Test
    public void testFindById(){
        User user = new User("1","John","abc","John Doe");
        when(userRepository.findbyId("1")).thenReturn(user);

        userRepository.insert(user);
        User getUser=userRepository.findbyId("1");

        Assertions.assertNotNull(getUser);
        Assertions.assertEquals(user,getUser);

        Assertions.assertNotNull(getUser);
        Assertions.assertEquals("1", getUser.getId());
        Assertions.assertEquals("John", getUser.getName());


    }

}
