# Todo List Backend Service 

## API Docs 

**GET** /tasks 📄
> get a list of all tasks

```json
[
  {
    "id": 1,
    "title": "this is something that i need to complete",
    "due_date": "2020-05-20",
    "completed": false,
  },
  {
  "id": 2,
  "title": "Regular tasks",
  "due_date": "2020-05-20",
  "completed": false,
  }
]
```

**GET** `/tasks/{id}`
> get a task by id

```json
  {
    "id": 1,
    "title": "this is something that i need to complete",
    "due_date": "2020-05-20",
    "completed": false,
    "notes": [
      {
        "id": 1,
        "title": "Maths",
        "body": "revise maths from Unit-1 to 4"
      },
      {
        "id": 2,
        "title": "English",
        "body": "revise english from Unit-1 to 4"
      }
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
  {
        "id": 1,
        "title": "Maths",
        "body": "revise maths from Unit-1 to 4"
      },
      {
        "id": 2,
        "title": "English",
        "body": "revise english from Unit-1 to 4"
      }
]
```

**POST** `/tasks`
> create a task 

Request
```json
  {
    "id": 1,
    "title": "this is something that i need to complete",
    "due_date": "2020-05-20",
    "completed": false,
    "notes": []
  }
```

**POST** `/notes`
> create a note 

Request
```json
  {
    "id": 1,
    "title": "this is something that i need to complete",
    "due_date": "2020-05-20",
    "completed": false,
    "notes": [
      {
        "id": 1,
        "title": "Maths",
        "body": "revise maths from Unit-1 to 4"
      }
    ]
  }
```

**PATCH** `/tasks/{id}`
* updates completed status to true
* updates due date

Request
```json
{
   "completed": true,
   "due_date": "2020-05-20"
}
```

**DELETE** `/tasks/{id}`
> delete a task with given id




### References 

If 📄 is used, it means the endpoint supports `?size=10&page=2` type of pagination properties 

## Entities 

![TasksAndNotes](https://user-images.githubusercontent.com/93430500/181031553-cbccf5c3-d5e4-443b-b28e-3589a342cc24.png)
