package com.ureca.sole_paradise.petItem.service;

import com.ureca.sole_paradise.petItem.db.dto.PetItemDTO;
import com.ureca.sole_paradise.petItem.db.entity.PetItemEntity;
import com.ureca.sole_paradise.petItem.db.repository.PetItemRepository;
import com.ureca.sole_paradise.user.db.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetItemService {

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    private final PetItemRepository petItemRepository;

    public void uploadPet(PetItemDTO petItemDTO, MultipartFile file) {
        try {
//            PetItemDTO petItemDTO = new PetItemDTO();
//            petItemDTO.setName(name);
//            petItemDTO.setDescription(description);
//            petItemDTO.setPrice(price);
//            petItemDTO.setSharing(sharing);
//            petItemDTO.setCreatedAt(createdAt);
//            petItemDTO.setUser(user);  // user ID 설정

            if (file != null && !file.isEmpty()) {
                String fileName = System.currentTimeMillis()+"";// + "_" + file.getOriginalFilename();
                String[] exts = file.getOriginalFilename().split("\\.");
                String ext = exts[exts.length-1];//확장자
                Path filePath = Paths.get(UPLOAD_DIR + fileName+"."+ext);
                Files.createDirectories(filePath.getParent());
                Files.copy(file.getInputStream(), filePath);
//                        petItemDTO.setImageUrl(filePath.toString()); // 저장한 파일 경로를 리스트에 추가
                String fp = filePath.toString();
                //fp = fp.replaceAll("\\/", "/");
                System.out.println("fp="+fp);
                int staticIndex = fp.lastIndexOf("uploads");
                String ss = fp.substring(staticIndex+8);
                petItemDTO.setImageUrl(ss); // 파일 이름만 저장
                System.out.println("ss="+ss);
            }

            PetItemEntity petItemEntity = PetItemEntity.builder()
                    .name(petItemDTO.getName())
                    .description(petItemDTO.getDescription())
                    .price(petItemDTO.getPrice())
                    .sharing(petItemDTO.getSharing())
                    .createdAt(petItemDTO.getCreatedAt())
                    .user(UserEntity.builder().userId(petItemDTO.getPetItemId()).build())
                    .build();

            petItemRepository.save(petItemEntity);

        } catch (IOException e) {
            log.info("PetItem Error 1 : {} ", e.getMessage());
        }
    }
}
