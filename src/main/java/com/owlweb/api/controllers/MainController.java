package com.owlweb.api.controllers;

import com.owlweb.api.services.FileConvertService;
import com.owlweb.api.services.FileMergeService;
import com.owlweb.api.services.GetDeclarationsService;
import com.owlweb.api.services.GetIndividualsService;
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

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MainController {
    private final StorageService storageService;
    private final FileConvertService fileConvertService;
    private final FileMergeService fileMergeService;
    private final GetDeclarationsService getDeclarationsService;
    private final GetIndividualsService getIndividualsService;

    @Autowired
    public MainController(StorageService storageService,
                          FileConvertService fileConvertService,
                          FileMergeService fileMergeService,
                          GetDeclarationsService getDeclarationsService,
                          GetIndividualsService getIndividualsService)
    {
        this.storageService = storageService;
        this.fileConvertService = fileConvertService;
        this.fileMergeService = fileMergeService;
        this.getDeclarationsService = getDeclarationsService;
        this.getIndividualsService = getIndividualsService;
    }

    @PostMapping("/api/v1/convert")
    public ResponseEntity<Resource> convert(@RequestParam("file") MultipartFile file, @RequestParam("format") String format) {
        String sourceFileName = storageService.store(file);

        String convertedFileName = this.fileConvertService.convertFile(sourceFileName, format);

        Resource convertedFile = storageService.loadAsResource(convertedFileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + convertedFileName + "\"").body(convertedFile);
    }

    @PostMapping("/api/v1/merge")
    public ResponseEntity<Resource> merge(@RequestParam("files") MultipartFile[] files) {
        List<String> fileNames = new ArrayList<>();
        for (MultipartFile file : files) {
            String sourceFileName = storageService.store(file);
            fileNames.add(sourceFileName);
        }

        String convertedFileName = this.fileMergeService.mergeFiles(fileNames.toArray(new String[fileNames.size()]));

        Resource convertedFile = storageService.loadAsResource(convertedFileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + convertedFileName + "\"").body(convertedFile);
    }
}
