package dk.lundudvikling.springdemo.internalization;

import dk.lundudvikling.springdemo.aspects.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("internalization")
public class InternalizationController {

    private MessageTranslator messageTranslator;

    @Autowired
    public InternalizationController(MessageTranslator messageTranslator) {
        this.messageTranslator = messageTranslator;
    }

    @GetMapping("{languageCode}/{text}")

    @Loggable
    public ResponseEntity<String> getInternalizedText(@PathVariable String languageCode, @PathVariable String text){
        return new ResponseEntity<>(messageTranslator.getInternalizedString(text, languageCode), HttpStatus.OK);
    }
}
