package commun;

public class MathOperations {

    public static Integer floor(Integer a, int b){
        return Integer.valueOf((int) Math.floor((double) a.intValue()/(double) b));
    }

    public static Integer ceil(Integer a, int b){
        return Integer.valueOf((int) Math.ceil((double) a.intValue()/(double) b));
    }

    public static Integer min(Integer a, int b){
        return Integer.valueOf(Math.min(a.intValue(), b));
    }

    public static  Integer max(Integer a, int b){
        return Integer.valueOf(Math.max(a.intValue(), b));
    }

}
