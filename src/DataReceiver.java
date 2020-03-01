import java.io.*;


public class DataReceiver {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    MethodOfRectangles methodOfRectangles = new MethodOfRectangles();

    void selectFunction() {
        boolean success = false;
        double [] parameters;
        double toplimit;
        double bottomLimit ;
        double accuracy ;
        while (!success) {
            System.out.println("Выберете одну из функций, для которой будет вычислен интеграл методом Прямоугольников\nИ введите ее номер.\n"
                    + "1) 8+2x-x^2  \n"
                    + "2) (2x)^(1/2)+x^(1/3) \n"
                    + "3)  x/(1+x)^(1/2)");
            try {
                success = true;
                parameters = getLimitOfIntegrationAndAccuracy();
                toplimit = parameters[0];
                bottomLimit = parameters [1];
                accuracy = parameters [2];
                switch (in.readLine()) {
                    case "1":
                        methodOfRectangles.function1(toplimit, bottomLimit, accuracy);
                        break;
                    case "2":
                        methodOfRectangles.function2(toplimit, bottomLimit, accuracy);
                        break;
                    case "3":
                        methodOfRectangles.function3(toplimit, bottomLimit, accuracy);
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Неверный ввод!");
                System.exit(0); //FIXME Плохо так заканчивать программу
            }
        }

    }


    double[] getLimitOfIntegrationAndAccuracy() {

        double [] parameters = new double[3];

        try {

            System.out.println("Введите пределы интегрирования. Верхний: ");
            parameters[0] = Double.parseDouble(in.readLine());
            System.out.println("Нижний:");
            parameters[1] = Double.parseDouble(in.readLine());
            System.out.println("Введите требуемую точность:");
            parameters[2] = Double.parseDouble(in.readLine());

        } catch (Exception e) {
            System.out.println(" ");
        }

        return parameters;
    }

}
