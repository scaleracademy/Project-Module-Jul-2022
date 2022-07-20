# Projects 

## 01 Todo List API 

### Features 

- We have **Tasks** and **Notes** 

- Tasks 
	- We can see all existing tasks
	- We can create new tasks
		- Every task has a title, a due date, and a boolean flag "completed"
		- Every task once created, also has a unique ID 
	- A given task can be marked as completed (or undo completed too)
	- Due date of a task can be changed 
	- Task can be deleted

- Notes 
	- Notes exist inside tasks
	- Every note has a title and a body
		- once a note is added, it should have an id too
	- Multiple notes can be added into a task

> NOTE: Take other necessary assumptions
	


## 02 Blogging App 

### Entities 
- Users
- Articles
- Comments 

### Features 

- Users
	- signup user using following details
		- username, email, password, bio, avatar (just url of image)
	- login user
		- provided username + password, if correct, respond with a token 

- Articles 
	- Each article is written by an "author" which is an existing user
	- Articles have 
		- title, subtitle (use appropriate max lengths)
		- body (can be upto 5000 char)
		- tags (array of things like: tech, javascript, blog)
	- We can see all articles on the site 
		- There can be thousands of articles, so pagination is needed 
		- We should be able to filter articles by author and tags
			- i.e. show me all articles written on 'javascript'
			- show me all articles written by user 'johnwriter11' 
	- Articles can be edited (title, subtitle, body, tags), by the author
	- Articles can be deleted by the author 
	- Likes
		- Articles can be liked by anyone
		- We can see list of users who have liked the article 


- Comments
	- Comments are written under an article
	- Comments also have an author 
	- We should be able to see all comments under an article
	- Comments can be deleted by the author of the comment 


> NOTE: Take other necessary assumptions



## 03 Event Ticketing System 