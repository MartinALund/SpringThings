package dk.lundudvikling.springdemo.internalization;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageTranslator {

    public String getInternalizedString(String message, String languageCode){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource.getMessage(message, null, Locale.forLanguageTag(languageCode));
    }
}
