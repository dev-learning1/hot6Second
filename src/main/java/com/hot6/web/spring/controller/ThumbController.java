package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.ThumbVO;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/thumb/*")
public class ThumbController {
    @PostMapping("/upload")
    public List<ThumbVO> upload(List<MultipartFile> upload) throws IOException {
        String rootPath = "C:/upload";
        String uploadPath = getUploadPath();
        List<ThumbVO> thumbs = new ArrayList<>();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        for(MultipartFile multipartFile : upload){
            ThumbVO thumbVO = new ThumbVO();
            UUID uuid = UUID.randomUUID();
            String thumbName = multipartFile.getOriginalFilename();
            String uploadThumbName = uuid.toString() + "_" + thumbName;
            System.out.println("1");
            thumbVO.setThumbName(thumbName);
            thumbVO.setThumbUuid(uuid.toString());
            thumbVO.setThumbUploadPath(getUploadPath());
            thumbVO.setThumbSize(multipartFile.getSize());
            thumbVO.setUserNumber((long)15);
            System.out.println("2");
            File fullPath = new File(uploadFullPath, uploadThumbName);
            multipartFile.transferTo(fullPath);
            System.out.println("3");
            if(Files.probeContentType(fullPath.toPath()).startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(uploadFullPath, "s_" + uploadThumbName));
                Thumbnailator.createThumbnail(multipartFile.getInputStream(), out, 100, 100);
                System.out.println("4");
                out.close();
                thumbVO.setThumbImageCheck(true);
            }
            System.out.println("5");
            thumbs.add(thumbVO);
        }
        System.out.println("6");
        System.out.println(thumbs);
        return thumbs;
    }

    @GetMapping("/display")
    public byte[] display(String thumbName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload", thumbName));
    }

    @PostMapping("/delete")
    public void delete(ThumbVO thumbVO) {
        File file = new File("C:/upload", thumbVO.getThumbUploadPath() + "/" + thumbVO.getThumbName());
        if(file.exists()){
            file.delete();
        }
        if(thumbVO.isThumbImageCheck()){
            file = new File("C:/upload", thumbVO.getThumbUploadPath() + "/s_" + thumbVO.getThumbName());
            if(file.exists()){
                file.delete();
            }
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String thumbName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + thumbName);
        HttpHeaders header = new HttpHeaders();
        String name = resource.getFilename();
        name = name.substring(name.indexOf("_") + 1);
        header.add("Content-Disposition", "attachment;filename=" + new String(name.getBytes(), "UTF-8"));
        return new ResponseEntity<>(resource, header, HttpStatus.OK);
    }

    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

}