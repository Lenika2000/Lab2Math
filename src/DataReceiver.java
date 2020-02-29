import java.io.*;


public class DataReceiver {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    MethodOfRectangles methodOfRectangles = new MethodOfRectangles();

    void selectFunction() {
        boolean success = false;
        double [] parameters;
        double toplimit = 0;
        double bottomLimit = 0;
        double accuracy = 0;
        while (!success) {
            System.out.println("Выберете одну из функций, для которой будет вычислен интеграл методом Прямоугольников\nИ введите ее номер.\n"
                    + "1) 8+2x-x^2  \n"
                    + "2) (2x)^(1/2)+x^(1/3) \n"
                    + "3)  ");
            try {
                switch (in.readLine()) {
                    case "1":
                        success = true;
                        parameters = getLimitOfIntegrationAndAccuracy();
                        toplimit = parameters[0];
                        bottomLimit = parameters [1];
                        accuracy = parameters [2];
                        methodOfRectangles.function1(toplimit,bottomLimit,accuracy);
                        break;
                    case "2":
                        success = true;
                        parameters = getLimitOfIntegrationAndAccuracy();
                        toplimit = parameters[0];
                        bottomLimit = parameters [1];
                        accuracy = parameters [2];
                        methodOfRectangles.function2(toplimit,bottomLimit,accuracy);
                        break;
                    case "3":
                        success = true;
                        parameters = getLimitOfIntegrationAndAccuracy();
                        toplimit = parameters[0];
                        bottomLimit = parameters [1];
                        accuracy = parameters [2];
                        methodOfRectangles.function3(toplimit,bottomLimit,accuracy);
                        break;
                    default:
                        success = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Неверный ввод!");
                System.exit(0);
            }
        }

    }




    double[] getLimitOfIntegrationAndAccuracy() throws IOException {

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
