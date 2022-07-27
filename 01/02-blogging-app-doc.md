# Blogging App Backend Service

## API Docs

**POST** `/auth/signup`

Request

```json

{
  "username": "nandini",
  "email" : "test@test.com",
  "password" : "abcd123",
  "bio" : "This is my bio",
  "avatar" : "http://example.com/dir1/xyz123.png"
}

```

**POST** `/auth/login`

Request

```json

{
  "username": "nandini",
  "password" : "abcd123"
}

```

Response
```json

{
  "token" : "abcder45678ioqer"
}

```

| query param | definition                           | 
|-------------|--------------------------------------|
| `articles`  | if true, include articles in results | 

**GET** `/users/{id}/articles` 📄
>get all articles of a particular user/author

```json
[
  {
    "id": 1,
    "title": "title1",
    "subtitle": "subtitle1",
    "body": "body1",
    "tags" : ["tag1","tag2"],
    "author" : "user1"
  },
  {
    "id": 2,
    "title": "title2",
    "subtitle": "subtitle2",
    "body": "body2",
    "tags" : ["tag3","tag4"],
    "author" : "user1"
  }
]



```

**GET** `/articles` 📄
> get all articles

```json
[
  {
    "id": 1,
    "title": "title1",
    "subtitle": "subtitle1",
    "body": "body1",
    "tags" : ["tag1","tag2"],
    "author" : "user1"
  },
  {
    "id": 2,
    "title": "title2",
    "subtitle": "subtitle2",
    "body": "body2",
    "tags" : ["tag3","tag4"],
    "author" : "user1"
  }
]

```

**GET** `/articles?search=username:johnwriter11,tags:javascript`
> filter articles by author and tags
```json
[
  {
    "id": 1,
    "title": "title1",
    "subtitle": "subtitle1",
    "body": "body1",
    "tags" : ["javascript","tag2"],
    "author": "johnwriter11"
  },
  {
    "id": 2,
    "title": "title2",
    "subtitle": "subtitle2",
    "body": "body2",
    "tags" : ["tag3","javascript"],
    "author": "johnwriter11"
  }
]
```

**PUT** `/users/{id}/articles`
>updates article details (title, subtitle, body, tags)

Request
```json
{
  "title": "title2",
  "subtitle": "subtitle2",
  "body": "body2",
  "tags" : ["tag4","javascript"]
}
```

**DELETE** `/users/{id}/articles/{id}`
> deletes aan article by the author


**GET** `articles/{id}/likes`
> get  list of users who have liked the article

```json
[
  {
    "username": "user1"
  },
  {
    "username" : "user2"
  },
  {
    "username" : "user3"
  }
]
```

| query param | definition                           | 
|-------------|--------------------------------------|
| `comments`, | if true, include comments in results | 

**GET** `articles/{id}/comments`

examples -   
`/articles/4?comments=true`  - fetch details of article id = 4, including its comments

```json
[
  {
    "id": 1,
    "title": "title1",
    "subtitle": "subtitle1",
    "body": "body1",
    "tags": [
      "javascript",
      "tag2"
    ],
    "author": "johnwriter11",
    "comments": [
      {
        "content": "comment1",
        "created_time": "2022/03/20T19:00",
        "posted_by": "user1"
      },
      {
        "content": "comment2",
        "created_time": "2022/03/27T19:00",
        "posted_by": "user2"
      }
    ]
  }
]
  
```

**DELETE** `articles/{id}/comments/{id}`
> deletes the comment for an article



### References

If 📄 is used, it means the endpoint supports `?size=10&page=2` type of pagination properties

## Entities 

![blggingApp drawio (3)](https://user-images.githubusercontent.com/93430500/181287657-06e4b854-7edd-473f-9e2e-61299288af07.png)
