package com.example.ekachart.eyeproject;

import android.content.Context;

/**
 * Created by wachirapong on 8/17/15 AD.
 */
public class BodseeData {
    private int[] ans = new int[]{0,2,29, 8, 16, 7, 74, 45, 15, 9, 97, 5, 3, 73};
    private int numberQuestion = 1;

    public String getAnsOfQuestion(int numberQuestion){
        return  ans[numberQuestion]+"";
    }

    public static int getResourceByFilename(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "drawable", context.getPackageName());
    }

    public int nextPicQuestion(Context context){
        nextQuestion();
        return getResourceByFilename(context, "bodsee_image" + numberQuestion);
    }

    public int getNumberQuestion(){
        return numberQuestion;
    }

    private void nextQuestion(){
        numberQuestion++;
    }

    public int getCurrentPicQuestion(Context context){
        return getResourceByFilename(context, "bodsee_image" + numberQuestion);
    }

}//end class
