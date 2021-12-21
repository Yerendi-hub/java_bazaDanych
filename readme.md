# Baza danych
Projekt bazy danych realizowany na zaliczenie przedmiotu "Programowanie w języku Java" na Politechnice Krakowskiej. \
\
Celem projektu jest symulacja prostej relacyjnej bazy danych. \
Czas życia bazy danych jest równy czasowi działania programu.
##Dostępne komendy:
\
**CREATE DATABASE db_name** - tworzy baze danych o podanej nazwie\
\
**CREATE TABLE table_name field1_name field1_type field2_name field2_type ...** - 
tworzy tabelkę o podanej nazwie wewnątrz domyślnej bazy danych. 
Automatycznie tworzona jest kolumna **id** auto increment typu *int* będąca kluczem głównym tabelki. Wspierane typy:\
_int_\
_string_
\
\
**USE db_name** - wybiera bazę danych "db_name" jako bazę domyślną \
\
**INSERT INTO table_name val1 val2 ...** - pozwala dodać do tabelki podane wartosci 
(należy pdoać wszystkie wymagane przez tabelkę oprócz 'id'). Stringi mogą zawierać tylko jeden wyraz bez spacji. \
\
**SHOW DATABASES** - pokazuje utworzone bazy\
\
**SHOW TABLES** - pokazuje tabelki w bazie\
\
**DELETE FROM table_name id** - pozwala usunąć wpis o podanym id\
\
**UPDATE table_name id val1 val2 ...** - pozwala zmodyfikować wpis o podanym ID\
\
**SELECT FROM table_name** - wyświetla zawartość podanej tabelki\
\
**HELP** - wyświetla dostępne komendy\
\
**HELP command_name** - wyświetla szczegółowy opis komendy\
\
**QUIT** - wychodzi z programu
