package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestValue4 {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setvalue(){  /*hash存值*/
        redisTemplate.boundHashOps("namehash").put("a","唐僧");
        redisTemplate.boundHashOps("namehash").put("b","悟空");
        redisTemplate.boundHashOps("namehash").put("c","悟能");
        redisTemplate.boundHashOps("namehash").put("d","悟净");
        redisTemplate.boundHashOps("namehash").put("e","白龙马");
    }

    @Test
    public void getkeys(){/*获取所有的key值*/
        Set namehash = redisTemplate.boundHashOps("namehash").keys();
        for (Object name : namehash) {
            System.out.println(name);
        }
        System.out.println(namehash);
    }

    @Test
    public void getvalues(){  /*获取所有的value值*/
        List namehash = redisTemplate.boundHashOps("namehash").values();
        System.out.println(namehash);
    }

    @Test
    public void remove(){  /*根据指定的key移除值*/
        Long aLong = redisTemplate.boundHashOps("namehash").delete("b");
        System.out.println(aLong);
    }

    @Test
    public void GetValueByKey(){  /*根据指定的key获取值*/
        String str = (String) redisTemplate.boundHashOps("namehash").get("a");
        System.out.println(str);

    }
}
