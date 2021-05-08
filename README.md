# ROLE_ADMIN -- ROLE_USER

# GET
	http://localhost:8888/webinar
	http://localhost:8888/video
	http://localhost:8888/subject
	http://localhost:8888/course
	http://localhost:8888/tag

# GET By title
	http://localhost:8888/webinar/{title}
	http://localhost:8888/video/{title}
	http://localhost:8888/subject
	http://localhost:8888/course
	http://localhost:8888/tag

# POST - ROLE_ADMIN
	http://localhost:8888/uploadVideo
	http://localhost:8888/uploadWebinar
	http://localhost:8888/subject
	http://localhost:8888/course
	http://localhost:8888/tag

# PUT - ROLE_ADMIN
	http://localhost:8888/subject/{id}
	http://localhost:8888/course/{id}
	http://localhost:8888/tag/{id}

# DELETE - ROLE_ADMIN
	http://localhost:8888/subject/{id}
	http://localhost:8888/course/{id}
	http://localhost:8888/tag/{id}
	
	

# ROLE_USER -- UserName : test@user.com Password : testuser
# ROLE_ADMIN -- UserName : test@admin.com Password : testadmin

# Requests

http://localhost:8888/subject

{
    "name" : "google"
}

http://localhost:8888/course

{
    "name" : "Java Spring boot"

}

http://localhost:8888/tag

{
    "name" : "Java "

}

http://localhost:8888/uploadVideo

- In body select form-data
- Key as "file" as File type 
- Value select file to upload


http://localhost:8888/uploadWebinar

- In body select form-data
- Key as "file" as File type 
- Value select file to upload

	