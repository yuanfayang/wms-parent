package com.deer.wms.detect.model;

import java.util.ArrayList;
import java.util.List;

public class MtAloneSampleClothOutDetVO extends MtAloneSampleClothOutDto{

    private List<MtAloneSampleClothOutDetDto> mtAloneSampleClothOutDetList =new ArrayList<MtAloneSampleClothOutDetDto>();

    public List<MtAloneSampleClothOutDetDto> getMtAloneSampleClothOutDetList() {
        return mtAloneSampleClothOutDetList;
    }

    public void setMtAloneSampleClothOutDetList(List<MtAloneSampleClothOutDetDto> mtAloneSampleClothOutDetList) {
        this.mtAloneSampleClothOutDetList = mtAloneSampleClothOutDetList;
    }
}
