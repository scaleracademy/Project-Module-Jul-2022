# Blogging App Backend Service 

## API Docs 

**GET** `/articles` 📄  
> get a list of all tasks 
 
```json
[
  {
    "id": 1,
    "title": "this is something that i need to complete",
    "due_date": 20220205,
    "completed": false,
     "notes": [
     {
       "id": 1,
       "title": "task 1 note 1",
       "body": " full body 1"
     },
     {
       "id": 2,
       "title": "task 1 note 2",
       "body": " full body 2"
     }
    ]
  },
  {
    "id": 2,
    "title": "this is also something that i need to complete",
    "due_date": 20220206,
    "completed": true,
    "notes": [
     {
       "id": 3,
       "title": "task 1 note 1",
       "body": " full body 1"
     },
     {
       "id": 4,
       "title": "task 1 note 2",
       "body": " full body 2"
     }
    ]
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
    "completed": false
  }
```


**GET** `/tasks/4?notes=true`  
> get all notes inside a task
> fetch details of task id = 4, including its notes 
 

|query param | definition | 
| -----------|-----------|
| `notes`    | if true, include notes in results | 

```json
[
  {
    "id": 1,
    "title": "this is something that i need to complete",
    "due_date": 20220205,
    "completed": false,
     "notes": [
     {
       "id": 1,
       "title": "task 1 note 1",
       "body": " full body 1"
     },
     {
       "id": 2,
       "title": "task 1 note 2",
       "body": " full body 2"
     }
    ]
  },
  {
    "id": 2,
    "title": "this is also something that i need to complete",
    "due_date": 20220206,
    "completed": true,
    "notes": [
     {
       "id": 3,
       "title": "task 1 note 1",
       "body": " full body 1"
     },
     {
       "id": 4,
       "title": "task 1 note 2",
       "body": " full body 2"
     }
    ]
  }
]
```

**GET** `/tasks/{id}/notes` 
> get all notes inside a task 

```json
 [
     {
       "id": 1,
       "title": "task 1 note 1",
       "body": " full body 1"
     },
     {
       "id": 2,
       "title": "task 1 note 2",
       "body": " full body 2"
     }
    ]
```

**GET** `/tasks/{id}/notes/{noteId}` 
> get all notes inside a task 

```json
     {
       "id": 1,
       "title": "task 1 note 1",
       "body": " full body 1"
     }
```



**POST** `/tasks` 📄  
> Create a task with notes
 
```json
[
  {
    "title": "this is something that i need to complete",
    "due_date": 20220205,
    "completed": false,
     "notes": [
     {
       "title": "task 1 note 1",
       "body": " full body 1"
     },
     {
       "title": "task 1 note 2",
       "body": " full body 2"
     }
    ]
  }
  ]
```

**POST** `/tasks/{id}/notes` 📄  
> Create new note in existing tasks
 
```json
  {
       "title": "task 1 note 1",
       "body": " full body 1"
     }
 
  
```

**PUT** `/tasks/{id}` 
> Edit a task by id 

```json 
  {
    "id": 1,
    "title": "updated task title",
    "due_date": 20220205
    "completed": false
  }
```


**PUT** `/tasks/{id}/notes/{noteId}` 
> Edit a note inside a task 

```json
     {
       "id": 1,
       "title": "updated note",
       "body": " full body 1"
     }
```

**DELETE** `/tasks/{id}` 
> Delete a task by id 


**DELETE** `/tasks/{id}/notes/{noteId}` 
> Delete a note inside a task 



### References 

If 📄 is used, it means the endpoint supports `?size=10&page=2` type of pagination properties 

## Entities 

![image](https://user-images.githubusercontent.com/1327050/180837289-72d49220-f104-45dd-80c6-e30378ab62a6.png)
