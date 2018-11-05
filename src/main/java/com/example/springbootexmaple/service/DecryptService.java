package com.example.springbootexmaple.service;

import com.example.springbootexmaple.Gost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecryptService {
    private Gost gost;

    @Autowired
    public DecryptService(){
        gost=new Gost();
    }

    public String doDecrypt(String info, String key){

        String[] blockInfo= gost.getBlockInfoBin(info);

        String[][] blocksLR=new String[blockInfo.length][2];
        for (int i=0;i<blocksLR.length;i++){
            blocksLR[i]= gost.getLeftRightFromBlock(blockInfo[i]);
        }

        int[][] subKeys;

        int[] keyBin=new int[key.length()-1];
        for (int i=0;i<keyBin.length;i++){
            keyBin[i]=Integer.parseInt(key.charAt(i)+"");
        }

        subKeys= gost.getSubKeyFirst(keyBin);

        String[][] encryptedNumbersLR=new String[blocksLR.length][2];
        for (int i=0;i<encryptedNumbersLR.length;i++) {
            //System.out.println("blocksLR"+ blocksLR[i][1]);
            encryptedNumbersLR[i]= gost.doEncrypt(blocksLR[i], subKeys, true,false);
        }

        String[] decBinStr=new String[encryptedNumbersLR.length];
        for (int i=0;i<encryptedNumbersLR.length;i++) {
            decBinStr[i]= gost.asBitString(encryptedNumbersLR[i][0],16* gost.getBlockSize()/2)+ gost.asBitString(encryptedNumbersLR[i][1],16* gost.getBlockSize()/2);
        }

        String[] decString =new String[decBinStr.length];
        String decText="";
        for (int i = 0; i< decString.length; i++) {
            decString[i]= gost.getStringFromBinary(decBinStr[i]);
            decText+= decString[i];
        }
        return decText;
    }

}
