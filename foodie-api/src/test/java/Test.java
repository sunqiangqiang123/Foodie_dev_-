import com.sun.pojo.model.TestUser;

public class Test {

    @org.junit.jupiter.api.Test
    private void test(){

        TestUser t1 = new TestUser();
        t1.setUserid("1");
        t1.setUsername("安娜");
        t1.setAge("16");

        TestUser t2 =  new TestUser();
        t2.setUserid("2");
        t2.setUsername("安妮");
        t2.setAge("15");


    }

}
