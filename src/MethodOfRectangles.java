public class MethodOfRectangles {

    void function1(double topLimit, double bottomLimit, double accuracy){
        Function1 function1 = new Function1(topLimit, bottomLimit, accuracy);
        function1.leftRectangles();
        function1.rightRectangles();
        function1.middleRectangles();
    }
    void function2(double topLimit, double bottomLimit, double accuracy){
        Function2 function2 = new Function2(topLimit, bottomLimit, accuracy);
        function2.leftRectangles();
        function2.rightRectangles();
        function2.middleRectangles();
    }
    void function3(double topLimit, double bottomLimit, double accuracy){

    }

}
