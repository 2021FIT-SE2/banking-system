package com.se2.bankingsystem;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BankingSystemApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    public void setInitData(InitData initData) {
        this.initData = initData;
    }

    private InitData initData;

    public BankingSystemApplication() { }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BankingSystemApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BankingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws BankingSystemException {
        initData.init();
    }
}
