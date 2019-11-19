package cn.xs.sh.telcom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.xs.sh.telcom.dao")
public class TelcomV2Application {

	public static void main(String[] args) {
		SpringApplication.run(TelcomV2Application.class, args);
	}

}
