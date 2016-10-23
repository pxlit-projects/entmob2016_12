package be.regendans;

import be.regendans.entities.User;
import be.regendans.repositories.UserRepository;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.DataOutputStream;
import java.net.URL;

/**
 * @author Bunyamin
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ScenarioTest {

    @Autowired
    private HttpURLConnection httpURLConnection;
    @Autowired
    private User u;
    @Autowired
    private UserRepository ur;

    @Test
    public void createUserTest() throws Exception{

        JSONObject json = new JSONObject();
        json.put("username", "frank");
        json.put("password", "eenheelgoedepassword");

        try {
            URL url = new URL("http://localhost:8080/user/new");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("content-type", "application/json");
            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
            dos.writeBytes(json.toString());
            dos.flush();
            dos.close();

        } catch (Exception e) {
            System.out.println("Something went wrong, check console for details.");
            e.printStackTrace();
        }

        u = ur.findOne(2);
        System.out.println(u.toString());
        // assertThat wilt niet werken
    }

}
