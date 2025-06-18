# Spring-demo\_oris

Краткое описание:

Это простое Spring Boot веб-приложение, упакованное в Docker-контейнеры с использованием `docker-compose`. Логи приложения собираются через Promtail и хранятся в Loki, после чего доступны для просмотра в Grafana.

## Архитектура

* **app**: Spring Boot приложение, мультистадийная сборка (Maven + JDK → JAR + минимальный JRE).
* **loki**: централизованное хранилище логов.
* **promtail**: агент, собирающий логи из контейнера `app` и отправляющий их в Loki.
* **grafana**: веб-интерфейс для просмотра логов.

## Структура проекта

```
Spring-demo_oris/
├── Dockerfile
├── docker-compose.yml
├── build.sh
├── deploy.sh
├── loki-config.yaml
├── promtail-config.yaml
├── src/
│   └── main/resources/application.properties
├── logs/                # монтируемая папка для логов
└── pom.xml
```

## Требования

* Docker & Docker Compose
* Git Bash или другой Bash-терминал

## Инструкция по запуску

1. Клонировать репозиторий и перейти в папку проекта:

   ```bash
   git clone <repo-url>
   cd Spring-demo_oris
   ```

2. Убедиться, что папка для логов создана:

   ```bash
   mkdir -p logs loki-data/index loki-data/chunks loki-data/wal loki-data/cache
   ```

3. Сборка Docker-образа приложения:

   ```bash
   ./build.sh -t <tag>
   # пример: ./build.sh -t v1.0.0
   ```

4. Развертывание всего стека (app, loki, promtail, grafana):

   ```bash
   ./deploy.sh -t <tag>
   # пример: ./deploy.sh -t v1.0.0
   ```

5. Проверить статус контейнеров:

   ```bash
   docker ps
   ```

## Просмотр приложения

Откройте браузер и перейдите на [http://localhost:8080](http://localhost:8080).

### Пример скриншота работающего приложения

![App Screenshot](docs/screenshots/app.png)

## Логирование и мониторинг

Логи приложения пишутся в файл `./logs/spring-app.log`, затем Promtail подхватывает их и отправляет в Loki. В Grafana они отображаются в режиме реального времени.

### Настройка Grafana

1. Перейти в браузере на [http://localhost:3000](http://localhost:3000)
2. Войти `admin` / `admin`
3. **Configuration → Data Sources → Add data source → Loki**

   * URL: `http://loki:3100`
   * Save & Test → **Data source is working**
4. **Explore → Logs**

   * В поле **Raw query** ввести:

     ```loki
     {app="spring-app"}
     ```
   * Нажать **Run query** или включить **Live** для потокового просмотра.

### Скриншоты логов

![Promtail Logs](docs/screenshots/promtail.png)

![Grafana Logs](docs/screenshots/grafana_logs.png)

## Использование Minikube (опционально)

> *Инструкция для Kubernetes-окружения с помощью Minikube будет добавлена позже.*

---

Все требования выполнены:

* Мультистадийная сборка Dockerfile.
* Централизованное логирование в Loki.
* Просмотр логов через Grafana.
* Скрипты `build.sh` и `deploy.sh` с параметром `-t`.


![image](https://github.com/user-attachments/assets/07d28a53-a0a3-4eb9-a773-89f9db7ac9d7)
