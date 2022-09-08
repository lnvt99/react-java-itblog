#### Category APIs
**GET (without pagination)**
```
URL: http://localhost:8080/api/categories
Params: None
```
**GET (with pagination)**
```
URL: http://localhost:8080/api/categories?page={number}&limit={number}
Params: Header
  1. page: {number}
  2. limit: {number}
```
**FIND BY TITLE**
```
URL: http://localhost:8080/api/category?title={string}
Params: Header
  1. title: {string}
```
**POST**
```
URL: http://localhost:8080/api/category
Params: JSON
  {
    "title": {string},
    "slug": {string},
    "description": {string}
  }
```
**GET SINGLE BY ID**
```
URL: http://localhost:8080/api/category/{id}
Params: Header
  1. id: {number}
```
**PUT**
```
URL: http://localhost:8080/api/category/{id}
Params: Header
  1. id: {number}
Params: JSON
  {
    "title": {string},
    "slug": {string},
    "description": {string}
  }
```
**DELETE (with array of ids)**
```
URL: http://localhost:8080/api/category
Params: JSON
  ["1", "2", "3", "4", "5"]
```
***
#### Post APIs
**GET (without pagination)**
```
URL: http://localhost:8080/api/posts
Params: None
```
**GET (with pagination)**
```
URL: http://localhost:8080/api/posts?page={number}&limit={number}
Params: Header
  1. page: {number}
  2. limit: {number}
```
**GET BY TITLE**
```
URL: http://localhost:8080/api/post?title={string}
Params: Header
  1. title: {string}
```
**POST**
```
URL: http://localhost:8080/api/post
Params: JSON
  {
    "title": {string},
    "slug": {string},
    "summary": {string},
    "content": {string},
    "image_url": {string},
    "category": {Category->slug: string},
    "user": {User->slug: string}
  }
```
**GET SINGLE BY ID**
```
URL: http://localhost:8080/api/post/{id}
Params: Header
  1. id: {number}
```
**PUT**
```
URL: http://localhost:8080/api/post/{id}
Params: Header
  1. id: {number}
Params: JSON
  {
    "title": {string},
    "slug": {string},
    "summary": {string},
    "content": {string},
    "image_url": {string},
    "category": {Category->slug: string},
    "user": {User->slug: string}
  }
```
**DELETE (with array of ids)**
```
URL: http://localhost:8080/api/post
Params: JSON
  ["1", "2", "3", "4", "5"]
```