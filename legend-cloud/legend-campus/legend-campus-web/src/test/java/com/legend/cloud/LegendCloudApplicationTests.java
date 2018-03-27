package com.legend.cloud;

import com.legend.cloud.LegendCloudApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LegendCloudApplication.class)
@WebAppConfiguration
@Transactional
@Rollback
public class LegendCloudApplicationTests {

	@Test
	public void contextLoads() {
	}

}