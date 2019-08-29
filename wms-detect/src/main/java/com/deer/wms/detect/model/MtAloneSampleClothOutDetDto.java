package com.deer.wms.detect.model;

public class MtAloneSampleClothOutDetDto extends MtAloneSampleClothOutDet{

    private  String sampleClothName;
    private String locationName;
    private String wareName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getSampleClothName() {
        return sampleClothName;
    }

    public void setSampleClothName(String sampleClothName) {
        this.sampleClothName = sampleClothName;
    }
}
