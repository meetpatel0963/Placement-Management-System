protoc -I. src/student.proto --js_out=import_style=commonjs,binary:. --grpc-web_out=import_style=commonjs,mode=grpcwebtext:.

docker run -d --name job-portal-client -p 8080:8080 -p 9901:9901 job-portal-client


