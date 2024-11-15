package kr.or.ddit.case06.controller;


import lombok.Data;

import java.io.Serializable;

@Data
public class DummyDTO implements Serializable {
    private String who;
    private String age;
    private String gender;
}
