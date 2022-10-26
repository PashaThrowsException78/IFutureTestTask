AccountService для тестового задания на позицию java-разработчика в компанию IFuture
"Исследование AccountService'а"

------------------------------------------------------------------------------------------------------
Цель: создать сервис и оценить время доступа к нему в зависимости от входных параметров
------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------
1. Создать сервис со следующим интерфейсом:
------------------------------------------------------------------------------------------------------
public interface AccountService
{
    /**
     * Retrieves current balance or zero if addAmount() method was not called before for specified id
     *
     * @param id balance identifier
     */
    Long getAmount(Integer id);

    /**
     * Increases balance or set if addAmount() method was called first time
     *
     * @param id balance identifier
     * @param value positive or negative value, which must be added to current balance
     */
    void addAmount(Integer id, Long value);
}

Сервис будет работать в высоконагруженной отказоустойчивой системе.

Сервис должен кэшировать данные в памяти и сохранять данные в БД (Oracle, PostgreSQL, MySQL) 
или бросать Exception'ы если выполнить операцию не удалось.

В качестве транспортного слоя можно выбрать любой из протоколов RMI, Hessian, HTTP

------------------------------------------------------------------------------------------------------
2. Создать тестового клиента
------------------------------------------------------------------------------------------------------
Тестовый клиент должен уметь запускать несколько конкурентных потоков на определённом подмножестве идентификаторов
  - rCount - количество читателей вызывающих метод getAmount(id)
  - wCount - количество читателей вызывающих метод addAmount(id,value)
  - idList - список или доапазон ключей которые будут использоваться для тестирования
Эти параметры можно задавать через командную строчку или конфигурационный файл.

Одновременно можно запускать несколько тестовых клиентов на одном или разных компьютерах.

------------------------------------------------------------------------------------------------------
3. Получить стаистику обрабатки запросов на сервере AccountService'ом 
------------------------------------------------------------------------------------------------------
Для каждого из двух методов AccountService'а (getAmount, addAmount) нужно получить
  - кол-во запросов обрабатываемых в единицу времени на сервере (!!! не на клиенте) 
  - общее кол-во запросов от всех клентов
  
Статистику с сервиса можно получать по требованию любым способом 
или сбрасывать в лог с определённой периодичностью.
Предусмотреть возможность сбросить статистику в ноль на работающем сервисе.
