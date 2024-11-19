package kr.or.ddit.case10.controller;

import kr.or.ddit.case10.FileUploadDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Slf4j
@RequestMapping("/case10/fileUpload")
@Controller
public class FileUploadController {

//    @Value("file:D:/multipartDir/saveDir/")
    @Value("#{dirInfo.saveDir}")
    private Resource saveDirRes;
//    private File saveDir;
    private Path saveDir;

    // context refreshed event listener로 이동
    @PostConstruct
    public void init() throws IOException {
        this.saveDir = saveDirRes.getFile().toPath();
//        log.info("save dir: {}", saveDir);
//
//        if (!Files.exists(saveDir)) {
//            Files.createDirectories(saveDir);
//        }
    }

    @ModelAttribute("uploadDTO")
    public FileUploadDTO uploadDTO() {
        return new FileUploadDTO();
    }

    @PostMapping
    public String upload4(
            @Valid @ModelAttribute("uploadDTO") FileUploadDTO uploadDTO
            , BindingResult errors
            , RedirectAttributes redirectAttributes
    ) throws IOException {
        redirectAttributes.addFlashAttribute("uploadDTO", uploadDTO);
        if (!errors.hasErrors()) {
            Path saveFile = saveDir.resolve(uploadDTO.getSaveName());
            uploadDTO.getUploadFile().transferTo(saveFile);

            log.info("FileUploadDTO : {}", uploadDTO);
            redirectAttributes.addFlashAttribute("message", "업로드 후 이동");

            return "redirect:/case10/download";
        } else {
            String errAttrName = BindingResult.MODEL_KEY_PREFIX + "uploadDTO";
            redirectAttributes.addFlashAttribute(errAttrName, errors);
            return "redirect:/case10/fileUpload";
        }


    }
//    @PostMapping
    public void upload3(
            @ModelAttribute("uploadDTO") FileUploadDTO uploadDTO
            , Model model
    ) throws IOException {

        Path saveFile = saveDir.resolve(uploadDTO.getSaveName());
        uploadDTO.getUploadFile().transferTo(saveFile);

        log.info("uploader : {}", uploadDTO);
        model.addAttribute("mseeage", "업로드후 이동");
    }

//    @PostMapping
    public void upload2(@RequestParam String uploader
            , @RequestPart MultipartFile uploadFile
            , Model model) throws IOException {

        if (uploadFile.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        String saveName = UUID.randomUUID().toString();
        Path saveFile = saveDir.resolve(saveName);
        try(
                InputStream is = uploadFile.getInputStream();
        ) {
            Files.copy(is, saveFile, StandardCopyOption.REPLACE_EXISTING);

        }

        log.info("uploader : {}", uploader);
        log.info("uploadFile : {}", uploadFile);
        model.addAttribute("mseeage", "뭐시기 이동");

    }

//    @PostMapping
    public void upload1(MultipartHttpServletRequest wr, Model model) throws IOException {
        String saveName = UUID.randomUUID().toString();
//        Path saveFile = saveDir.createRelative(saveName).getFile().toPath();
//        Path saveFile = saveDir.resolve(saveName).getFile().toPath();

        String uploader = wr.getParameter("uploader");
        MultipartFile uploadFile = wr.getFile("uploadFile");

//        try(
//                InputStream is = uploadFile.getInputStream();
//                ) {
//            Files.copy(is, saveFile, StandardCopyOption.REPLACE_EXISTING);
//
//        }

        log.info("uploader : {}", uploader);
        log.info("uploadFile : {}", uploadFile);
        model.addAttribute("mseeage", "뭐시기 이동");
    }


    @GetMapping
    public void uploadFile() {

    }


}
