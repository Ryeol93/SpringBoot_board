/*
 * 문제점
 *   1. 동일한 이름으로 파일이 업로드 되었을 때 기존 파일이 사라지는 문제
 *   2. 이미지 파일의 경우 원본 파일의 용량이 큰 경우 썸네일 이미지를 생성해야 하는 문제
 *   3. 이미지 파일과 일반 파일을 구분해서 다운로드 혹은 페이지에서 조회하도록 처리하는 문제
 *   4. 첨부파일 공격에 대비하기 위한 업로드 파일의 확장자 제한
 * */
package com.example.ex03.controller;

import com.example.ex03.domain.vo.AttachFileVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/upload/*")
public class UploadController {

    @GetMapping("/uploadForm")
    public void uploadForm(){
        log.info("upload form");
    }

    @PostMapping("/uploadFormAction")
//    외부에서 여러 파일을 배열형태로 전달받는다.
    public void upload(MultipartFile[] uploadFile){
        //첨부파일 저장경로를 작성한다.
        String uploadFolder = "C:/upload";
        for(MultipartFile file : uploadFile){
            //전달받은 파일의 정보를 출력한다.
            log.info("-------------------------");
            log.info("Upload File Name : " + file.getOriginalFilename());
            log.info("Upload File Size : " + file.getSize());

            //저장할 경로와 파일의 이름을 File객체에 담는다.
            File saveFile = new File(uploadFolder, file.getOriginalFilename());

            try {
                //설정한 경로에 해당 파일을 업로드한다.
                file.transferTo(saveFile);
            } catch (IOException e) {
                log.error(e.getMessage());
            }

        }
    }

    @GetMapping("/uploadAjax")
    public void uploadAjax(){
        log.info("upload ajax");
    }

    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public List<AttachFileVO> uploadAjaxPost(MultipartFile[] uploadFile){
        String uploadFolder = "C:/upload";
        List<AttachFileVO> fileList = new ArrayList<>();
//        UUID(Universally unique identifier) : 범용 고유 식별자
//        네트워크 상에서 각각의 개체들을 식별하기 위하여 사용되었다.
//        중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
//        UUID의 개수는 10의 38승입니다.

        UUID uuid = UUID.randomUUID();
        String uploadFileName = null;

        String uploadFolderPath = getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        for(MultipartFile file : uploadFile){
            log.info("-------------------------");
            log.info("Upload File Name : " + file.getOriginalFilename());
            log.info("Upload File Size : " + file.getSize());

            AttachFileVO attachFileVO = new AttachFileVO();
            uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();

            attachFileVO.setFileName(uploadFileName);
            attachFileVO.setUuid(uuid.toString());
            attachFileVO.setUploadPath(uploadFolderPath);

            //저장할 경로와 파일의 이름을 File객체에 담는다.
            File saveFile = new File(uploadPath, uploadFileName);

            try {
                //설정한 경로에 해당 파일을 업로드한다.
                file.transferTo(saveFile);
//                InputStream in = new FileInputStream(saveFile);

                if(checkImageType(saveFile)){
                    attachFileVO.setImage(true);
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
//                    Thumbnailator.createThumbnail(in, thumbnail, 100, 100);
                    Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100);
                    thumbnail.close();
                }
                fileList.add(attachFileVO);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return fileList;
    }

    private String getPath(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }

    private boolean checkImageType(File file){
        try {
            //헤더에 담긴 파일의 ContentType을 가져온다.
            //startsWith()를 사용해서 image라는 문자열로 시작한다면 true리턴, 아니면 false리턴
            return Files.probeContentType(file.toPath()).startsWith("image");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}








