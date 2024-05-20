package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {
    private String uploadFileName; // 유저가 업로드한 파일명
    private String storeFileName; // 저장할 파일명 UUID 같은 것을 사용 -> 서로 다른 유저가 같은 이름을 사용하면 덮어질 수 있기 때문이다.

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
