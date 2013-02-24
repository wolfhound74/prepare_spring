package contactmanager.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;
import ru.maslov.contactmanager.domain.User;
import ru.maslov.contactmanager.service.UserService;
import ru.maslov.contactmanager.web.UserController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContactControllerTest extends AbstractControllerTest {

    private UserService userService;
    private final List<User> userList = new ArrayList<User>();

    @Before
    public void init() {
        User user = new User("Владимир", "Маслов");
        userList.add(user);
    }

    @Test
    public void test_list() {
        userService = mock(UserService.class);

        when(userService.list()).thenReturn(userList);

        UserController controller = new UserController();
        ReflectionTestUtils.setField(controller, "contactService", userService);

        ModelAndView result = controller.list();
        assertEquals("list", result.getViewName());
        assertEquals(userList, result.getModel().get("userList"));
    }
}
