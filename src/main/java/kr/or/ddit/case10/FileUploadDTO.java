package kr.or.ddit.case10;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class FileUploadDTO {
    @NotBlank
    private String uploader;
    @NotNull
    private MultipartFile uploadFile;
    @NotBlank
    private String saveName;

    public void setUploadFile(MultipartFile uploadFile) {
        if (uploadFile.isEmpty()) return;

        this.uploadFile = uploadFile;
        this.saveName = UUID.randomUUID().toString();

    }
}
