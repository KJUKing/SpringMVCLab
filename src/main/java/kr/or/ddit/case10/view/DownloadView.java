package kr.or.ddit.case10.view;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

public class DownloadView extends AbstractView {

    @Value("#{dirInfo.saveDir}")
    private Resource saveDirRes;

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Map<String, Object> fileInfo = (Map<String, Object>) model.get("fileInfo");

        String originalFilename = (String) fileInfo.get("originalFilename");
        String saveName = (String) fileInfo.get("saveName");
        Resource saveFile = saveDirRes.createRelative(saveName);

        resp.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        String filename = URLEncoder.encode(originalFilename, "UTF-8").replace("+", " ");
        resp.setHeader("content-disposition", "attachment;filename=\"" + filename + "\"");
        resp.setContentLengthLong(saveFile.contentLength());
        try (
                InputStream is = saveFile.getInputStream();
                OutputStream os = resp.getOutputStream();
        ) {
            IOUtils.copy(is, os);
        }

    }
}
