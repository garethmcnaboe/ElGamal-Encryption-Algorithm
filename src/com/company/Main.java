package com.company;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take in and then split up the 1st input.
        String str1 = sc.nextLine();
        int a=0;
        int b =0;
        boolean first = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == ' ' & (!first)) {
                a = i;
                first = true;
            }
            if (str1.charAt(i) == ' ' & (first)) {
                b = i;
            }
        }
        BigInteger modulusBI = new BigInteger(str1.substring(0, a));
        int modulusI = Integer.parseInt(str1.substring(0,a));
        BigInteger generatorBI = new BigInteger(str1.substring((a+1), b));
        //int generatorI = Integer.parseInt(str1.substring((a+1), b));
        BigInteger a3BI = new BigInteger(str1.substring((b+1)));
        //int a3I = Integer.parseInt(str1.substring((b+1)));

        //Take in and then split up the 2nd input.
        String str2 = sc.nextLine();
        String str3 = "";
        String str4 = "";

        for(int i = 0; i<str2.length(); i++){
            if(str2.charAt(i)== ' '){
                str3 = str2.substring(0,i);
                str4 = str2.substring(i+1);
            }
        }


        BigInteger c1BI = new BigInteger(str3);
        int c1I = Integer.parseInt(str3);
        BigInteger c2BI = new BigInteger(str4);
        int c2I = Integer.parseInt(str4);

        int x = 0;
        BigInteger target = new BigInteger("0");
        while(x<=modulusI) {
            BigInteger temp = new BigInteger(Integer.toString(x));
            target = generatorBI.modPow(temp, modulusBI);

            if(target.equals(a3BI)){
                break;
            }
            x++;
        }

        //System.out.println("X value: " + x);
        int temp1 = modulusI - 1 - x;
        //System.out.println("Three part number:"+temp1);
        BigInteger temp2 = new BigInteger(String.valueOf(temp1));
        //System.out.println("Three part number as big int:"+temp2);

        BigInteger temp3 = new BigInteger("0");
        temp3 = c1BI.modPow(temp2,modulusBI);
        //System.out.println("first pass: " + temp3);

        BigInteger temp4 = new BigInteger("0");
        temp4 = temp3.multiply(c2BI);
        //System.out.println("after multipication: "+temp4);

        BigInteger temp5 = new BigInteger("0");
        temp5 = temp4.mod(modulusBI);

        //System.out.println("Final Answer:" + temp5);
        System.out.println(temp5);
    }
}
