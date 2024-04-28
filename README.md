Rest API Spring проект с базовыми эндпоинтами авторизации, регистрации, приема заявок и выдачи списка новостей. 
Поднят бд postgres через сервис heroku. 
Добавлены классы модели для взаимодействия с бд.
Системные поля(id, created_at) описаны в абстрактном классе BaseEntity.
Созданы DTO классы для отправки запросов по restApi.
Классы разделены по отдельным директориям dto, model, repository, rest, service.
Проект задеплоен на heroku с помощью докер контейнера.

Endpoints:

Add Objects:
POST: https://phoenix-test-task-6bebb9af0121.herokuapp.com/api/v1/request/addObject
{
  "name": "string",
  "quantity": 0,
  "phone": 0,
  "address": "string"
}

Show News: 
GET: https://phoenix-test-task-6bebb9af0121.herokuapp.com/api/v1/request/showNews

Register:
POST: https://phoenix-test-task-6bebb9af0121.herokuapp.com/api/v1/auth/register
{
  "username": "string",
  "password": "string",
  "passwordConfirm": "string",
  "fio": "string",
  "avatarLink": "string"
}
Login:
POST: https://phoenix-test-task-6bebb9af0121.herokuapp.com/api/v1/auth/login
{
  "username": "string",
  "password": "string"
}

Swagger: https://phoenix-test-task-6bebb9af0121.herokuapp.com/swagger-ui.html

