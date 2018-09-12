package dome.web.service.impl;

import com.springformwork.annotation.Service;
import dome.web.service.TestService;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/29
 * Time: 上午 11:57
 * explain:
 */
@Service
public class TestImpl implements TestService {

    @Override
    public String getName(String name) {
        return "my Name is " + name;
    }
}
