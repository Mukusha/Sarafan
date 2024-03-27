# **Sarafan** ![progress](http://www.yarntomato.com/percentbarmaker/button.php?barPosition=27&leftFill=%23FF0000 "progress") 
### _Демо проект_ 

Делаю по видео урокам letsCode [Spring Boot Rest + Vue.js](https://www.youtube.com/playlist?list=PLU2ftbIeotGqSTOVNjT4L3Yfy8jatCdhm).

**Возможности:**

✔ Отправка, редактирование, чтение и удаление сообщений.

✔ Настроен базовый JavaScript интерфейс (Vue.js). 

✔ Сохранение данных в БД.

✔ Ограничение видимости некоторых полей в JSON при помощи @JsonView

✔ Аунтификация OAuth2 при помощи Spring Security (так как видео курс старый, то делала по гайдам из docs.spring.io)

**Дока**

```java
Главная страница
        
http://localhost:8080
```

```java
Message:

{
"id":"id",
"text":"message"
}
```

```java
User:

{
"id":"id",
"name":"name",
"userpic":"userpic",
"email":"email",
"lastVisit":"lastVisit",
"provider":"provider"
}
```

**`Аунтификация`**
>**/login** - вход пользователя
> 
>**/logout** - выход пользователя

**`POST`**
>**/message** - добавление нового сообщения

**`GET`**
>**/message** - вернуть список всех сообщений
>
>**/message/{id}** - вернуть сообщение по указанному id


**`PUT`**
>**/message/{id}** - обновить сообщение по указанному id

**`DELETE`**
>**/message/{id}** - удалить сообщение с указанным id
  
**Стек технологий**

Maven, Spring, Postman, PostgresSQL.


**<details><summary>Состав видео курса</summary>**

- [X] **lec_1** - Делаем простое REST приложение с нуля.

- [X] **lec_2** - Vue.js - базовый JavaScript интерфейс (часть 1). 

- [X] **lec_3** - Vue.js - отображение и изменение данных с сервера (часть 2). 

- [X] **lec_4** - Подключаем базу данных, настраиваем Jackson.

- [X] **lec_5** - Подключаем Spring Security и oAuth2. 

- [X] **lec_6** - Настраиваем Spring Security и oAuth2 в Vue.js.

- [ ] **lec_7** - Настраиваем Webpack и разбиваем фронт на

- [ ] **lec_8** - Подключаем WebSocket (SockJS + Stomp). Spring

- [ ] **lec_9** - Стилизуем приложение с Vuetify (Material design).

- [ ] **lec_10** - Сериализуем с JsonView при отправке через WebSocket.

- [ ] **lec_11** - Настраиваем Vuex. Централизованное хранилище. 

- [ ] **lec_12** - Vue Router. Роутинг в браузере. 

- [ ] **lec_13** - Open Graph Protocol: превью ссылок на сайте по микроразметке. 

- [ ] **lec_14** - Комментарии с JPA Entity Graph. 

- [ ] **lec_15** - Решение циклических ссылок в JSON. Vue debug. 

- [ ] **lec_16** - Бесконечная прокрутка списков

- [ ] **lec_17** - Подписки пользователей. Spring Boot Rest

- [ ] **lec_18** - Подписки с подтверждением. 

- [ ] **lec_19** - Подписки с подтверждением: фронтенд. 

- [ ] **lec_20** - Sentry: собираем ошибки от пользователей.

- [ ] **lec_21** - Собираем JAR с Vue.js внутри. 

- [ ] **lec_22** - Публикация на Heroku.
      
</details>

**<details><summary>Ссылки которые помогли при настройке OAuth2</summary>**

- Статья **Spring Boot OAuth2 Login with Google Example** от *30 November 2022* - https://www.codejava.net/frameworks/spring-boot/oauth2-login-with-google-example

- Гайды от **Spring.io**
  - https://docs.spring.io/spring-authorization-server/reference/guides/how-to-social-login.html
  - https://docs.spring.io/spring-authorization-server/reference/protocol-endpoints.html
  - https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/basic.html
  - https://docs.spring.io/spring-security/reference/servlet/architecture.html#servlet-securityfilterchain


- Статьи на **Habr**
  - https://habr.com/ru/articles/346628/
  - https://habr.com/ru/articles/528410/
  

- **JavaRush** - https://javarush.com/quests/lectures/questspringsecurity.level01.lecture09

</details>