package dk.lundudvikling.springdemo.featuretoggle.implementations;

import dk.lundudvikling.springdemo.featuretoggle.interfaces.FeatureFlagService;
import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class FeatureFlagServiceImpl implements FeatureFlagService {

    private FF4j ff4j;

    public FeatureFlagServiceImpl(@Qualifier("digix") FF4j ff4j) {
        this.ff4j = ff4j;
    }

    @Override
    public String getFeatureFlagString() {
            if(ff4j.check("f1")){
                return "Enabled";
            }else{
                return "Disabled";
            }
        }
    }
