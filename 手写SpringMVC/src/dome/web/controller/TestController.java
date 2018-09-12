package dome.web.controller;

import com.springformwork.annotation.Autowired;
import com.springformwork.annotation.Controller;
import com.springformwork.annotation.RequestMapping;
import com.springformwork.annotation.RequestParam;
import com.springformwork.pojo.Data;
import com.springformwork.pojo.RequestMethod;
import dome.web.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/29
 * Time: 上午 11:55
 * explain:
 */
@Controller
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public Data test(@RequestParam String name, @RequestParam int age, HttpServletRequest req, HttpServletResponse resp) {
        Data date = new Data( testService.getName(name) );

        return date;
    }
}
