package Package_App;

import java.io.*;
import java.util.*;

// Данный абстрактный класс описывает работу по взаимодействию с входными и выходными файлами
abstract class SimpleConsoleApp {

    protected String Filename;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // Геттеры
    String getFilename()  {
        return Filename;
    };
    // Сеттеры
    void setFilename(String Filename)  {
        this.Filename = Filename;
    };
    // Этот метод считывает данные от пользователя для определения пути к файлам
    abstract void inputPath() throws IOException;

}

// Данный класс реализует работу по взаимодействию с входным файлом
    class SimpleReaderFromInputFile extends SimpleConsoleApp {
        //Конструктор по умолчанию задает путь входного файла как D:\paths.txt
        SimpleReaderFromInputFile() {
            this.Filename = "D:\\paths.txt";
        }

        void inputPath() throws IOException {

            System.out.print("Введите полный путь файла, в котором находятся данные для обработки (если этот путь \"D:\\paths.txt\", то нажмите клавишу d) > ");
            String str = reader.readLine();
            if (!str.equals("d"))
                this.setFilename(str);
        }
    // Этот метод возвращает список ArrayList каталогов, находяшихся во входном файле
        List<String> getArrayOfCatalogs(File inputFile) throws IOException {

            List<String> list = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            return list;
        }

    }

// Данный класс реализует работу по взаимодействию с выходным файлом
    class SimpleWtiterToOutputFile extends SimpleConsoleApp {
        //Конструктор по умолчанию задает путь выходного файла как D:\results.txt
        public SimpleWtiterToOutputFile() {
            this.Filename = "D:\\results.txt";
        }

        void inputPath() throws IOException {

            System.out.print("Введите полный путь файла, в который будут записаны результаты (если этот путь \"D:\\results.txt\", то нажмите клавишу d) > ");
            String str = reader.readLine();
            if (!str.equals("d"))
                this.setFilename(str);
        }
    // Этот иетод записывает результаты подсчета в выходной файл в формате CSV с разделителем точка с запятой (;)
        void writeResultsToFile(File outputFile, List<String> listOfPaths, int[] arrayOfAmounts) throws IOException {

            FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
            for (int i = 0; i < listOfPaths.size(); i++) {
                fw.write(listOfPaths.get(i) + ", " + arrayOfAmounts[i] + "; ");
            }
            fw.close();
        }

    }
