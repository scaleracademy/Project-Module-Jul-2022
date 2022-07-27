# Todo List Backend Service 

## API Docs 

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

### References 

If 📄 is used, it means the endpoint supports `?size=10&page=2` type of pagination properties 

## Entities 

![image](https://user-images.githubusercontent.com/1327050/180837289-72d49220-f104-45dd-80c6-e30378ab62a6.png)

