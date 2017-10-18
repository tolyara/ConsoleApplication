# ConsoleApplication

В данном проекте произведена попытка реализации следующего задания (получено на одном из собеседований):
------------------------------------------------------------------------------------------------------------------------------------------
Программа выполняет подсчет количества файлов в папке и всех ее подпапках. 

Папки, в которых необходимо выполнять поиск, должны содержаться в файле, путь к которому пользователь вводит первой строкой консольного приложения.

Запуск работы по подсчету происходит одновременно по каждой папке из файла входных данных, и результаты фиксируются сразу по каждому из путей.

Результаты записываются после окончания поиска по своей папке в файл, который пользователь ввел второй строкой, и на экран.

Во входном файле содержится одна или больше строк-путей. Каждая из строк – это папка, которая требует подсчета в ней файлов.

Выходной файл представлен в формате CSV с разделителем точка с запятой (;). Первая колонка – это исходный путь из входного файла, вторая – количество файлов в папке.

Вывод на экран должен представлен в табличном виде. Первая колонка – это порядковый номер записи, вторая колонка – количество найденных файлов, третья – исходный путь для поиска.

Пользователь должен иметь возможность отменить запущенные поиски нажатием клавиши Esc. Для этого был добавлен отдельный класс с реализацией GUI.
------------------------------------------------------------------------------------------------------------------------------------------
В целом приложение получилось довольно кривое, на данный момент это все, что мог выдать мой внутренний программер) В частности, в самых критичных замечаниях отмечено слабое применение ООП, непонимание принципов синхронизации (подсчет должен выполняться одновременно). 
