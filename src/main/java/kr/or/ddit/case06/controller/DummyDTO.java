package kr.or.ddit.case06.controller;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DummyDTO implements Serializable {
    private String pk;
    private String who;
    private String age;
    private String gender;
    private LocalDateTime now;
}
