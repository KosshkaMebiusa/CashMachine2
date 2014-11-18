package com.company;



import java.util.ArrayList;
import java.util.Arrays;

public class CashMachine {
    Integer[] cash;
    int nCoins;
    boolean flag;
    ArrayList<String> res;
    CashMachine(Integer[] coins) throws Exception{
        for (int i=0; i<coins.length; i++){
            if (coins[i]<=0){
                throw new Exception("WrongValue");
            }
        }
        cash = coins;
        nCoins = cash.length;
        Arrays.sort(cash);
        flag =false;
        res = new ArrayList<String>();
    }

    private void changeRec(int sum, int i, String outStr){
        i--;
        if ((sum==0)|(i==0)){
            if ((i==0)&(sum!=0)){
                if ((i==0)&(sum%cash[i]!=0)){
                    outStr = "";

                }
                else {
                    outStr = outStr + Integer.toString(sum / cash[0]) + "x" + Integer.toString(cash[0]);
                }
            }

            if (!outStr.equals("")){flag = true; res.add(outStr);}
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

    public ArrayList<String> change(int sum){
        changeRec(sum, nCoins, "");
        if (!flag){res.add("Can't change!");}
        return (res);
    }

}
