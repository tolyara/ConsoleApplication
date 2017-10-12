package Package_App;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Программа выполняет подсчет количества файлов в папке и всех ее подпапках. ");
        System.out.println("Если на любом этапе выполнения Вы захотите отменить поиски, в приложении CatchEsc нажмите клавишу Esc. ");

//        SimpleConsoleApp sc = new SimpleConsoleApp();       //Вызываем конструктор по умолчанию
        SimpleReaderFromInputFile sr = new SimpleReaderFromInputFile();
        SimpleWtiterToOutputFile sw = new SimpleWtiterToOutputFile();
        SimpleJFrame sj = new SimpleJFrame();
        sj.runCatch();

        try {
            sr.inputPath();
            sw.inputPath();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода данных при определении путей входного и выходного файла!!!");
        }

        // Создаем переменные типа File для операций над входным и выходным файлами
        File i_file = new File(sr.getFilename());
        File o_file = new File(sw.getFilename());
        // Создаем переменную-список для хранения каталогов и выделяем для нее место в памяти
        List<String> listOfPaths = new ArrayList<String>();

        // Получаем список каталогов
        try {
            listOfPaths = sr.getArrayOfCatalogs(i_file);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода данных при получении списка каталогов из входного файла!!!");
        }


        CountFilesThread[] arrayOfThreads = new CountFilesThread[listOfPaths.size()];
        for (int i = 0; i < listOfPaths.size(); i++) {
            arrayOfThreads[i] = new CountFilesThread(listOfPaths.get(i));
            arrayOfThreads[i].start();
        }

        System.out.println();
        System.out.println("    № записи    Количество файлов   Исходный путь");

        // Приостаавливаем главный поток для того, чтобы успели отработать наши потоки подсчета
        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        // Создаем массив целых чисел для хранения результатов подсчета и выделяем для нее место в памяти
        int[] arrayOfAmounts = new int[listOfPaths.size()];
        for (int i = 0; i < listOfPaths.size(); i++) {
            arrayOfAmounts[i] = arrayOfThreads[i].getAmount();
            printResult(listOfPaths.get(i), arrayOfAmounts[i], i);
        }

        try {
            sw.writeResultsToFile(o_file, listOfPaths, arrayOfAmounts);
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода/вывода данных при записи результатов в выходной файл!!!");
        }

        System.exit(0);

    }

    // Этот метод выводит результат подсчета количества файлов одного отдельного каталога
    private static void printResult(String Path, int Amount, int j) {

        System.out.printf("    %5d" + "            %7d" + "         %s %n" , (j+1), Amount, Path);
    }

}

