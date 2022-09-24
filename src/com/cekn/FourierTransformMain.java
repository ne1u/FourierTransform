package com.cekn;

import java.util.ArrayList;
import java.util.List;

public class FourierTransformMain {
    public static void main(String[] args) {
         //テスト用の合成波を生成
         List samples = generateWave(512);

         //DFT実行
         DFT dft = new DFT(samples);
         List<ComplexNumber> spectrum = dft.doDFT();

         //スペクトルを標準出力
         spectrum.forEach( spectrumFactor ->
                 System.out.println(Math.sqrt(Math.pow(spectrumFactor.real, 2) + Math.pow(spectrumFactor.imaginary, 2)))
         );
    }

    /**
     * 合成波を作る
     * @param n サンプリング数
     * @return 波形サンプル
     */
    static List<Double> generateWave(double n){
        List<Double> X = new ArrayList();
        for (double t = 0; t < n ; t += 0.5){
            X.add(Math.sin(t * Math.toRadians(80)) + Math.sin(t * Math.toRadians(40)) + Math.sin(t * Math.toRadians(20)));
        }
        return X;
    }
}


