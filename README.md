# Circular buffer
_Краткое описание семестрового проекта:_
- Реализуемая структура данных - круговой буфферю.
- Структура представлена в виде линейного списка фиксированного размера.
- Полезное свойство кругового буфера заключается в том, что ему не нужно перетасовывать свои элементы
  при его потреблении. (Если бы использовался некруглый буфер, то при его потреблении необходимо было бы
  сместить все элементы.) Другими словами, круговой буфер хорошо подходит в качестве буфера FIFO (первый вход,
  первый выход). Круговая буферизация обеспечивает хорошую стратегию реализации для очереди с фиксированным
  максимальным размером. Если для очереди будет принят максимальный размер, то круговой буфер станет совершенно
  идеальной реализацией; все операции очереди имеют постоянное время.
- Возможные операции: поиск head-элемента(peak()), удаление(remove()), добавление(offer()).
- Поиск head-элемента -`O(1)`, добавление -`O(1)`, удаление -`O(1)`.

## Команда "Cappuccino"

Группа: 11-101

| Фамилия Имя         | Вклад (%) | Прозвище         |
| :---                |   ---:    |             ---: |
| Комиссаров Виталий  |     50    |  _VKonTakte_     |  
| Имамов Сирин        |     50    |  _PlovBezMyasa_  |   
  
**Девиз команды**
> В теории, теория и практика неразделимы. На практике это не так.
## Структура проекта

**Проект состоит из следующих частей:**.
- [`src`](src) - реализация структуры данных (исходный код и заголовочные файлы);
- [`benchmark`](benchmark) - контрольные тесты производительности структуры данных (операции добавления, удаления,
  поиска и пр.);
- [`dataset`](dataset) - наборы данных для запуска контрольных тестов и их генерация;
## Требования
**Рекомендуемые требования:**
1. JDK 8(минимальная версия).
2. Рекомендуемый объем оперативной памяти - не менее 8 ГБ.
3. Свободное дисковое пространство объемом ~ 1,5 ГБ (для входного набора данных).
## Сборка и запуск
1. Склонировать проект на устройство.
2. Запустить проект в классе Main с помощью метода main(нажать на зеленый треугольник около метода main).
3. Чтобы сохранить сгенерированные тестовые данные нам необходимо создать 60 файлов с расширением CSV и записать
пути до всех файлов в текстовый файл "PathsOfFiles".txt. Генерация данных произойдет автоматически при запуске
метода main.
4. Тесты выведут в консоль информацию о времени работы метадов.
### Пример (Windows):
#### Сборка проекта
Склонируйте проект к себе на устройство через [Git for Windows](https://gitforwindows.org/) (либо используйте
возможности среды разработки):
git clone https://github.com/Sirin-Im/semester-project-circular-buffer.git.
Сборка и запуск проекта осуществляются с помощью среды разработки.
#### Генерация тестовых данных
Формат данных: [comma-seperated values (CSV)](https://en.wikipedia.org/wiki/Comma-separated_values).
Инструкции по генерации:
Так как тестовые данные нашей реализации имеют определенные размеры для удобства они были помещены в массив, 
чтобы каждый раз не вводить пользователю. ДЛя генерации тестовых данных достаточно запустить метод main в среде
разработки либо запустить через консоль. Выходными данными являются: время работы каждого метода при разных 
объемах данных.
#### Контрольные тесты (benchmarks)
Для того, чтобы сделать контрольные тесты, необходимо запустить метод main класса Main. Тест над наборами данных будет
производится по мере их генерации. Тест представляет из себя замерку времени у трех методов(offer(), remove()), peek()).
Время считается в наносекундах и выводится в милисекундах.
##### Список контрольных тестов
| Название              | Описание                                           | Метрики  |
| :---                  | ---                                                | :---     |
| `Benchmark`           | добавление/удаление элемента, чтение head-элемента | _время_  |
##### $Примеры запуска
В случае запуска программы через среду разработки, вызвать метод main()  
В случае запуска через консол:
1. cd .../src
2. javac Main.java
3. java Main
## $Источники
https://en.wikipedia.org/wiki/Circular_buffer  
https://habr.com/ru/company/otus/blog/557310  
https://javascopes.com/reading-and-writing-csvs-in-java-249bbeeb/
