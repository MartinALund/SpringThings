package dk.lundudvikling.springdemo.featuretoggle.implementations;

import dk.lundudvikling.springdemo.featuretoggle.interfaces.FeatureFlagController;
import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureFlagControllerImpl implements FeatureFlagController {

    private FeatureFlagServiceImpl featureFlagService;
    private FF4j ff4j;


    public FeatureFlagControllerImpl(FeatureFlagServiceImpl featureFlagService,
                                     @Qualifier("digix") FF4j ff4j) {
        this.featureFlagService = featureFlagService;
        this.ff4j = ff4j;
    }

    @Override
    public ResponseEntity<String> getFeatureFlagString() {
        return new ResponseEntity<>(featureFlagService.getFeatureFlagString(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> disableFeatureFlag() {
        ff4j.disable("f1");
        return new ResponseEntity<>(ff4j.check("f1"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> enableFeatureFlag() {
        ff4j.enable("f1");
        return new ResponseEntity<>(ff4j.check("f1"), HttpStatus.OK);
    }
}
