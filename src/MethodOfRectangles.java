public class MethodOfRectangles {

    void function1(double topLimit, double bottomLimit, double accuracy){
        Function function = new Function(topLimit, bottomLimit, accuracy, (Double h, Double i) ->  h*(8 + 2*i - i*i), "8+2x-x^2");
        function.calculateAllMethods();
    }
    void function2(double topLimit, double bottomLimit, double accuracy){
        Function function = new Function(topLimit, bottomLimit, accuracy, (Double h, Double i) -> h*(Math.sqrt(2*i)+Math.cbrt(i)), "(2x)^(1/2)+x^(1/3)");
        function.calculateAllMethods();
    }
    void function3(double topLimit, double bottomLimit, double accuracy){
        Function function = new Function(topLimit, bottomLimit, accuracy, (Double h, Double i) -> h*(i/Math.sqrt(i+1)), "x/(1+x)^(1/2)");
        function.calculateAllMethods();
    }

}
