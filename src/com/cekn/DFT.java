package com.cekn;

import java.util.ArrayList;
import java.util.List;

public class DFT {
    private final List<Double> samples;

    public DFT(List<Double> samples){
        this.samples = samples;
    }

    /**
     * 最低限の離散フーリエ変換
     * @return スペクトル
     */
    public List<ComplexNumber> doDFT(){
        List<ComplexNumber> spectrum = new ArrayList<>();

        int N = samples.size();
        for(int t = 0 ; t < N ; ++t){
            ComplexNumber spectrumFactor = new ComplexNumber(0,0);
            for (int x = 0 ; x < N ; ++x) {
                double theta = 2 * Math.PI * t * x / N;
                ComplexNumber c = new ComplexNumber(samples.get(x) * Math.cos(theta), samples.get(x) * Math.sin(theta));
                spectrumFactor = spectrumFactor.add(c) ;
            }
            spectrum.add(spectrumFactor);
        }
        return spectrum;
    }
}
