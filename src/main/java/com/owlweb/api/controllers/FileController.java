package com.owlweb.api.controllers;

import com.owlweb.api.services.FileConvertService;
import com.owlweb.api.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
public class FileController {
    private final StorageService storageService;
    private final FileConvertService fileConvertService;

    @Autowired
    public FileController(StorageService storageService, FileConvertService fileConvertService) {
        this.storageService = storageService;
        this.fileConvertService = fileConvertService;
    }

    @PostMapping("/api/convert")
    public ResponseEntity<Resource> handleFileUpload(@RequestParam("file") MultipartFile file) {
        storageService.store(file);

        // TODO formats "owlxml" "turtle" "manchester" "fss" "latex"
        String convertedFileName = this.fileConvertService.convertFile(file.getOriginalFilename(), "rdfxml");

        Resource convertedFile = storageService.loadAsResource(convertedFileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + convertedFileName + "\"").body(convertedFile);
    }
}
