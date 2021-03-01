package co.com.nxs.automotiveInventory.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageExeceptionSourceSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/validation/message_es_CO");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;

    }

}
