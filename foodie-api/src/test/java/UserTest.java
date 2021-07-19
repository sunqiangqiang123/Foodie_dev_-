import com.sun.Application;
import com.sun.mapper.MyMapper;
import com.sun.mapper.TestUserMapper;
import com.sun.pojo.model.TestUser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Autowired
    private TestUserMapper mapper;

    @Test
    public void save1(){
        TestUser t1 = new TestUser();
        t1.setUserid("1");
        t1.setUsername("安娜");
        t1.setAge("16");

        TestUser t2 =  new TestUser();
        t2.setUserid("2");
        t2.setUsername("安妮");
        t2.setAge("15");

        mapper.insert(t1);


    }
}
