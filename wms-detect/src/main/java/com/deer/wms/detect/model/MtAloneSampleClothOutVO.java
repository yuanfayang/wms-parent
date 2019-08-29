package com.deer.wms.detect.model;

import java.util.List;

public class MtAloneSampleClothOutVO {

    private MtAloneSampleClothOut mtAloneSampleClothOut;
    private List<MtAloneSampleClothOutDet> mtAloneSampleClothOutDetList;

    public MtAloneSampleClothOut getMtAloneSampleClothOut() {
        return mtAloneSampleClothOut;
    }

    public void setMtAloneSampleClothOut(MtAloneSampleClothOut mtAloneSampleClothOut) {
        this.mtAloneSampleClothOut = mtAloneSampleClothOut;
    }

    public List<MtAloneSampleClothOutDet> getMtAloneSampleClothOutDetList() {
        return mtAloneSampleClothOutDetList;
    }

    public void setMtAloneSampleClothOutDetList(List<MtAloneSampleClothOutDet> mtAloneSampleClothOutDetList) {
        this.mtAloneSampleClothOutDetList = mtAloneSampleClothOutDetList;
    }
}
