import java.io.*;


public class DataReceiver {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    MethodOfRectangles methodOfRectangles = new MethodOfRectangles();

    void selectFunction() {

        while (true) {
            System.out.println("Выберете одну из функций, для которой будет вычислен интеграл методом Прямоугольников\nИ введите ее номер.\n"
                    + "1) 8+2x-x^2  \n"
                    + "2) (2x)^(1/3)+x^(1/3) \n"
                    + "3) (x^2+x+1)^(1/3)");
            try {
                String integrals = in.readLine();
                double[] parameters;
                switch (integrals) {
                    case "1":
                        parameters = getLimitOfIntegrationAndAccuracy();
                        methodOfRectangles.function1(parameters[0], parameters[1], parameters[2]);
                        return;
                    case "2":
                        parameters = getLimitOfIntegrationAndAccuracy();
                        methodOfRectangles.function2(parameters[0], parameters[1], parameters[2]);
                        return;
                    case "3":
                        parameters = getLimitOfIntegrationAndAccuracy();
                        methodOfRectangles.function3(parameters[0], parameters[1], parameters[2]);
                        return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Неверный ввод!");
            }
        }

    }


    double[] getLimitOfIntegrationAndAccuracy() {
        double[] parameters = new double[3];
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("Введите пределы интегрирования. Верхний: ");
                parameters[0] = Double.parseDouble(in.readLine());
                System.out.println("Нижний:");
                parameters[1] = Double.parseDouble(in.readLine());
                System.out.println("Введите требуемую точность:");
                parameters[2] = Double.parseDouble(in.readLine());
                exit = true;
                if (parameters[0] < parameters[1]) {
                    System.out.println("Верхний предел меньше нижнего. Пожалуйста, повторите ввод");
                    exit = false;
                }
            } catch (Exception e) {
                System.out.println("При вводе данных обнаружена ошибка. Попробуйте еще раз.");
                exit = false;
            }
        }
        return parameters;
    }
}
