### Pet-project для обкатки ci/cd процессов

1. Для проекта существует отдельный [репозиторий](https://github.com/Nemor89/gitlab-server), содержащий docker-compose файл с описание инфраструктуры (gitlab server, gitlab runner, nexus, elk).
2. Credentials:
   - Gitlab
      - логин: admin
      - пароль: CHANGE_ME_123 (задается в .env)
   - Nexus
      - логин: admin
      - пароль: При попытке аутентифицироваться будет указано, где посмотреть первоначальный пароль
   - Kibana
      - логин: elastic
      - пароль: changeme
3. После запуска проекта необходимо создать nexus repository http://localhost:8081/. Репозиторий необходимо назвать maven-local
4. Необходимо зарегистрировать переменные среды для локальной машины и для gitlab ci
    - *NEXUS_REPO_URL* - url созданного в nexus репозитория
    - *NEXUS_REPO_USER* - login УЗ nexus (по умолчанию admin)
    - *NEXUS_REPO_PASS* - пароль УЗ nexus (задается при первом логине)
    - *ELK_HOST* - адрес logstash (для локальной машины localhost, для gitlab ci указывается полный путь, так как запрос происходит через curl)
    - *ELK_PORT* - tcp порт logstash (по умолчанию 50000)