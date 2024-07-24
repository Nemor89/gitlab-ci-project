### Pet-project для обкатки ci/cd процессов

1. Для проекта существует отдельный [репозиторий](https://github.com/Nemor89/gitlab-server), содержащий docker-compose файл с описание инфраструктуры gitlab (server, runner). Пароль администратора для вебки gitlab задается в .env 
2. После запуска проекта необходимо создать nexus repository http://localhost:8081/
3. Необходимо зарегистрировать переменные среды для локальной машины и для gitlab ci
    - *NEXUS_REPO_URL* - url созданного в nexus репозитория
    - *NEXUS_REPO_USER* - login УЗ nexus (по умолчанию admin)
    - *NEXUS_REPO_PASS* - пароль УЗ nexus (задается при первом логине)