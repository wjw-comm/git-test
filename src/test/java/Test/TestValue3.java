package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestValue3 {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setvalue(){  /*右压栈   存值*/
        redisTemplate.boundListOps("namelist").rightPush("张三");
        redisTemplate.boundListOps("namelist").rightPush("李四");
        redisTemplate.boundListOps("namelist").rightPush("王五");
    }

    @Test
    public void getvalue(){  /*右压栈   取值*/
        List namelist = redisTemplate.boundListOps("namelist").range(0, 10);
        System.out.println(namelist);
    }

    @Test
    public void getvalue1(){  /*根据索引查元素*/
        String name = (String) redisTemplate.boundListOps("namelist").index(0);
        System.out.println(name);
    }

    @Test
    public void remove(){  /*移除集合某个元素*/
        Long remove = redisTemplate.boundListOps("namelist").remove(1, "张三");
        System.out.println(remove);
    }

    @Test
    public void delvalue(){  /*删除list集合的值*/
        redisTemplate.delete("namelist");
    }

}
