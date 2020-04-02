package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestValue2 {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void SetValue(){  /*set集合存值*/
        redisTemplate.boundSetOps("nameset").add("张三");
        redisTemplate.boundSetOps("nameset").add("李四");
        redisTemplate.boundSetOps("nameset").add("王五");
    }

    @Test
    public void getvalue(){  /*set集合取值*/
        Set nameset = redisTemplate.boundSetOps("nameset").members();
        System.out.println(nameset);
    }

    @Test
    public void remove(){  /*删除集合中的某个值*/
        redisTemplate.boundSetOps("nameset").remove("王五");
    }

    @Test
    public void delvalue(){  /*删除集合中的所有值*/
        redisTemplate.delete("nameset");
    }
}
