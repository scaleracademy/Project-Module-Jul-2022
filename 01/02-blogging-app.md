# Blogging App Backend Service 

## API Docs 

**GET** `/articles?userId=roger&tags=dogs` 📄  
> get a list of all tasks 
 
```json
[
  {
    "id": 1,
    "title": "this is a good article",
    "subtitle": "this is subtitle",
    "body": "some body",
    "authorId" : "id1",
     "tags": [ "dogs","cats"]
  },
  {
    "id": 2,
    "title": "this is a good article",
    "subtitle": "this is subtitle",
    "body": "some body",
     "authorId" : "id2",
     "tags": [ "dogs","cats"]
  },
  {
    "id": 3,
    "title": "this is a good article",
    "subtitle": "this is subtitle",
    "body": "some body",
     "authorId" : "id3",
     "tags": [ "dogs","cats"]
  }
    ]
 
```





### References 

If 📄 is used, it means the endpoint supports `?size=10&page=2` type of pagination properties 

## Entities 

<img width="617" alt="image" src="https://user-images.githubusercontent.com/10246491/181072385-77de2953-cdb7-42fe-bbd8-2f8b93b91cc5.png">
