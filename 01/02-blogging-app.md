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

**GET** `/likes/{articleId}
> get a list of all user who liked the article  
 
```json
[
  {
    "articleId": 1,
     "userId" : 123,
     "userName" : Prakash
  },
  {
    "articleId": 1,
     "userId" : 321,
     "userName" : Anshuman
  },
  
    ]
 
```

**GET** `/comments/{articleId}
> get a list of comments under an article  
 
```json
[
  {
    "articleId": 1,
    "commentId" :1
    "commentText" : It was good , could be better.
     "userId" : 123,
     "userName" : Prakash
  },
  {
    "articleId": 1,
    "commentId" :2
    "commentText" : i didnt like it at all.
     "userId" : 123,
     "userName" : Prakash
  },
  
    ]
 
```

**POST** `/registerUser
> Register a user  
 
```json
  {
    "username": 1,
    "email" :1
    "password" : verySecretPassword.
     "bio" : 123,
     "avatar" : www.photoupdate.com/123
  }
  
 
```

**Post** `/loginUser
> Register a user  
 
```json
 
 POST <webservice>/Login HTTP/1.1
 Host: client.mydomain.com
 Accept: application/json
 Content-type: application/json

{ 
  "username":"admin",
  "password":"RkVSNTVXND0"
}
  
 
```

**Post** `/createArticle
> Create New Article 
 
```json

{ 
  "author":"userId",
  "title":"How to become superman?"
  "body": "start wearing a cape"
  "tags": "superman,cape"
}
  
 
```

**Post** `/likeArticle/{articleId}
> Like a Article 
 
```json

{ 
  "userId":"userId",
}
  
 
```

**Post** `/CommentArticle/{articleId}
> Comment on a Article 
 
```json

{ 
  "userId":"userId",
  "title":"How to become superman?"
}
  
 
```

**PUT** `/editArticle/{articleId}
> Edit a Article 
 
```json

{ 
  "author":"userId",
  "title":"How to become superman?"
  "body": "start wearing a cape"
  "tags": "superman,cape"
}
  
```
**Delete** `/deleteArticle/{articleId}/userId/{userId}
> Delete a Article 
`

**Delete** `/deleteComment/{commentId}/userId/{userId}
> Delete a comment 
 


### References 

If 📄 is used, it means the endpoint supports `?size=10&page=2` type of pagination properties 

## Entities 

<img width="617" alt="image" src="https://user-images.githubusercontent.com/10246491/181072385-77de2953-cdb7-42fe-bbd8-2f8b93b91cc5.png">
