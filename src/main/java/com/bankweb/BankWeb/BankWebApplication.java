package com.bankweb.BankWeb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankWebApplication {
static final Logger logger = LogManager.getLogger(BankWebApplication.class.getName());
	public static void main(String[] args) {
            logger.info("Entered application ");
		SpringApplication.run(BankWebApplication.class, args);
	}
}
