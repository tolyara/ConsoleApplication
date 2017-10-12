package Package_App;

import java.io.*;

    class CountFilesThread extends Thread {

        private int amount = 0;
        private String nameOfCatalog;

        CountFilesThread(String name) {
            this.nameOfCatalog = name;
        }

        void setAmount(int amount) {
            this.amount = amount;
        }

        int getAmount() {
            return amount;
        }

        String getNameOfCatalog() {
            return nameOfCatalog;
        }

        @Override
        public void run() {

            try {
                setAmount(countNumOfFiles(getNameOfCatalog(), 0));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        // Этот рекурсивный метод возвращает количество файлов в каталоге. Каталог передается в виде строки как первый аргумент,
        // второй аргумент - это счетчик количества файлов в текущем подкаталоге, для корректной работы во время вызова ему
        // должно передаваться значение 0
        private static int countNumOfFiles(String path, int count) {

            File pathCatalog = new File(path);      // Создаем переменные типа File для работы с каталогом
            int countAll = count;
            count = 0;
            for(File item : pathCatalog.listFiles()) {
                if (item.isFile()) {
                    count++;
                    countAll++;
                }
                else {
                    countAll = countNumOfFiles(item.getAbsolutePath(), countAll);
                }
            }
            return countAll;
        }

    }

