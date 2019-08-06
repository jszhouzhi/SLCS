package com.slzr.common.config;

import com.slzr.ureport.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.slzr.ureport.bean.IcTransferCountBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ReportBeanConfig {

    @Bean
    public ACountDeptBean aCountDeptBean(){
        return new ACountDeptBean();
    }
    @Bean
    public ACountLineBean aCountLineBean(){
        return new ACountLineBean();
    }
    @Bean
    public ACountDriverBean aCountDriverBean(){
        return new ACountDriverBean();
    }
    @Bean
    public ACountCarBean aCountCarBean(){
        return new ACountCarBean();
    }

    @Bean
    public IcTransferCountBean icTransferCountBean(){
        return new IcTransferCountBean();
    }


    @Bean
    public  AccountCountBean accountCountBean(){
        return  new AccountCountBean();
    }

    @Bean
    public BBusDriverBean bBusDriver(){
        return  new BBusDriverBean();

    }

    @Bean
    public BLineBusBean bLineBusBean(){
        return  new BLineBusBean();
    }

    @Bean
    public  BDeptLineBean bDeptLineBean(){
        return  new BDeptLineBean();
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){

        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        return  threadPoolTaskExecutor;
    }


}
