package dk.lundudvikling.springdemo.featuretoggle.interfaces;


import org.springframework.context.annotation.Profile;

public interface FeatureFlagService {

    String getFeatureFlagString();
}
