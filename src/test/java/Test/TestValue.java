package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")

public class TestValue {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void SetValue(){ /*存值*/
        redisTemplate.boundValueOps("name").set("天云软件股份有限公司");
    }

    @Test
    public void GetValue(){    /*取值*/
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    @Test
    public void DelValue(){   /*删除值*/
        redisTemplate.delete("name");
    }
}
