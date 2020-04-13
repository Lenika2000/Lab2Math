import java.util.function.BiFunction;

public class Function {
    private double topLimit;
    private double bottomLimit;
    private double accuracy;
    private BiFunction<Double, Double, Double> function;
    private String funS;

    public Function(double topLimit, double bottomLimit, double accuracy, BiFunction<Double, Double, Double> fun, String funS) {
        this.topLimit = topLimit;
        this.bottomLimit = bottomLimit;
        this.accuracy = accuracy;
        this.function = fun;
        this.funS = funS;
    }

    void leftRectangles() {
        int n = 4;//начальное разбиение
        final double bigStep = topLimit - bottomLimit;//длинна отрезка интегрирования
        double I0 = 0;
        double h = bigStep / n;

        for (double i = bottomLimit; i < topLimit; i += h) {
            I0 = I0 + function.apply(h, i);
        }
        n *= 2;

        while (true) {
            h = bigStep / n;
            double I1 = 0;
            for (double i = bottomLimit; i < topLimit; i += h) {
                I1 = I1 + function.apply(h, i);
            }

            if (Math.abs(I1 - I0) < accuracy) {
                I0 = I1;
                break;
            } else {
                I0 = I1;
                n *= 2;
            }
        }

        System.out.printf("Функция %s, метод левых прямоугольников\n" +
                        "Верхний предел %f, нижний предел %f, точность %f \n" +
                        "Значение интеграла: %f \n" +
                        "Число разбиения интервала для получения требуемой точности %d\n",
                funS, topLimit, bottomLimit, accuracy, I0, n);

    }

    void rightRectangles() {
        int n = 4;
        final double bigStep = topLimit - bottomLimit;
        double I0 = 0;
        double h = bigStep / n;

        for (double i = bottomLimit+h; i <= topLimit; i += h) {
            I0 = I0 + function.apply(h, i);
        }
        n *= 2;

        while (true) {
            h = bigStep / n;
            double I1 = 0;
            for (double i = bottomLimit + h; i <= topLimit; i += h) {
                I1 = I1 + function.apply(h, i);
            }

            if (Math.abs(I1 - I0) < accuracy) {
                I0 = I1;
                break;
            } else {
                I0 = I1;
                n *= 2;
            }
        }

        System.out.printf("Функция %s, метод правых прямоугольников\n" +
                        "Значение интеграла: %f \n" +
                        "Число разбиения интервала для получения требуемой точности %d\n",
                funS, I0, n);
    }

    void middleRectangles() {
        int n = 4;
        final double bigStep = topLimit - bottomLimit;
        double I0 = 0;
        double h = bigStep / n;

        for (double i = bottomLimit + h / 2; i <= topLimit - h / 2; i += h) {
            I0 = I0 + function.apply(h, i);
        }
        n *= 2;

        while (true) {
            h = bigStep / n;
            double I1 = 0;
            for (double i = bottomLimit + h / 2; i <= topLimit - h / 2; i += h) {
                I1 = I1 + function.apply(h, i);
            }

            if (Math.abs(I1 - I0) < accuracy) {
                I0 = I1;
                break;
            } else {
                I0 = I1;
                n *= 2;
            }
        }

        System.out.printf("Функция %s, метод средних прямоугольников\n" +
                        "Значение интеграла: %f \n" +
                        "Число разбиения интервала для получения требуемой точности %d\n",
                funS, I0, n);
    }

    void calculateAllMethods() {
        leftRectangles();
        rightRectangles();
        middleRectangles();
    }
}
