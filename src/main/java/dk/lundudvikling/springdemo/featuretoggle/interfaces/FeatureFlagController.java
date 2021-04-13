package dk.lundudvikling.springdemo.featuretoggle.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("flag")
public interface FeatureFlagController {

    @GetMapping()
    default ResponseEntity<String> getFeatureFlagString(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("disable")
    default ResponseEntity<Boolean> disableFeatureFlag(){
        return new ResponseEntity<Boolean>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("enable")
    default ResponseEntity<Boolean> enableFeatureFlag(){
        return new ResponseEntity<Boolean>(HttpStatus.NOT_IMPLEMENTED);
    }
}
