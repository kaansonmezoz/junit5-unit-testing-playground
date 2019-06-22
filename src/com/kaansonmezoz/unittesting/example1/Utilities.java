package com.kaansonmezoz.unittesting.example1;

public class Utilities {
    public char[] everyNthChar(char[] sourceArray, int n){
        if(sourceArray == null || sourceArray.length < n){
            return sourceArray;
        }

        int arraySize = sourceArray.length / n;
        char[] nthChars = new char[arraySize];

        for(int i = n-1; i/n < arraySize; i += n){
            nthChars[i/n] = sourceArray[i];
        }

        return nthChars;
    }

    public String removePairs(String source){
        if(source == null || source.length() < 2){
            return source;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] sourceChars = source.toCharArray();

        for(int i = 0; i < sourceChars.length - 1; i++){
            if(sourceChars[i] != sourceChars[i+1]){
                stringBuilder.append(sourceChars[i]);
            }
        }

        stringBuilder.append(sourceChars[sourceChars.length-1]);

        return stringBuilder.toString();
    }


    public int converter(int a, int b){
        return (a / b) + (a * 30) - 2;
    }

    public String returnsNullIfSizeIsOdd(String source){
        String[] returnValues = new String[2];
        returnValues[0] = source;
        returnValues[1] = null;

        return returnValues[source.length() % 2];
    }
}
