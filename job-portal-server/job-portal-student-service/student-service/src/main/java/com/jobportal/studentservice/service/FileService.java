package com.jobportal.studentservice.service;

import com.jobportal.studentservice.model.File;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

    public Optional<String> addFile(MultipartFile upload) {

        //define additional metadata
        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());
        Object fileID;

        try {
            //store in database which returns the objectID
            fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
        } catch(IOException e) {
            return Optional.empty();
        }

        //return as a string
        return Optional.ofNullable(fileID.toString());
    }

    public Optional<File> findById(String id) {
        File loadFile = new File();

        try {
            GridFSFile gridFSFile = template.findOne(new Query(Criteria.where("_id").is(id)));

            if (gridFSFile != null && gridFSFile.getMetadata() != null) {
                loadFile.setFilename(gridFSFile.getFilename());

                loadFile.setFileType(gridFSFile.getMetadata().get("_contentType").toString());

                loadFile.setFileSize(gridFSFile.getMetadata().get("fileSize").toString());

                loadFile.setFile(IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()));
            }
            else{
                return Optional.empty();
            }
        } catch(IOException e) {
            return Optional.empty();
        }

        return Optional.of(loadFile);
    }

    public void deleteFile(String id) {
        template.delete(new Query(Criteria.where("_id").is(id)));
    }
}
