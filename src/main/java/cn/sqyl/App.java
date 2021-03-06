package cn.sqyl;

import cn.sqyl.dao.userclassMapper;
import cn.sqyl.dataobject.userclass;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"cn.sqyl"})
@RestController
@MapperScan("cn.sqyl.dao")
public class App 
{
    @Autowired
    private userclassMapper mUserclassMapper;

    @RequestMapping("/")
    public String home() {
        userclass user = mUserclassMapper.selectByPrimaryKey(1);
        if(user == null) {
            return "不存在";
        } else {
            return user.getUsername();
        }
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
