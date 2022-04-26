# [JAVA] Проект "Вычислитель отличий" (gendiff)

[![Actions Status](https://github.com/danielvinogradov/java-project-lvl2/workflows/java-ci/badge.svg)](https://github.com/danielvinogradov/java-project-lvl2/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/81785547cb929e5eb0e0/maintainability)](https://codeclimate.com/github/danielvinogradov/java-project-lvl2/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/81785547cb929e5eb0e0/test_coverage)](https://codeclimate.com/github/danielvinogradov/java-project-lvl2/test_coverage)

## Описание

Это вольная реализация проекта Хекслета "Вычислитель отличий". Это консольная утилита, которая генерирует diff между
двумя файлами. Поддерживаемые форматы – JSON и YAML.

Diff генерируется не по строчкам, а по значениям. Ключи отсортированы в алфавитном порядке. Также т.к. сравнение идет по
значению, теоретически возможно сравнивать файлы разных поддерживаемых расширений, но это не тестировалось и в
приложении сейчас явным образом запрещено.

Класс `Differ` также может быть использован в качестве библиотеки.

Пример. Для файлов `file1.json`

```json 
{
  "host": "hexlet.io",
  "timeout": 50,
  "proxy": "123.234.53.22",
  "follow": false
}
```

и `file2.json`

```json
{
  "timeout": 20,
  "verbose": true,
  "host": "hexlet.io"
}
```

будет сгенерирован diff вида

```
{
  - follow: false
    host: hexlet.io
  - proxy: 123.234.53.22
  - timeout: 50
  + timeout: 20
  + verbose: true
}
```

Также возможен вывод в формате `plain`:

```
Property 'follow' was removed.
Property 'proxy' was removed.
Property 'timeout' was updated. From 50 to 20 
Property 'verbose' was added with value: true 
```

## Использование и демонстрация

Для получение информации об утилите можно запустить ее с флагом `-h`. Ожидаемый вывод:

```
gendiff [-hV] [-f=<format>] <filePath1> <filePath2>
Prints the diff between two files to STDOUT.
      <filePath1>         path to first file
      <filePath2>         path to second file
  -f, --format=<format>   output format [default: stylish]
  -h, --help              Show this help message and exit.
  -V, --version           Print version information and exit.
```

Для удобства демонстрации добавлено две команды, которые соберут приложение и запустят его с аргументами.

#### Генерация diff для json в формате stylish

```
make run-stylish-json-example 
```

[![asciicast](https://asciinema.org/a/jkXctWKP4rlcnmdJXoQNL7JCU.svg)](https://asciinema.org/a/jkXctWKP4rlcnmdJXoQNL7JCU)

#### Генерация diff для yaml в формате plain

```
make run-plain-yaml-example
```

[![asciicast](https://asciinema.org/a/eUC2u0WAA2dRF2HqgWZTk2RYf.svg)](https://asciinema.org/a/eUC2u0WAA2dRF2HqgWZTk2RYf)

Файлы, для которых генерируется diff в примерах, находятся в `/src/test/resources/hexlet/code/fixtures/*`.

## Пару слов о реализации

Краткое описание основных сущностей (большинство интерфейсов имеет единственную реализацию).

`interface FileParser` – читает и парсит файл. Основной метод `parse` преобразовывает `Path` в `Map<String, Object`, где
ключ – ключ в json/yaml, а значение – значение по ключу в json/yaml.

`interface DiffGenerator` – генерирует diff. Основной метод `generate` принимает две `Map<String, Object>` и
возвращает `Set<DiffUnit`.

`interface DiffUnit` – предоставляет информацию об изменении (добавлении, удалении, модификации или отсутствие
изменений) значения ключа.

`class DiffUnitSetFormatterFactory` – умеет возвращать класс, реализующий `interface DiffUnitSetFormatter`, основной
метод которого, `format`, форматирует переданное множество `Set<DiffUnit>` в строку.
