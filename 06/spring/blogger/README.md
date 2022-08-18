# Blogging App 

## Features

### Required 

- Users can signup to create accounts
  - Users have username, email, bio (text), avatar (img url)
- Users can login to their accounts
- Users can write blog articles 
  - Blog articles should have a heading, subheading, tags and content body 
  - Assume reasonable length for heading, subheading, no limit on body
  - Body content will be html
  - Tags are an array of strings
  - Users can delete articles they have created
  - Users can update articles they have created
- Users can comment on blog articles
  - Comments will have a title and a body 
  - Title is optional, but body is required
  - Users can delete comments they have created
- Users can like blog articles
- Users can follow other users 
- Users can see list of all other users 
  - Users can see profile of individual users
  - Users can search for profiles by username (or part)
- There should be a feed of all articles (reverse chronological order)
  - Ability to filter blogs by tags 
  - Ability to filter blogs written by a specific user
  - Ability to search for articles by title
  - Ability to sort articles by \[date (default), likes\]
- There should be a feed of all articles of authors a user is following

### Future Scope 

- Add a image upload service so that \<img\> can be embedded in blog articles
- Add support for pagination when listing articles and users

## Technical Details

### Entities

#### User 

```json
{
  "id": 12,
  "username": "johndoe001",
  "email": "john@mail.com",
  "bio": "I am a software developer",
  "avatar": "https://avatars.dicebear.com/v2/johndoe001.png",
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```
> NOTE: `password` has to be hashed and stored too


#### Article 

```json
{
  "id": 124,
  "heading": "My first blog post",
  "slug": "my-first-blog-post",
  "subheading": "This is my first blog post",
  "tags": ["blog", "first"],
  "content": "<p>This is my first blog post</p>",
  "authorId": 12,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```

#### Comment

```json
{
  "id": 17,
  "title": "My first comment",
  "body": "This is my first comment",
  "articleId": 124,
  "authorId": 42,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
``` 

#### Join Tables

##### Follows 

```json
{
  "id": 133,
  "followerId": 12,
  "followeeId": 42,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```

##### Likes 

```json
{
  "id": 524,
  "likerId": 12,
  "articleId": 124,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```

### Schema Diagram 

![image](https://user-images.githubusercontent.com/1327050/168328390-12badd31-49f9-4a00-a3be-b94f7298e4fc.png)



### API Endpoints 

#### users

##### `POST /users`
create a new user (signup)

##### `POST /users/login`
login to an existing user

##### `GET /users` 📄
list all users 

available query parameters : 
- `?sort=date` or `?sort=followers`
- `?username=something` filter by username (i.e. username contains `something`)
- `?follower=johndoe`🔐 users whom `johndoe` follows
- `?following=johndoe`🔐 find all `johndoe` followers


##### `GET /users/{userid}` 🔐
get user profile by user id

##### `GET /users/@{username}` 🔐
get user profile by username

##### `PUT /users/@{username}/follow` 🔐
follow a user

##### `DELETE /users/@{username}/follow` 🔐👤
unfollow a user


#### articles

##### `POST /articles` 🔐
create a new article

##### `GET /articles/{article-slug}`
get article by slug

##### `PATCH /articles/{article-slug}` 🔐👤
update article by slug 

##### `DELETE /articles/{article-slug}` 🔐👤
delete article by slug

##### `PUT /articles/{article-slug}/like` 🔐
like article by slug

##### `DELETE /articles/{article-slug}/like` 🔐👤
unlike article by slug

##### `GET /articles` 📄
get all articles 

available query parameters: 
- `?following=true` 🔐 (default: false) get articles of users that you are following 
- `?sort=date` (default) or `?sort=likes` : sort by date or likes
- `?tags=startups,tech` : filter articles by tags
- `?author=username` : filter articles by author
- `?title=something` : search articles by title (i.e. title includes `something`)

<details>
  <summary>Response</summary>

```json
[
  {
    "id": 124,
    "heading": "My first blog post",
    "slug": "my-first-blog-post",
    "subheading": "This is my first blog post",
    "tags": ["blog", "first"],
    "author": {
      "username": "johndoe001",
      "avatar": "https://avatars.dicebear.com/v2/johndoe001.png"
    },
    "createdAt": "2020-01-01T00:00:00.000Z"
  },
  {
    "id": 422,
    "heading": "Another nice article",
    "slug": "another-nice-article",
    "subheading": "This is another nice article",
    "tags": ["article", "first"],
    "author": {
      "username": "johndoe001",
      "avatar": "https://avatars.dicebear.com/v2/johndoe001.png"
    },
    "createdAt": "2020-01-01T00:00:00.000Z"
  }
]
```
</details>

#### comments

##### `POST /articles/{article-slug}/comments` 🔐
create a new comment on a given article 

##### `GET /articles/{article-slug}/comments` 📄
get all comments on a given article

##### `DELETE /articles/{article-slug}/comments/{comment-id}` 🔐👤
delete a comment on a given article