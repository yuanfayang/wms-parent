package com.deer.wms.workflow.flowable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * CustomFlowableProperties
 *
 * @author luxin.yan
 * @date 2019/1/24
 **/
@Configuration
@PropertySource(value="classpath:flowable.properties",encoding="UTF-8")
@ConfigurationProperties(prefix = "flowable")
public class CustomFlowableProperties {
    private String activityFontName;
    private String labelFontName;
    private String annotationFontName;
    private String highlightColor;
    private String highlightConnectionColor;

    public String getActivityFontName() {
        return activityFontName;
    }

    public void setActivityFontName(String activityFontName) {
        this.activityFontName = activityFontName;
    }

    public String getLabelFontName() {
        return labelFontName;
    }

    public void setLabelFontName(String labelFontName) {
        this.labelFontName = labelFontName;
    }

    public String getAnnotationFontName() {
        return annotationFontName;
    }

    public void setAnnotationFontName(String annotationFontName) {
        this.annotationFontName = annotationFontName;
    }

    public String getHighlightColor() {
        return highlightColor;
    }

    public void setHighlightColor(String highlightColor) {
        this.highlightColor = highlightColor;
    }

    public String getHighlightConnectionColor() {
        return highlightConnectionColor;
    }

    public void setHighlightConnectionColor(String highlightConnectionColor) {
        this.highlightConnectionColor = highlightConnectionColor;
    }
}
