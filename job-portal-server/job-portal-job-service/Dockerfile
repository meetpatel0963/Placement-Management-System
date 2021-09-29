FROM golang:1.17.1-alpine3.14

# Set /job-service-app as a current working directory
WORKDIR /job-service-app

# Copy go.mod and go.sum to /job-service-app
COPY go.mod go.sum ./

# Download all the dependencies
RUN go mod download

# Copy all the files from local dir to docker image dir
COPY . .

# Build the go binary
RUN go build -o /job-service

CMD [ "/job-service" ]
