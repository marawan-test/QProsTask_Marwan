package utilities;

public class Helper {

    public static boolean compareText(String fullText,String subText){

        boolean flag = false;

        if(fullText.contains(subText)){
            flag =  true;
        }

        return flag;
    }

    public static void main(String[] args) {
        String fullText = "5.4 USD/month";
        String subText = "5.4";
        System.out.println(compareText(fullText,subText))  ;
    }
}
