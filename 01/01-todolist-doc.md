# Todo List Backend Service 

## API Docs 

**POST** `/tasks'
> to create a new task

```json 
  {
    "title": "this is something that i need to complete",
    "due_date": 20220205
    "completed": false,
  }
```
**POST** `/tasks/{id}'
> to update duedate, description, completed status of any task

```json 
  {
    "title": "this is something that i need to complete",
    "due_date": 20220205
    "completed": true,
  }
```

**DELETE** '/tasks/{id}'
> deletes the task with the ID provided


**POST** `/tasks/{id}/notes'
> to create a new task

```json 
  {
     "title": "travel",
     "body": "Need to leave by 5:00 PM"
  }
```


**GET** `/tasks` 📄  
> get a list of all tasks 
 
```json
[
  {
    "id": 1,
    "title": "this is something that i need to complete",
    "due_date": 20220205
    "completed": false
  },
  {
    "id": 2,
    "title": "this is also something that i need to complete",
    "due_date": 20220206
    "completed": true
  }
]
```

**GET** `/tasks/{id}` 
> get a task by id 

```json 
  {
    "id": 1,
    "title": "this is something that i need to complete",
    "due_date": 20220205
    "completed": false,
    "notes": [
      
    ]
  }
```

|query param | definition | 
| -----------|-----------|
| `notes`    | if true, include notes in results | 

examples -   
`/tasks/4?notes=true`  - fetch details of task id = 4, including its notes 


**GET** `/tasks/{id}/notes` 
> get all notes inside a task 

```json
[
  {},
  {}
]
```



# Blogging App

## API Docs 

**POST** `/create_user'
> to create a new user

```json 
  {
    "username": "John",
    "email": "john45@gmail.com",
    "password": "password"
  }
```

**POST** `/login'
> login

```json 
  {
    "username": "John",
    "password": "password"
  }
```

**POST** '/create_article/{id}'
> create an article

```json 
  {
    "user_id": "12345678",
    "title": "This is my title",
	"subtitle": "subtitle"
    "body": "contains body of article"
	"tags": ['list', 'of', 'tags']
  }
```


**GET** `/articles` 📄  
> get a list of all the articles 
 
```json
[
  {
	"user_id": "12345678",
    "article_id": 1,
    "title": "This is my title",
	"subtitle": "subtitle"
    "body": "contains body of article"
	"tags": ['list', 'of', 'tags']
  },
  {
	"user_id": "123332378",
    "article_id": 2,
    "title": "This is my title",
	"subtitle": "subtitle"
    "body": "contains body of article"
	"tags": ['list', 'of', 'tags']
  }
]
```

**GET** `/{user_id}/{article_id}` 
> get all the articles by a user 

```json 
  [
  {
    "article_id": 1,
    "title": "This is my title",
	"subtitle": "subtitle"
    "body": "contains body of article"
	"tags": ['list', 'of', 'tags']
  },
  {
    "article_id": 25,
    "title": "This is my title",
	"subtitle": "subtitle"
    "body": "contains body of article"
	"tags": ['list', 'of', 'tags']
  }
]
```

**GET** `/articles?tags=['sometag']` 📄  
> get a list of all the articles which has the mentioned tag
 
```json
[
  {
	"user_id": "12345678",
    "article_id": 1,
    "title": "This is my title",
	"subtitle": "subtitle"
    "body": "contains body of article"
	"tags": ['list', 'of', 'tags', 'sometag']
  },
  {
	"user_id": "123332378",
    "article_id": 2,
    "title": "This is my title",
	"subtitle": "subtitle"
    "body": "contains body of article"
	"tags": ['list', 'of', 'tags', 'sometag']
  }
]
```

**POST** '/update_article/{id}'
> update an article

```json 
  {
    "title": "This is the new title",
	"subtitle": "new subtitle"
    "body": "contains new body of article"
	"tags": ['list', 'of', 'tags','adding a new tag']
  }
```

**DELETE** '/articles'
> DELETE all the articles by the logged in user

**DELETE** '/articles/{id}'
> DELETE a specific article identified by the ID 


**POST** '/article/{id}/like'
> like an article

```json 
  {	
	"user_id": "32324242",
    "article_id": "686868"
  }
```

**POST** '/article/{id}/comment'
> like an article

```json 
  {	
	"user_id": "32324242",
	"comment_text": "I have commented on this article"
  }
```

**DELETE** '/comments/{article_id}'
> DELETE the comments made by the logged in user



### References 

If 📄 is used, it means the endpoint supports `?size=10&page=2` type of pagination properties 

## Entities 

![image](https://user-images.githubusercontent.com/1327050/180837289-72d49220-f104-45dd-80c6-e30378ab62a6.png)

