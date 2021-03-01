package co.com.nxs.automotiveInventory.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {

    private final MessageSource messageExeceptionSourceSource;

    @Autowired
    public MessageUtil(MessageSource messageExeceptionSourceSource) {
        this.messageExeceptionSourceSource = messageExeceptionSourceSource;
    }

    public String resolveMessageSource(String code) {
        return messageExeceptionSourceSource.getMessage(code, null, Locale.getDefault());
    }


}
