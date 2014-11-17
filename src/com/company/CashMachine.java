package com.company;



import java.util.Arrays;

public class CashMachine {
    Integer[] cash;
    int nCoins;
    CashMachine(Integer[] coins){
        cash = coins;
        nCoins = cash.length;
        Arrays.sort(cash);
    }

    private void changeRec(int sum, int i, String outStr){
        i--;
        if ((sum==0)|(i==0)){
            if ((i==0)&(sum!=0)){
                outStr = outStr + Integer.toString(sum/cash[0])+"x" +Integer.toString(cash[0]);

            }
            System.out.println(outStr);
        }
        else{
            int numI = sum/cash[i];
            for (int j=numI; j>=0; j--){
                int newSum = sum - cash[i]*j;
                String newOutStr=outStr;
                if (j!=0){
                    newOutStr = outStr + Integer.toString(j)+"x" +Integer.toString(cash[i])+" ";
                }

                changeRec(newSum, i, newOutStr);

            }

        }
    }

    public void change(int sum){
        changeRec(sum, nCoins, "");
    }

}
