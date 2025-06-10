## Flight Scheduler

### 🧱 Main entities:
**Flight (Flight)** - contains information about departure, duration, delays and current status.

Possible statuses (FlightStatus):

* **SCHEDULED** - the flight is scheduled and there are no delays.
* **DELAYED** - flight delayed, departure delayed for some time.
* **DEPARTED** - the flight has departed but has not arrived yet.
*  **ARRIVED** - the plane has arrived.

---
### 🔄 How the status change logic works:
* Up to departure time (delay, if any, is taken into account):
  * If there is no delay → status **SCHEDULED**
  * If there is a delay → status **DELAYED**
* When is the departure time (taking delay into account): If the current time is after departure but before the end of the flight (departure + duration) → status **DEPARTED**
* When the time is longer than departure + duration: The airplane must already be in place → status **ARRIVED**
---
### 🕒 What is taken into account in the calculations:
* departureTime - scheduled departure time
* delayDuration - delay (e.g. 30 minutes)
* flightDuration - flight duration (e.g. 2 hours)
* ZoneId - time zone of departure (e.g. “Europe/London”)
* now - current time in the same time zone

---
### 📌 Examples:
1. Time now: 16:30, departure at 17:00, no delays → **SCHEDULED**
3. Time now: 17:15, departure at 17:00, no delay, flight lasts 2 h → **DEPARTED**
5. Time now: 19:30, departure at 17:00, flight lasts 2 hours → **ARRIVED**
7. Time now: 17:15, departure at 17:00, delay 30 min → actual departure at 17:30, so now still → **DELAYED**

---
### 🧪 Method updateStatus()
The method checks the current time and automatically changes the flight status depending on the conditions described above. It is called each time before printing the information (printFlightDetails()).

---
# Описание логики работы программы Flight Scheduler

### 🧱 Основные сущности:
**Рейс (Flight)** — содержит информацию о вылете, длительности, задержках и текущем статусе.

Возможные статусы (FlightStatus):

* **SCHEDULED** — рейс запланирован и задержек нет.
* **DELAYED** — рейс задержан, вылет отложен на некоторое время.
* **DEPARTED** — самолёт вылетел, но ещё не прибыл.
* **ARRIVED** — самолёт прибыл.

---
### 🔄 Как работает логика смены статуса:
* До времени вылета (учитывается задержка, если есть):
  * Если нет задержки → статус **SCHEDULED**
  * Если есть задержка → статус **DELAYED**
* Когда наступает время вылета (с учётом задержки): Если текущее время после вылета, но до окончания полёта (вылет + длительность) → статус **DEPARTED**
* Когда время больше, чем вылет + длительность: Самолёт должен быть уже на месте → статус **ARRIVED**
---
### 🕒 Что учитывается при расчётах:
* departureTime — плановое время вылета
* delayDuration — задержка (например, 30 минут)
* flightDuration — продолжительность полёта (например, 2 часа)
* ZoneId — часовой пояс вылета (например, "Europe/London")
* now — текущее время в том же часовом поясе
---
### 📌 Примеры:
1. Время сейчас: 16:30, вылет в 17:00, без задержек → **SCHEDULED**
3. Время сейчас: 17:15, вылет в 17:00, без задержек, полёт длится 2 ч → **DEPARTED**
5. Время сейчас: 19:30, вылет в 17:00, полёт длится 2 ч → **ARRIVED**
7. Время сейчас: 17:15, вылет в 17:00, задержка 30 мин → фактический вылет в 17:30, значит сейчас ещё → **DELAYED**

---
### 🧪 Метод updateStatus()
Метод проверяет текущее время и автоматически меняет статус рейса в зависимости от описанных выше условий. Он вызывается каждый раз перед выводом информации (printFlightDetails()).

