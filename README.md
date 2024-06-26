## **Процедура запуска авто-тестов:**


    Открыть проект fmh-android в Android Studio.

    Запустить эмулятор c API 29

    В меню проектра выбрать каталог app

    Нажать правой кнопкой мыши на каталог app и выбрать Run "All Tests"

    Поcле завершения тестов, выгрузить каталог с эмулятора по адресу:
    device-explorer\Pixel 3a API 29\_\sdcard\googletest\test_outputfiles\build\allure-results

    Вызвать терминал и, находясь на один уровень выше каталога allure-results, ввести команду allure serve.
 