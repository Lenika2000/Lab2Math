import java.util.function.BiFunction;

public class Function {
    private double topLimit;
    private double bottomLimit;
    private double accuracy;
    private  int n = 4;
    private double h;
    private BiFunction<Double,Double,Double> function;
    private String funS;

    public Function(double topLimit, double bottomLimit, double accuracy, BiFunction<Double,Double,Double> fun, String funS) {
        this.topLimit = topLimit;
        this.bottomLimit = bottomLimit;
        this.accuracy = accuracy;
        this.function = fun;
        this.funS = funS;
    }

    void leftRectangles(){
        h = (topLimit - bottomLimit)/n;
        double I0 = 0;
        double I1=0;
        for (double i=bottomLimit; i<topLimit; i+=h){
            I0 = I0 + function.apply(h, i);
        }
        n *= 2;
        h = (topLimit - bottomLimit)/n;
        for (double i=bottomLimit; i<topLimit; i+=h){
            I1 = I1 + function.apply(h, i);
        }
        while (Math.abs(I1-I0)>=accuracy) {
            I0 = I1;
            I1=0;
            n *= 2;
            h = (topLimit - bottomLimit)/n;
            for (double i=bottomLimit; i<topLimit; i+=h){
                I1 = I1 + function.apply(h, i);
            }
        }

        System.out.printf("Функция %s, метод левых прямоугольников\n"
                + "Верхний предел %f, нижний предел %f, точность %f \n"
                + "Значение интеграла: %f \n"
                +"Число разбиения интервала для получения требуемой точности %d\n", funS, topLimit, bottomLimit,accuracy,I1,n);

    }
    void rightRectangles(){
        n = 4;
        h = (topLimit - bottomLimit)/n;
        double I0 = 0;
        double I1=0;
        for (double i=bottomLimit+h; i<=topLimit; i+=h){
            I0 = I0 +  function.apply(h, i);
        }
        n *= 2;
        h = (topLimit - bottomLimit)/n;
        for (double i=bottomLimit+h; i<=topLimit; i+=h){
            I1 = I1 +  function.apply(h, i);
        }
        while (Math.abs(I1-I0)>=accuracy) {
            I0 = I1;
            I1=0;
            n *= 2;
            h = (topLimit - bottomLimit)/n;
            for (double i=bottomLimit+h; i<=topLimit; i+=h){
                I1 = I1 +  function.apply(h, i);
            }

        }
        System.out.printf("Функция %s, метод правых прямоугольников\n"
                + "Значение интеграла: %f \n"
                +"Число разбиения интервала для получения требуемой точности %d\n", funS, I1,n);
    }
    void middleRectangles(){
        n = 4;
        h = (topLimit - bottomLimit)/n;
        double I0 = 0;
        double I1=0;
        for (double i=bottomLimit+h/2; i<=topLimit-h/2; i+=h){
            I0 = I0 + function.apply(h, i);
        }
        n *= 2;
        h = (topLimit - bottomLimit)/n;
        for (double i=bottomLimit+h/2; i<=topLimit-h/2; i+=h){
            I1 = I1 + function.apply(h, i);
        }
        while (Math.abs(I1-I0)>=accuracy) {
            I0 = I1;
            I1=0;
            n *= 2;
            h = (topLimit - bottomLimit)/n;
            for (double i=bottomLimit+h/2; i<=topLimit-h/2; i+=h){
                I1 = I1 + function.apply(h, i);
            }

        }
        System.out.printf("Функция %s, метод средних прямоугольников\n"
                + "Значение интеграла: %f \n"
                +"Число разбиения интервала для получения требуемой точности %d",funS, I1,n);
    }

    void calculateAllMethods() {
        leftRectangles();
        rightRectangles();
        middleRectangles();
    }
}
