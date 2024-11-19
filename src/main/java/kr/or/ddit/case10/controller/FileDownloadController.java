package kr.or.ddit.case10.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/case10/download")
public class FileDownloadController {

    @Value("#{dirInfo.saveDir}")
    private Resource saveDirRes;

    @GetMapping("{saveName}")
    public String download3(@PathVariable String saveName, Model model){
        Map<String, Object> fileInfo = new HashMap<String, Object>();
        fileInfo.put("originalFileName", "한글 파일");
        fileInfo.put("saveName", saveName);
        model.addAttribute("fileInfo", fileInfo);
        return "downloadView";
    }

//    @GetMapping("{saveName}")
    public ResponseEntity<Resource> download1(@PathVariable String saveName) throws IOException {
        Resource saveFile = saveDirRes.createRelative(saveName);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        String originalFilename = "한글 파일";

        ContentDisposition disposition = ContentDisposition.attachment()
                .filename(originalFilename, Charset.defaultCharset())
                .build();

        headers.setContentDisposition(disposition);
        headers.setContentLength(saveFile.contentLength());
        return ResponseEntity.ok()
                .headers(headers)
                .body(saveFile);
//        resp.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
//        String originalFilename = "한글 파일";
//        String filename = URLEncoder.encode(originalFilename, "UTF-8").replace("+", " ");
//        resp.setHeader("content-disposition", "attachment;filename=\"" + filename + "\"");
//        resp.setContentLengthLong(saveFile.contentLength());
//        try (
//                InputStream is = saveFile.getInputStream();
//                OutputStream os = resp.getOutputStream();
//        ) {
//            IOUtils.copy(is, os);
//        }
    }

//    void 반환값인 경우, logical view name을 찾아내는 전략 : RequestToViewNameTranslator
    @GetMapping
    public void getUI() {

    }
}
