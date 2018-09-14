package com.qacboy.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/9/14
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class testLogger {

    // private static final Logger log = LoggerFactory.getLogger(testLogger.class);

    @Test
    public void test() {
        String name = "root";
        String pwd = "123456";
        log.debug("this is the debug...");
        log.info("hello {} ,the pwd is {}", name, pwd);
        log.warn("this is the warn...");
        log.error("this is the error...");
    }
}
