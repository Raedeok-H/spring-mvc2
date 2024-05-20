package hello.upload.controller;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemForm {
    private Long itemId;
    private String itemName;
    private MultipartFile attachFile; // domain.Item 과 필드가 다르다
    private List<MultipartFile> imageFiles; // domain.Item 과 필드가 다르다
}
